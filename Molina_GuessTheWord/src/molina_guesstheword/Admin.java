/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_guesstheword;

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
		System.out.println("Hello and welcome to GuessThe Word app. In this game,\n"
				+ "you guess the letters in a random word. Its like hangman. You get 7\n"
				+ "guesses to guess all the letters in the word, otherwise you lose.\n"
				+ "Let's get started!\n");
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
