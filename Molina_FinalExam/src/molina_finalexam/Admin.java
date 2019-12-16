/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_finalexam;

import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author barrymolina
 */
public class Admin {

	Scanner keyboard = new Scanner(System.in);

	public void intro() throws LineUnavailableException {
        SoundUtils.tone(261,200);
        SoundUtils.tone(392,200);
        SoundUtils.tone(523,300);
		System.out.println("Hello and welcome to the StudentGradebook app.\n"
				+ "You can use this app to easily compute and store student grades.\n"
				+ "First, select the menu option to create a new student entry and\n"
				+ "provide a name and student number. Once a student is created you\n"
				+ "will have the option to enter scores for assignments, discussion topics,\n"
				+ "exams, and an individual project. From the student menu, you can \n"
				+ "also request a Student Summary that will display the cumulative score\n"
				+ "for each category as well as the students final letter grade.\n");
		System.out.println("The menu for each student can be accessed from the Main Menu\n"
				+ "by searching by name or student number. From the Main Menu, you can\n"
				+ "also get a listing of every student along with each student's letter grade.\n");
		System.out.println("Let's get started!");
		System.out.println();
		System.out.print("(Press <enter> to contine)");
		keyboard.nextLine();
	}

	public void goodbye() throws LineUnavailableException {
		System.out.println("Thank you for using the StudentGradebook app. Goodbye!");
        SoundUtils.tone(523,200);
        SoundUtils.tone(392,200);
        SoundUtils.tone(261,200);
	}
	
}
