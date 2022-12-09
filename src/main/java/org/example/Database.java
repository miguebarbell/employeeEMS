package org.example;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Database implements Serializable{
	private static final long serialVersionUID = 1L;
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
		int salary = 0;
		try {
			salary = in.nextInt();
			in.nextLine();
			System.out.println("Department: ");
			String department = in.nextLine();
			Employee newEmployee = new Employee(firstName, lastName, salary, department);
			employees.add(newEmployee);
			System.out.println("Added " + newEmployee.getFirstName() + " " + newEmployee.getLastName());
		} catch (NumberFormatException e) {
			System.out.println("Invalid number");
		} catch (Exception e) {
			System.out.println("Invalid salary");
		}
	}

	void listEmployees() {
		employees.forEach(employee -> {
			System.out.println(employee.toString());
		});
		System.out.println("---------\n");
	}

	public void changeFunction(Scanner scan) {
		System.out.println("Enter ID of who you want to change");
		int tempId = scan.nextInt();
		scan.nextLine();
		try {
			Employee employee = findEmployee(tempId);
			if (null == employee) {
				throw new UserNotFound();
			}
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
		} catch (UserNotFound e) {
			System.out.println("Not a valid ID");
		} catch (InputMismatchException e) {
			System.out.println("Invalid as salary");
		} catch (Exception e) {
			System.out.println("Not an option");
		}
	}


	public Employee findEmployee(int id) {

		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getEmployeeId() == id) {
				return employees.get(i);
			}
		}
		return null;
	}

	public void deleteEmployee(Scanner scan) {
		System.out.println("Enter the ID of the employee you want to remove: ");
		int tempId = scan.nextInt();
		scan.nextLine();
		try {
			if (employees.stream()
			             .filter(employee -> employee.getEmployeeId() == tempId)
			             .count() < 1) {
				throw new UserNotFound();
			} else {
				employees = employees.stream()
				                     .filter(employee -> employee.getEmployeeId() != tempId)
				                     .collect(Collectors.toList());
				System.out.println("User Removed");
			}
		} catch (UserNotFound e) {
			System.out.println("id User : " + tempId + " not found.");
		}
	}
	
	public int getLastID() {
		int size = employees.size();
		int lastID = 0;
		if(size != 0)
			lastID = employees.get(size-1).getEmployeeId();
		return lastID;
	}
}
