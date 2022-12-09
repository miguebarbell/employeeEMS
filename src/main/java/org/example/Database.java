package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Database {
	public List<Employee> employees;

	Database() {
		this.employees = new ArrayList<>();
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

	public void changeFunction(Scanner scan) { 
		
		System.out.println("Enter ID of who you want to change");
		int tempId = scan.nextInt();
		scan.nextLine();
		
		Employee employee = findEmployee(tempId);
		
		System.out.println("New first name: ");
		String newFirstName = scan.nextLine();
		employee.setFirstName(newFirstName);	
		
		System.out.println("New last name: ");
		String newLastName = scan.nextLine();
		employee.setLastName(newLastName);
		
		System.out.println("New Salary: ");
		int newSalary = scan.nextInt();
		employee.setSalary(newSalary);
		
		scan.nextLine();
		System.out.println("New Department: ");
		String newDepartment = scan.nextLine();
		employee.setDepartment(newDepartment);
		
		
		
		
	}
	
	
	public Employee findEmployee(int id) {
		
		for (int i = 0; i < employees.size(); i++) {
			if(employees.get(i).getEmployeeId() == id) {return employees.get(i);} 
		}
			return null; //if not there return null
	}
	
///////////////////////////////////////////////////////////////////////////////////////////	
	
/////////////////////////////NEW CODE////////////////////////	
	public void deleteEmployee(Scanner scan) {
		
		System.out.println("Enter the ID of the employee you want to remove: ");
		int tempId = scan.nextInt();
		scan.nextLine();																																					
		int exception = 1;
		
		for (int i = 0; i < employees.size(); i++) {
			
			
			
			if (employees.get(i).getEmployeeId() == tempId) {exception = 0;}

			if(exception == 1) {
				System.out.println("INVALID ID");
			} else {
				employees.remove(employees.get(i));
				System.out.println("Employee Removed");
			}

			
//			System.out.println("IT RAN");
				
		}
		
	}
		
//////////////////////////////////////////////////////////////		
		
		
	
}
