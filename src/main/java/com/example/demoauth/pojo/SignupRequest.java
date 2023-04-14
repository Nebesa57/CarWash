package com.example.demoauth.pojo;

import java.util.Set;

public class SignupRequest {
	
	private String username;
	private String numberMobile;
	private Set<String> roles;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getnumberMobile() {
		return numberMobile;
	}
	public void setnumberMobile(String numberMobile) {
		this.numberMobile = numberMobile;
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
