package com.pratik.oauthdemo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="user_details")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Role> roles;
	
	public User(){
		
	}
	public User(String username, String password, List<Role> roles) {
		// TODO Auto-generated constructor stub
		this.username=username;
		this.password = password;
		this.roles= roles;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
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
	
	

}
