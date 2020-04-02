package com.token.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.token.model.SMSMaster;
import com.token.model.User;
import com.token.repository.SMSMasterRepo;
import com.token.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;

	@Autowired
	private SMSMasterRepo smsMstRepo;

	public Map<String, Object> storeTemplate(HttpServletRequest request, Map<String, Object> reqBody) {
		Map<String, Object> response = this.validateTokenAndUser(request);
		if (response.containsKey("isValid")) {
			Long smsMasterId = Long.valueOf(reqBody.get("smsTemplateId").toString());
			SMSMaster smsMstDB = this.smsMstRepo.getOne(smsMasterId);
			if (smsMstDB != null) {
				response.put("message", "Successfull...");
			}
		}
		return response;
	}

	private Map<String, Object> validateTokenAndUser(HttpServletRequest request) {
		String token = request.getHeader("token");
		String mobileNo = request.getHeader("mobileNo");
		String password = request.getHeader("password");
		User user = repo.findByToken(token);
		if (user == null) {
			Map<String, Object> response = new HashMap<String, Object>();
			response.put("message", "Invalid token..");
			return response;
		} else {
			return this.validateUser(mobileNo, password);

		}

	}

	private Map<String, Object> validateUser(String mobileNo, String password) {
		Map<String, Object> response = new HashMap<String, Object>();
		User user = repo.findByCredentials(mobileNo, password);
		if (user != null) {
			response.put("isValid", true);
			return response;
		} else {
			response.put("message", "Invalid user id or password..");
			return response;
		}
	}

}
