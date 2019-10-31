/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_highlow;

import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author barrymolina
 */
public class Admin {

	public void intro() throws LineUnavailableException {
        SoundUtils.tone(261,200);
        SoundUtils.tone(392,200);
        SoundUtils.tone(523,300);
		System.out.println("To play this game, enter a number. The computer \n"
				+ "will select a random number between 1 and the number you \n"
				+ "enter. The goal is to try to guess the random number, and the \n"
				+ "computer will indicate whether your guess is to high or  \n"
				+ "too low. Let's play!");
	}

	public void goodbye() throws LineUnavailableException {
		System.out.println("\nGoodbye!");
        SoundUtils.tone(523,200);
        SoundUtils.tone(392,200);
        SoundUtils.tone(261,200);
	}
	
}
