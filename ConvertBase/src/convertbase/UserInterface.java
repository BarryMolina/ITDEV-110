/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertbase;

import java.util.Scanner;

/**
 *
 * @author barrymolina
 */
public class UserInterface {
	
	int startBase;
	int endBase;
	String number;
	
	static Scanner keyboard = new Scanner(System.in);

	public void getInput() {
		
		System.out.print("Enter base to convert from: ");
		startBase = keyboard.nextInt();
		System.out.print("Enter base to convert to: ");
		endBase = keyboard.nextInt();
		keyboard.nextLine();
		System.out.print("Enter number to convert: ");
		number = keyboard.nextLine().toUpperCase();
	}
	public int getStartBase() {
		return startBase;
	}
	public int getEndBase() {
		return endBase;
	}
	public String getNumber() {
		return number;
	}
	public void displayResult(String newNum) {
		System.out.println(number + " base " + startBase + 
				" is " + newNum + " base " + endBase);
	}
	public char convertAgain() {
        char again;
		System.out.println();
		System.out.println("Do you have another number to convert?");
		System.out.print("y/n: ");

        again = keyboard.next().toLowerCase().charAt(0);
        keyboard.nextLine();

		return again;
	}
}
