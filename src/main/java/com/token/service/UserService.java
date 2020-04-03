package com.token.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.token.model.TemplateMaster;
import com.token.model.User;
import com.token.repository.MasterRepo;
import com.token.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;

	@Autowired
	private MasterRepo mstRepo;

	public Map<String, Object> verifytoken(HttpServletRequest request, Map<String, Object> reqBody) {
		Map<String, Object> response = this.validateTokenAndUser(request);
		if (response.containsKey("Datasuccesmessage")) {
			Long masterId = Long.valueOf(reqBody.get("templateId").toString());
			TemplateMaster mstDB = this.mstRepo.getOne(masterId);
			if (mstDB != null) {
				response.put("Datasuccesmessage", "Successfull...");
			}
		}
		return response;
	}

	private Map<String, Object> validateTokenAndUser(HttpServletRequest request) {
		String token = request.getHeader("token");
		String username = request.getHeader("username");
		String password = request.getHeader("password");
		User user = repo.findByToken(token);
		if (user == null) {
			Map<String, Object> response = new HashMap<String, Object>();
			response.put("Tokenmessage", "Invalid token..");
			return response;
		} else {
			return this.validateUser(username, password);

		}

	}

	private Map<String, Object> validateUser(String username, String password) {
		Map<String, Object> response = new HashMap<String, Object>();
		User user = repo.findByCredentials(username, password);
		if (user != null) {
			response.put("Yes Valid data:", true);
			return response;
		} else {
			response.put("DataFailMessage", "Invalid user id or password..");
			return response;
		}
	}

}
