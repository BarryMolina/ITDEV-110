/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_finalexam;

/**
 *
 * @author barrymolina
 */
public class Controller {
	UserInterface ui;
	GradeBook gb;
	Student[] students;

	int NOT_FOUND = -1;
	int MULTIPLE_FOUND = -9;


	public Controller() {
		ui = new UserInterface();
		gb = new GradeBook();
		students = gb.getStudents();
	}
	public void run() {
		boolean quit = false;

		while (!quit) {
			ui.mainMenu();
			switch (ui.getSelection()) {
				case 1: 
					addStudent();
					break;
				case 2:
					studentInfo(byName());
					break;
				case 3:
					studentInfo(byNumber());
					break;
				case 4: 
					ui.outputGrades(students);
					break;
				case 5:
					quit = true;
					break;
			}

		}
	}
	public void studentInfo(int stuIdx) {
		Student s;

		if (stuIdx == NOT_FOUND) {
			ui.notFound();
		}
		else if (stuIdx == MULTIPLE_FOUND) {
			ui.multipleFound();
		}
		else {
			boolean quit = false;
			s = students[stuIdx];

			while (!quit) {
				ui.studentInfo(s);
				switch (ui.getSelection()) {
					case 1: 
						inputAssignments(s);
						break;
					case 2:
						inputDiscussions(s);
						break;
					case 3:
						inputExams(s);
						break;
					case 4: 
						inputProject(s);
						break;
					case 5:
						ui.outputTotals(s);
						break;
					case 6:
						quit = true;
						break;
				}
			}
		}
	}
	
	//Functions for Main Menu
	public int byName() {
		String name;
		int stuIdx = 0;
		int student = NOT_FOUND;
		int numFound = 0;

		name = ui.inputName(); 

		stuIdx = 0;
		while (stuIdx < students.length && students[stuIdx] != null) {
			if (students[stuIdx].getName().equalsIgnoreCase(name)) {
				student = stuIdx;
				numFound++;
			}
			stuIdx++;
		}
		if (numFound > 1) {
			student = MULTIPLE_FOUND;
		}
		return student;
	}
	public int byNumber() {
		int number;
		int stuIdx = 0;
		int student = NOT_FOUND;

		number = ui.inputNumber();

		stuIdx = 0;
		while (stuIdx < students.length && students[stuIdx] != null) {
			if (students[stuIdx].getNumber() == number) {
				student = stuIdx;
			}
			stuIdx++;
		}
		return student;
	}
	public void addStudent() {
		String name;
		int number;

		name = ui.inputName();
		number = ui.inputNumber();

		studentInfo(gb.addStudent(name, number));
	}
	
	//Functions for Student Info
	public void inputAssignments(Student s) {
		ui.inputAssignments(s.getAssignments());

		s.calcAssignments();
		s.computeGrade();

		ui.outputAssignments(s);
	}
	public void inputDiscussions(Student s) {
		ui.inputDiscussions(s.getDiscussions());

		s.calcDiscussions();
		s.computeGrade();

		ui.outputDiscussions(s);
	}
	public void inputExams(Student s) {
		ui.inputExams(s.getExams());

		s.calcExams();
		s.computeGrade();

		ui.outputExams(s);
	}
	public void inputProject(Student s) {
		int score = ui.inputProject();
		if (score != ui.QUIT) {
			s.setProject(score);
		}
		s.computeGrade();

		ui.outputProject(s);
	}
}
