/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_finalproject;

import java.util.Scanner;

/**
 *
 * @author barry
 */
public class Admin {
	Scanner keyboard = new Scanner(System.in);

    public void intro() {
		System.out.println("Hello and welcome to the Connect 4 App."
				+ "\nthis game is just like real life Connect 4, in that "
				+ "\nthere are two players and each player gets a turn to "
				+ "\ninsert their token into one of 7 slots. Tokens are stacked"
				+ "\non top of each other up to 6 rows high, and the first player"
				+ "\nto connect four tokens in a row either horizontally, vertically,"
				+ "\nor diagonally wins. Lets play!\n");
		System.out.println("(Press <enter> to contine)");
		keyboard.nextLine();
    }

    public void goodbye() {
		System.out.println("Have a good day!");

    }
    
}
