package com.zdy.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "Z_Resource")
public class Resources implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7425594037527886435L;

	@Id	
	@Column(name="id", unique = true, nullable = false, precision = 10, scale = 0)	
	@SequenceGenerator(name="my_seq",allocationSize=1,initialValue=1, sequenceName="SQ_ZRESOURCE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="my_seq")
    private Long id;

	@Column(length = 20)
	private String name;

	@Column(length = 40)
	private String url;
	
	@Column(length = 40)
	private Long pid;
	@ManyToMany  
    @JoinTable(name="Z_ROLE_RESOURCE",joinColumns={@JoinColumn(name="resourceid")},inverseJoinColumns={@JoinColumn(name="roleid")})
	private Set<Role> roleSet;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}
    //注意：joinColumns是指自己表在关系表（Z_ROLE_RESOURCE）中的外键，inverseJoinColumns 是对方表即z_resource表在关系表中的外键  
	public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}
}
