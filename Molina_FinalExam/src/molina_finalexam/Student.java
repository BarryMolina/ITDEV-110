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
public class Student {

	String name;
	int number;

	String letterGrade;
	final int NUM_ASSIGNMENTS = 10;
	final int NUM_DISCUSSIONS = 10;
	final int NUM_EXAMS = 2;
	final int ASSIGNMENT_SCORE = 50;
	final int DISCUSSION_SCORE = 10;
	final int EXAM_SCORE = 150;
	final int PROJECT_SCORE = 100;
	final int TOTAL_POSSIBLE;
	final int[] GRADE_CUTOFFS = {950, 900, 850, 800, 750, 700, 650, 600};
	final String[] LETTER_GRADES = {"A", "A-", "B+", "B", "B-", "C+", "C", "D"};
	final String LOWEST_GRADE = "F";
	int[] assignments;
	int[] discussions;
	int[] exams;
	int assignmentTotal;
	int discussionTotal;
	int examTotal;
	int project;
	int totalPoints;

	public Student(String name, int number) {
		this.name = name;
		this.number = number;

		assignments = new int[NUM_ASSIGNMENTS];
		discussions = new int[NUM_DISCUSSIONS];
		exams = new int[NUM_EXAMS];
		TOTAL_POSSIBLE = ASSIGNMENT_SCORE + DISCUSSION_SCORE + EXAM_SCORE + 
						PROJECT_SCORE;
		resetScores();
	}

	public String getName() {
		return name;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getGrade() {
		return letterGrade;
	}
	public int[] getAssignments() {
		return assignments;
	}
	public int[] getDiscussions() {
		return discussions;
	}
	public int[] getExams() {
		return exams;
	}
	public int getProject() {
		return project;
	}
	public void setProject(int score) {
		project = score;
	}
	public int getAssignTotal() {
		return assignmentTotal;
	}
	public int getDiscussTotal() {
		return discussionTotal;
	}
	public int getExamTotal() {
		return examTotal;
	}
	public void calcAssignments() {
		assignmentTotal = 0;
		for (int x = 0; x < assignments.length; x++) {
			assignmentTotal += assignments[x];
		}
	}
	public void calcDiscussions() {
		discussionTotal = 0;
		for (int x = 0; x < discussions.length; x++) {
			discussionTotal += discussions[x];
		}
	}
	public void calcExams() {
		examTotal = 0;
		for (int x = 0; x < exams.length; x++) {
			examTotal += exams[x];
		}
	}
	public void computeGrade() {
		int x = 0;
		boolean foundIt = false;

		totalPoints = assignmentTotal + discussionTotal + examTotal + project;

		while (x < GRADE_CUTOFFS.length && !foundIt) {
			if (totalPoints >= GRADE_CUTOFFS[x]) {
				foundIt = true;
				letterGrade = LETTER_GRADES[x];
			}
			x++;
		}
		if (!foundIt) {
			letterGrade = LOWEST_GRADE;
		}
		
		
	}
	public void resetScores() {
		for (int x = 0; x < assignments.length; x ++) {
			assignments[x] = 0;
		}
		for (int x = 0; x < discussions.length; x ++) {
			discussions[x] = 0;
		}
		for (int x = 0; x < exams.length; x ++) {
			exams[x] = 0;
		}
		assignmentTotal = 0;
		discussionTotal = 0;
		examTotal = 0;
		project = 0;
		letterGrade = LOWEST_GRADE;
	}
}
