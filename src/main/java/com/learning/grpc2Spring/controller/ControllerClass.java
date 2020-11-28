package com.learning.grpc2Spring.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.grpc2Spring.model.LoginResponse;
import com.learning.grpc2Spring.model.UserRecord;
import com.learning.grpc2Spring.spring2grpc.Spring2Grpc;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class ControllerClass {

	private ResponseEntity<LoginResponse> sendResponse(LoginResponse cur) {
		if (cur != null) {
			return new ResponseEntity<LoginResponse>(cur, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(path = "/login", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<LoginResponse> login(@RequestBody UserRecord request)  {
		Spring2Grpc grpcCaller = new Spring2Grpc();
		LoginResponse response = grpcCaller.Spring2GrpcCall(request);
		
	    return sendResponse(response);
	}

}
