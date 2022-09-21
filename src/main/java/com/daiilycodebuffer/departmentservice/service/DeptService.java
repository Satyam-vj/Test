package com.daiilycodebuffer.departmentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.daiilycodebuffer.departmentservice.entity.Department;
import com.daiilycodebuffer.departmentservice.repository.DepartmentRepo;

@Service
public class DeptService {

	@Autowired
	private DepartmentRepo departmentRepo;

	public Department saveDept(Department dept) {

		
		return departmentRepo.save(dept);
	}

	public List<Department> findalldept() {
		return departmentRepo.findAll();
	}

	public List<Department> findAlldeptSorted(String field){
		return departmentRepo.findAll(Sort.by(Sort.Direction.DESC,field));
	}
	
	public Page<Department> findDeptwithPagination(int offset,int pageSize){
		return departmentRepo.findAll(PageRequest.of(offset, pageSize));
		
	}
	
	public Page<Department> findDeptwithPaginationAndSorting(int offset,int pageSize,String field){
		return departmentRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
		
	}
}