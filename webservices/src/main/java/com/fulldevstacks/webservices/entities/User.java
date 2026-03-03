package com.fulldevstacks.webservices.entities;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	public User() {}

	public User(Long id, String name, String email, String password) 
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Long GetId() {
		return id;
	}

	public void SetId(Long id) {
		this.id = id;
	}

	public String GetName() {
		return name;
	}

	public void SetName(String name) {
		this.name = name;
	}

	public String GetEmail() {
		return email;
	}

	public void SetEmail(String email) {
		this.email = email;
	}
	
	public String GetPhone() {
		return phone;
	}

	public void SetPhone(String phone) {
		this.phone = phone;
	}

	public String GetPassword() {
		return password;
	}

	public void SetPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}
}
