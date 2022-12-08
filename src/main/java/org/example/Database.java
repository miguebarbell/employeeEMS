package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Database {
	public List<Employee> employees;

	Database() {
		this.employees = new ArrayList<Employee>();
	}

	void addEmployee(Scanner in) {
		System.out.println("\n-------------------\nAdding an employee\n\nFirst Name: ");
		String firstName = in.nextLine();
		System.out.println("Last Name: ");
		String lastName = in.nextLine();
		System.out.println("Set Salary: ");
		int salary = in.nextInt();
		in.nextLine();
		System.out.println("Department: ");
//		in.nextLine();
		String department = in.nextLine();
		Employee newEmployee = new Employee(firstName, lastName, salary, department);
		employees.add(newEmployee);
		System.out.println("Added " + newEmployee.getFirstName() + " " + newEmployee.getLastName());
	}
	void listEmployees() {
		employees.forEach(employee -> {
			System.out.println(employee.toString());
		});
	}
}
