/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_midtermapp;

import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author barrymolina
 */
public class View {
	
	Scanner keyboard = new Scanner(System.in);

	public int inputScore() {
		System.out.println();
		System.out.print("Enter a score or 999 to quit: ");
		return keyboard.nextInt();
	}

	public void runningTotal(int score, int count, double average) {
		System.out.println();
		System.out.println("You entered: " + score);
		System.out.println("So far, you've entered " + count + " score(s)");
		System.out.println("The running average is " + average);
	}

	public void finalTotal(int count, double average) {
		System.out.println();
		System.out.println("Your total average for " + count + " scores is: " +
							average);
	}

	public char playAgain() throws LineUnavailableException {
		System.out.println();
		System.out.println("Would you like to calculate another set of scores?");
		System.out.print("y/n: ");

		SoundUtils.tone(600,100);
		return keyboard.next().toLowerCase().charAt(0);
	}
}
