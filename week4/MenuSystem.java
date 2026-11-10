package week4;

import java.util.Scanner;

// This program demonstrates a do-while loop using a menu system.
public class MenuSystem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n========================================");
			System.out.println(" STUDENT MANAGEMENT SYSTEM");
			System.out.println("========================================");
			System.out.println("1. Add Student");
			System.out.println("2. View All Students");
			System.out.println("3. Search Student");
			System.out.println("4. Exit");
			System.out.println("========================================");
			System.out.print("Enter your choice (1-4): ");

			choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character.

			switch (choice) {
				case 1:
					System.out.print("Enter student name: ");
					String name = scanner.nextLine();
					System.out.println("Student '" + name + "' added successfully.");
					break;
				case 2:
					System.out.println("Displaying all students...");
					System.out.println("(This is a simulation - no data stored yet.)");
					break;
				case 3:
					System.out.print("Enter student name to search: ");
					String searchName = scanner.nextLine();
					System.out.println("Searching for '" + searchName + "'...");
					System.out.println("(This is a simulation - no data stored yet.)");
					break;
				case 4:
					System.out.println("\nThank you for using the Student Management System.");
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
					break;
			}
		} while (choice != 4);

		scanner.close();
	}
}
