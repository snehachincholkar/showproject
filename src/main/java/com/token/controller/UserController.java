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
	public ResponseEntity<Object> verifytoken(@RequestBody Map<String, Object> requestBody) {
		return new ResponseEntity<Object>(service.verifytoken(this.request, requestBody), HttpStatus.OK);
	}
}
