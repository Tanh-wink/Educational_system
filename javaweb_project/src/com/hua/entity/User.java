package com.hua.entity;

public class User {
	private String username;    //用户名
	private String password;    //密码
	private String name;    	//用户姓名
	private String identity;     //登录身份：学生、教师、教务员、管理员
	private String findMMproof;     //找回密码凭据
	private String password_last_changed;  //上一次修改密码的时间
	private String login_last_time;    //最近一次登录的时间
	
	public User() {
		super();
	}

	
	
	public User(String username, String password, String name, String identity,
			String findMMproof, String password_last_changed, String login_last_time) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.identity = identity;
		this.findMMproof = findMMproof;
		this.password_last_changed = password_last_changed;
		this.login_last_time = login_last_time;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword_last_changed() {
		return password_last_changed;
	}
	
	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	public String getFindMMproof() {
		return findMMproof;
	}

	public void setFindMMproof(String findMMproof) {
		this.findMMproof = findMMproof;
	}

	public String getLogin_last_time() {
		return login_last_time;
	}

	public void setLogin_last_time(String login_last_time) {
		this.login_last_time = login_last_time;
	}

	public void setPassword_last_changed(String password_last_changed) {
		this.password_last_changed = password_last_changed;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", name=" + name + ", identity=" + identity + ", findMMproof="
				+ findMMproof + ", password_last_changed=" + password_last_changed
				+ ", login_last_time=" + login_last_time + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((findMMproof == null) ? 0 : findMMproof.hashCode());
		result = prime * result
				+ ((identity == null) ? 0 : identity.hashCode());
		result = prime * result
				+ ((login_last_time == null) ? 0 : login_last_time.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime
				* result
				+ ((password_last_changed == null) ? 0 : password_last_changed
						.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (findMMproof == null) {
			if (other.findMMproof != null)
				return false;
		} else if (!findMMproof.equals(other.findMMproof))
			return false;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		if (login_last_time == null) {
			if (other.login_last_time != null)
				return false;
		} else if (!login_last_time.equals(other.login_last_time))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (password_last_changed == null) {
			if (other.password_last_changed != null)
				return false;
		} else if (!password_last_changed.equals(other.password_last_changed))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
