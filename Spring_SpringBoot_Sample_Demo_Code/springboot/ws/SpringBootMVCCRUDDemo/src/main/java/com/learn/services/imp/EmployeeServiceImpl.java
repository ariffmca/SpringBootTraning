package com.learn.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.learn.daos.EmployeeDAO;
import com.learn.models.Employee;
import com.learn.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
    private EmployeeDAO employeeDAO;
	
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> empList = (List<Employee>) employeeDAO.findAll();
		//employeeDAO.findAll().forEach(empList::add);
		return empList;
	}

	@Override
	public Employee getEmployee(Integer empId) {
		return employeeDAO.findById(empId).get();
	}

	@Override
	public String addEmployee(Employee employee) {
		return (employeeDAO.save(employee)!=null ? "Saved Successfully" : "Insert Error");

	}

	@Override
	public String updateEmployee(Integer empId, Employee employee) {
		
		Optional<Employee> container =  employeeDAO.findById(empId);
		
		Employee empToUpdate = container.get();
		empToUpdate.setFirstName(employee.getFirstName());
		empToUpdate.setMidName(employee.getMidName());
		empToUpdate.setLastName(employee.getLastName());
		empToUpdate.setSalary(employee.getSalary());

		return (employeeDAO.save(empToUpdate)!=null ? "Updated Successfully" : "Update Error");
	}

	@Override
	public String deleteEmployee(Integer empId) {
		String returnVal ="Deleted Successfully";
		try {
			employeeDAO.deleteById(empId);
		}catch(Exception e) {
			returnVal = "Delete Error";
		}
		
		return returnVal;
	}

}
