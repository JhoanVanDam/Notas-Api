package com.notas.api.entidades;

public class JwtRequest {
	private String Username;
	private String Password;

	public JwtRequest(String username, String password) {
		super();
		Username = username;
		Password = password;
	}

	public JwtRequest() {
		super();
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
}
