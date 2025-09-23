package Code;

import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
	private int id;
	private String name;
	private double marks;

	public Student(int id, String name, double marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [ID=" + id + ", Name=" + name + ", Marks=" + marks + "]";
	}
}

public class StudentRecordManagementSystem {
	private static ArrayList<Student> students = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("\n****** Student Record Management System *****");
			System.out.println("1. Add Student");
			System.out.println("2. View Students");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1 -> addStudent();
			case 2 -> viewStudents();
			case 3 -> updateStudent();
			case 4 -> deleteStudent();
			case 5 -> System.out.println("Exiting... Goodbye!");
			default -> System.out.println("Invalid choice! Try again.");
			}
		} while (choice != 5);
	}

	// Add student
	private static void addStudent() {
		System.out.print("Enter ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Marks: ");
		double marks = sc.nextDouble();

		students.add(new Student(id, name, marks));
		System.out.println("Student added successfully!");
	}

	// View students
	private static void viewStudents() {
		if (students.isEmpty()) {
			System.out.println("No student records found.");
		} else {
			System.out.println("\n--- Student Records ---");
			for (Student s : students) {
				System.out.println(s);
			}
		}
	}

	// Update student
	private static void updateStudent() {
		System.out.print("Enter Student ID to update: ");
		int id = sc.nextInt();
		boolean found = false;

		for (Student s : students) {
			if (s.getId() == id) {
				sc.nextLine(); 
				System.out.print("Enter New Name: ");
				String name = sc.nextLine();
				System.out.print("Enter New Marks: ");
				double marks = sc.nextDouble();

				s.setName(name);
				s.setMarks(marks);
				System.out.println("Student updated successfully!");
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Student with ID " + id + " not found.");
		}
	}

	// Delete student
	private static void deleteStudent() {
		System.out.print("Enter Student ID to delete: ");
		int id = sc.nextInt();
		boolean removed = students.removeIf(s -> s.getId() == id);

		if (removed) {
			System.out.println("Student deleted successfully!");
		} else {
			System.out.println("Student with ID " + id + " not found.");
		}
	}
}
