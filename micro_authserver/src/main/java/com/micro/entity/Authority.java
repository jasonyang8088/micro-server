package com.micro.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Authority {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="parent_id",columnDefinition="bigint",insertable=false,updatable=false)
	@NotFound(action=NotFoundAction.IGNORE)
	private Authority parent;
	
	@Column(name="parent_id",columnDefinition="bigint")
	private Long parentId;
	
	@OneToMany(mappedBy="parent")
	private List<Authority> children;
	
	@ManyToMany(mappedBy="authoritys")
	private List<Role> roles;

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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Authority getParent() {
		return parent;
	}

	public void setParent(Authority parent) {
		this.parent = parent;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public List<Authority> getChildren() {
		return children;
	}

	public void setChildren(List<Authority> children) {
		this.children = children;
	}
	
}
