package com.token.controller;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.token.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private HttpServletRequest request;

	@PostMapping("/verifytoken")
	public ResponseEntity<Object> storeTemplate(@RequestBody Map<String, Object> reqBody) {
		return new ResponseEntity<Object>(service.storeTemplate(this.request, reqBody), HttpStatus.OK);
	}
}
