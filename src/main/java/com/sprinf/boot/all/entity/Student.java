package com.sprinf.boot.all.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "StudentCurd")
public class Student {

	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "fname")
	private String fname;
	@Column(name = "lname")
	private String lname;

	public String getFname() {
		return fname;
	}

	public String getId() {
		return id;
	}

	public String getLname() {
		return lname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

}
