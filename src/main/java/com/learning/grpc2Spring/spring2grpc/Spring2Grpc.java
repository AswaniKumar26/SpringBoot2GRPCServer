package com.learning.grpc2Spring.spring2grpc;


import com.learning.grpc2Spring.autogen.User.APIResponse;
import com.learning.grpc2Spring.autogen.User.LoginRequest;
import com.learning.grpc2Spring.model.LoginResponse;
import com.learning.grpc2Spring.model.UserRecord;
import com.learning.grpc2Spring.autogen.userGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Spring2Grpc {
	
	ManagedChannel channel = null;
	String host ="localhost";
	int port = 10001;
	String userName;
	String password;
	userGrpc.userBlockingStub stub = null;
	
	public Spring2Grpc() {
		buildChannel();
		buildBlockingStub();
	}
	
	private void buildChannel() {
		if(channel == null) {
			channel = ManagedChannelBuilder.forAddress(host,port).
	                  usePlaintext().build();
		}
	}
	
	private void buildBlockingStub () {
		if(stub == null) {
			stub = userGrpc.newBlockingStub(channel);
		}
	}
	
	
	private LoginRequest buildLoginMessage(String name,String pass) {
		LoginRequest req = LoginRequest.newBuilder().setUsername(name).setPassword(pass).build();
		return req;
	}
	
	public LoginResponse Spring2GrpcCall(UserRecord rec) {
		LoginRequest req = buildLoginMessage(rec.getUserName(),rec.getPassword());
		APIResponse resp = stub.login(req);
		LoginResponse response = new LoginResponse(resp.getResponseCode(),resp.getResponsemessage());
		return response;
	}
}
