/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_bester;

import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author barrymolina
 */
public class Admin {
	Scanner keyboard = new Scanner(System.in);
	
	public void intro() throws LineUnavailableException {
		System.out.println("\nHello and welcome to Bester, a dice game.\n" +
			"In this game there are five rounds and you'll roll 5 dice in each round.\n" +
			"The computer will as well, and the player with the highest total score\n"
			+ "by the end of the last round wins. Let's play!\n");
        SoundUtils.tone(261,200);
        SoundUtils.tone(392,200);
        SoundUtils.tone(523,300);
		System.out.println("(Press <enter> to contine)");
		keyboard.nextLine();

	}

	public void goodbye() throws LineUnavailableException {
		System.out.println("\nGoodbye!");
        SoundUtils.tone(523,200);
        SoundUtils.tone(392,200);
        SoundUtils.tone(261,200);
	}
}
