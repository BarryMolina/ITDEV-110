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
public class GradeBook {
	
	Student[] students;
	int NUM_STUDENTS = 30;

	int nextStudent;

	public GradeBook () {
		students = new Student[NUM_STUDENTS];
		nextStudent = 0;
	}

	public int addStudent(String name, int number) {
		students[nextStudent] = new Student(name, number);
		nextStudent++;
		return nextStudent - 1;
	}
	public Student[] getStudents() {
		return students;
	}
	public int getNextStudent() {
		return nextStudent;
	}
}
