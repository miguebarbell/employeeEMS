package org.example;


import org.junit.jupiter.api.Test;

class DatabaseTest {
	Database database = new Database();
	@Test
	void findEmployee() {
		Employee charles = new Employee("Charles", "Dunn", 75000, "Instructors");
		database.employees.add(charles);
		String charlesFirstName = database.findEmployee(1).getFirstName();
		assert (charles.getFirstName().equals(charlesFirstName));
	}

}
