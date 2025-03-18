package assignment.student;

/*
 * Assuming there are 20 students in the COS 463 class list.
 * Write a Java program to list their names and numbers.
 *
 * java 21
 */

import java.util.*;

public class StudentList {
	public static void main(String[] args) {
		ArrayList<Student> students = getStudentList();
		printStudentList(students);
	}

	// Iterates over the student list printing their names and regno to the terminal
	private static void printStudentList(ArrayList<Student> students) {
		for(Student student : students) {
			System.out.printf("Name: %s, Reg No: %s%n", student.name(), student.regNumber());
		}
	}

	// This method returns the student list
	private static ArrayList<Student> getStudentList() {
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("Orji Chigbo Bright", "2021/243888"));
		students.add(new Student("Kalu Victor", "2021/243697"));
		return students;
	}
}
