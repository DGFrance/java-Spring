package com.SpringTraining;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeesController {
	List<Employees> employees = new ArrayList<>();

	public EmployeesController() {
		this.employees.add(new Employees("1", "Leo", "Male"));
		this.employees.add(new Employees("2", "Jac", "Female"));
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	@ResponseBody
	public List<Employees> getEmployeegender(@RequestParam(value = "gender", defaultValue = "male") String Gender) {
		return this.employees.stream().filter(s -> s.getGender().equalsIgnoreCase(Gender)).collect(Collectors.toList());
	}

	@RequestMapping(value = "/employees2", method = RequestMethod.POST)
	@ResponseBody
	public Employees getAllEmployee(@RequestBody Employees AllEmployee) {
		this.employees.add(AllEmployee);
		return AllEmployee;
	}

	@RequestMapping(value = "/employees3/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Employees getEmployees3(@PathVariable String id) {
		Employees employeesId = this.employees.stream().filter(s -> s.getId().equalsIgnoreCase(id)).findFirst()
				.orElse(null);
		if (employeesId == null) {
			throw new EmployeeNotFoundException();
		} else {
			return employeesId;
		}
	}
}