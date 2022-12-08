package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		menu2(in, employees);
		employees.forEach(employee -> System.out.println(employee.getFirstName()));
		}

	static void menu2(Scanner in, List<Employee> employees) {
		StringBuilder menu = new StringBuilder();
		menu.append("Options:\n1. Add\n2. Update\n3. Remove\n4. List\n5. Quit");
		String selectedOption = "-1";
		System.out.println(menu);
		selectedOption = in.next();
		switch (selectedOption) {
			case "1":
				//adding eploy
				addEmployee(in, employees);
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			default: // custom exception
		}
		in.close();
	}
	static void addEmployee(Scanner in, List<Employee> employees){

		System.out.println("\n-------------------\nAdding an employee\n\nFirst Name: ");
		in.next();
		String firstName = in.nextLine();
		System.out.println("Last Name: ");
		String lastName = in.nextLine();
		System.out.println("Set Salary: ");
		int salary = in.nextInt();
		System.out.println("Department: ");
		in.next();
		String department = in.nextLine();
		Employee newEmployee = new Employee(firstName, lastName, salary, department);
		employees.add(newEmployee);
	}

}
