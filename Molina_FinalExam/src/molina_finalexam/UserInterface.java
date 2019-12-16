/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_finalexam;

import java.util.Scanner;

/**
 *
 * @author barrymolina
 */
public class UserInterface {

	int selection;
	final int QUIT = -999;

	Scanner keyboard = new Scanner(System.in);

	public void mainMenu() {
		System.out.println();
		System.out.println("\tMain Menu\n");
		System.out.println("1) Add new student");
		System.out.println("2) Search student by name");
		System.out.println("3) Search student by number");
		System.out.println("4) Get grade summary for all students");
		System.out.println("5) Quit");
		System.out.println();
		System.out.print("Enter your selection: ");
		selection = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println("\n");
	}

	public void studentInfo(Student s) {
		System.out.println();
		System.out.println("\tStudent Menu");
		System.out.println();
		System.out.println("Name: " + s.getName() + "\tNumber: " + s.getNumber());
		System.out.println();
		System.out.println("1) Input Assignment scores");
		System.out.println("2) Input Discussion Topic scores");
		System.out.println("3) Input Exam scores");
		System.out.println("4) Input Individual Project Score");
		System.out.println("5) Get category totals and final letter grade");
		System.out.println("6) Return to Main Menu");
		System.out.println();
		System.out.print("Enter your selection: ");
		selection = keyboard.nextInt();
		keyboard.nextLine();
		System.out.println("\n");
		
	}
	public void notFound() {
		System.out.println("\nError: Student not found\n");
	}
	public void multipleFound() {
		System.out.println("\nError: Multiple students found with that name."
				+ " Please search by student number.\n");
	}

	public int getSelection() {
		return selection;
	}
	
	public String inputName() {
		System.out.print("Enter student name: ");
		return keyboard.nextLine();
	}
	public int inputNumber() {
		System.out.print("Enter student number: ");
		return keyboard.nextInt();
	}
	public void inputAssignments(int[] assignments) {
		int x = 0;
		int score = 0;

		System.out.println("\tInput Assignments");
		System.out.println();
		
		while  (x < assignments.length && score != QUIT) {
			System.out.print("Enter score for assignment " + (x + 1)  
					+ " or " + QUIT + " to quit: ");
			score = keyboard.nextInt();
			System.out.println();
			if (score != QUIT) {
				assignments[x] = score;
				x++;
			}
		}
	}
	public void inputDiscussions(int[] discussions) {
		int x = 0;
		int score = 0;

		System.out.println("\tInput Discussion Topics");
		System.out.println();

		while  (x < discussions.length && score != QUIT) {
			System.out.print("Enter score for discussion " + (x + 1)  
					+ " or " + QUIT + " to quit: ");
			score = keyboard.nextInt();
			System.out.println();
			if (score != QUIT) {
				discussions[x] = score;
				x++;
			}
		}
	}
	public void inputExams(int[] exams) {
		int x = 0;
		int score = 0;

		System.out.println("\tInput Exams");
		System.out.println();
		
		while  (x < exams.length && score != QUIT) {
			System.out.print("Enter score for exam " + (x + 1)  
					+ " or " + QUIT + " to quit: ");
			score = keyboard.nextInt();
			System.out.println();
			if (score != QUIT) {
				exams[x] = score;
				x++;
			}
		}
	}
	public int inputProject() {
		int score = 0;
		System.out.println("\tInput Individual Project");
		System.out.println();
		System.out.print("Enter score for Individual Project: ");
		score = keyboard.nextInt();
		System.out.println();

		return score;
	}
	public void outputAssignments(Student s) {
		int[] assignments = s.getAssignments();

		System.out.println("\tAssignment Summary");
		System.out.println();
		System.out.println("Name: " + s.getName() + "\tNumber: " + s.getNumber());
		System.out.println();

		for (int x = 0; x < assignments.length; x++) {
			System.out.println("Assignment " + (x + 1) + ": " + assignments[x]);
		}
		System.out.println();
		System.out.println("Assignments Total: " + s.getAssignTotal());
		System.out.println();
		System.out.print("(Press <enter> to contine)");
		keyboard.nextLine();
		keyboard.nextLine();
	}
	public void outputDiscussions(Student s) {
		int[] discussions = s.getDiscussions();

		System.out.println("\tDiscussion Topics Summary");
		System.out.println();
		System.out.println("Name: " + s.getName() + "\tNumber: " + s.getNumber());
		System.out.println();

		for (int x = 0; x < discussions.length; x++) {
			System.out.println("Discussion Topic " + (x + 1) + ": " + discussions[x]);
		}
		System.out.println();
		System.out.println("Discussion Topics Total: " + s.getDiscussTotal());
		System.out.println();
		System.out.print("(Press <enter> to contine)");
		keyboard.nextLine();
		keyboard.nextLine();
	}
	public void outputExams(Student s) {
		int[] exams = s.getExams();

		System.out.println("\tExams Summary");
		System.out.println();
		System.out.println("Name: " + s.getName() + "\tNumber: " + s.getNumber());
		System.out.println();

		for (int x = 0; x < exams.length; x++) {
			System.out.println("Exam " + (x + 1) + ": " + exams[x]);
		}
		System.out.println();
		System.out.println("Exams Total: " + s.getExamTotal());
		System.out.println();
		System.out.print("(Press <enter> to contine)");
		keyboard.nextLine();
		keyboard.nextLine();
	}
	public void outputProject(Student s) {

		System.out.println("\tIndividual Project Summary");
		System.out.println();
		System.out.println("Name: " + s.getName() + "\tNumber: " + s.getNumber());

		System.out.println();
		System.out.println("Individual Project Total: " + s.getProject());
		System.out.println();
		System.out.print("(Press <enter> to contine)");
		keyboard.nextLine();
		keyboard.nextLine();
	}

	public void outputGrades(Student[] students) {
		int x = 0;

		System.out.println("\t Class Grades");
		System.out.println();
		System.out.println("Name\t\t\tNumber\t\t\tGrade\n");
		while (x < students.length && students[x] != null) {
			System.out.printf("%-14s\t\t%-14s\t\t%-14s\n", students[x].getName(),
								students[x].getNumber(), students[x].getGrade());
			x++;
		}
	}
	public void outputTotals(Student s) {
		System.out.println("\tStudent Summary");
		System.out.println();
		System.out.println("Name:" + s.getName() + "\tNumber:" + s.getNumber());
		System.out.println();

		System.out.printf("%26s%d\n", "Assignment Total: ", s.getAssignTotal());
		System.out.printf("%26s%d\n", "Discussions Total: ", s.getDiscussTotal());
		System.out.printf("%26s%d\n", "Exams Total: ", s.getExamTotal());
		System.out.printf("%26s%d\n", "Individual Project Score: ", s.getProject());
		System.out.println();
		System.out.printf("%26s%s\n", "Final Grade: ", s.getGrade());
		System.out.println();
		System.out.print("(Press <enter> to contine)");
		keyboard.nextLine();
	}
}
