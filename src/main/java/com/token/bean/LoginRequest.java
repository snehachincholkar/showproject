package com.token.bean;

public class LoginRequest {

    private String username;
    private String password;
    private String templatemsg;

    
    @Override
	public String toString() {
		return "LoginRequest [username=" + username + ", password=" + password + ", templatemsg=" + templatemsg + "]";
	}

	public String getTemplatemsg() {
		return templatemsg;
	}

	public void setTemplatemsg(String templatemsg) {
		this.templatemsg = templatemsg;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
