package org.example;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Database database = new Database();
		Scanner in = new Scanner(System.in);
		menu2(in, database);
	}

	static void menu2(Scanner in, Database database) {
		StringBuilder menu = new StringBuilder();
		menu.append("Options:\n1. Add\n2. Update\n3. Remove\n4. List\n5. Quit");
		String selectedOption = "-1";
		while (!selectedOption.equals("5")) {
			System.out.println(menu);
			selectedOption = in.nextLine();
			try {
				switch (selectedOption) {
					case "1":
						database.addEmployee(in);
						break;
					case "2":
						database.changeFunction(in);
						break;
					case "3":
						database.deleteEmployee(in);
						break;
					case "4":
						database.listEmployees();
						break;
					case "5":
						break;
					default:
						throw new MenuException();
				}
			} catch (MenuException e) {
				System.out.println("Invalid Option");
			}
		}
	}
}
