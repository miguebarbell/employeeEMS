package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class Main {
	public static void main(String[] args) {
		String path = "resources/database.data";
		File inFile = new File(path);
		
		Database database = new Database();
		//read in state of employee list
		try(FileInputStream in = new FileInputStream(inFile);
				ObjectInputStream reader = new ObjectInputStream(in)){
			
			database = (Database) reader.readObject();
//			System.out.println(people);
//			for (Object p : people) {
//				if (p instanceof Person) {
//					
//				}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Employee e1 = new Employee();
		int currentCount = database.getLastID();
		e1.setCount(currentCount);
		
		//Database database = new Database();
		Scanner in = new Scanner(System.in);
		menu2(in, database);
		
		String outPath = "resources/";
		File file = new File(outPath + "database.data");

		//write out current state of list
		try(FileOutputStream out = new FileOutputStream(file);
				ObjectOutputStream writer = new ObjectOutputStream(out)){
			writer.writeObject(database);
		} catch (IOException e) {
//			System.out.println("File not found");
			e.printStackTrace();
		}
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
