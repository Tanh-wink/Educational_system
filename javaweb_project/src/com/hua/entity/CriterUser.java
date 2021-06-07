package com.hua.entity;

public class CriterUser {
	
	private String name;
	
	private String username;
	
	private String identity;

	public String getName() {
		if(name == null)
			name = "%%";
		else
			name = "%" + name + "%";
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		if(username == null)
			username = "%%";
		else
			username = "%" + username + "%";
		
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIdentity() {
		if(identity == null)
			identity = "%%";
		else
			identity = "%" + identity + "%";
		
		return identity;
	}

	public void setPhone(String phone) {
		this.identity = phone;
	}

	public CriterUser(String username, String name, String identity) {
		super();
		this.name = name;
		this.username = username;
		this.identity = identity;
	}

	public CriterUser() {
		super();
	}
	
}
