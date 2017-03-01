package com.micro.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy="role")
	private List<User> users;
	
	@ManyToMany
	private List<Authority> authoritys;
	
	private String roleAuthority;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Authority> getAuthoritys() {
		return authoritys;
	}

	public void setAuthoritys(List<Authority> authoritys) {
		this.authoritys = authoritys;
	}

	public String getRoleAuthority() {
		return roleAuthority;
	}

	public void setRoleAuthority(String roleAuthority) {
		this.roleAuthority = roleAuthority;
	}
	
}
