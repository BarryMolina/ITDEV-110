/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_bester;

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
		System.out.println("To play this game, select a difficulty level.\n"
				+ "The computer will select a random number within the range\n"
				+ "for that level (easy: 1-20, medium: 1-50, hard: 1-100).\n" );
		System.out.println("At the beginning of each match, you will recieve 20 credits\n"
				+ "that you may wager before each guess. If you guess correctly,\n"
				+ "you win that many credits to use again in the next match.\n"
				+ "If you lose, those credits are subtracted from\n"
				+ "your total. If you have 0 credits or less you lose the game.\n");
		System.out.println("Please note, each incorrect guess also costs 1 credit by default.");
	}

	public void goodbye() throws LineUnavailableException {
		System.out.println("\nGoodbye!");
        SoundUtils.tone(523,200);
        SoundUtils.tone(392,200);
        SoundUtils.tone(261,200);
	}
}
