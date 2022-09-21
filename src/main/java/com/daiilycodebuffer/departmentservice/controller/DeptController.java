package com.daiilycodebuffer.departmentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daiilycodebuffer.departmentservice.entity.ApiResponse;
import com.daiilycodebuffer.departmentservice.entity.Department;
import com.daiilycodebuffer.departmentservice.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DeptController {

	@Autowired
	private DeptService depService;

	@PostMapping("/")
	public Department saveDept(@RequestBody Department dept) {
		log.info("inside saveDepartment method controller");
		return depService.saveDept(dept);

	}

	@GetMapping("/getDept")
	 public ApiResponse<List<Department>> getDept(){
		List<Department> alldept = depService.findalldept();
		return  new ApiResponse<>(alldept.size(), alldept);
		 
	 }
	
	@GetMapping("/getDept/{field}")
	public ApiResponse<List<Department>> getDeptwithSort(@PathVariable String field){
		List<Department> alldept = depService.findAlldeptSorted(field);
		return new ApiResponse<>(alldept.size(), alldept);
	}
	
	@GetMapping("/getDept/{offset}/{pageSize}")
	public ApiResponse<Page<Department>> getDeptwithPAgination(@PathVariable int offset, @PathVariable int pageSize){
		Page<Department> alldept = depService.findDeptwithPagination(offset, pageSize);
		return new ApiResponse<>(alldept.getSize(), alldept);
	}
	
	@GetMapping("/getDept/{offset}/{pageSize}/{field}")
	public ApiResponse<Page<Department>> getDeptwithPAginationAndSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
		Page<Department> alldept = depService.findDeptwithPaginationAndSorting(offset, pageSize, field);
		return new ApiResponse<>(alldept.getSize(), alldept);
	}
	
	
}
