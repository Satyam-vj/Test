package com.daiilycodebuffer.departmentservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptId;
	
	@Column(name = "deptName")	
	private String departmentName;
	
	@Column(name = "deptAdd")	
	private String departmentAddress;
	
	@Column(name = "deptCode")	
	private long departmentCode;
}
