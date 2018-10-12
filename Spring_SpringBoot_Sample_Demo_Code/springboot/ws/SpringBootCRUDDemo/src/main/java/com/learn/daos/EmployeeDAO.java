package com.learn.daos;

import org.springframework.data.repository.CrudRepository;

import com.learn.models.Employee;

public interface EmployeeDAO extends CrudRepository<Employee, Integer>{
	
	public Employee getByFirstName(String firstName);
	
	public Employee getByLastNameLike(String lastName);

}
