package org.example;

import java.time.LocalDate;

public class Employee {
	static int count = 0;
	String firstName;
	String lastName;
	int employeeId; // here use stream
	LocalDate dateOfEmployment;
	int salary;
//	Department department;
	String department;

	Employee(String firstName, String lastName, int salary, String department) {
		count++;
		this.employeeId = count;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.dateOfEmployment = LocalDate.now();
		this.department = department;
	}
	void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	void setLastName(String lastName) {
		this.lastName = lastName;
	}
	void setDepartment(String department) {
		this.department = department;
	}
	void setSalary(int salary) {
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public String getDepartment() {
		return department;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("----------\nID: " + employeeId + "\nFirst name: " + firstName + "\nLast name: " + lastName +
				"\nDepartment: " + department + "\nSalary: " + salary);
		return string.toString();
	}

	public int getEmployeeId() {
		return this.employeeId;
	}
}
