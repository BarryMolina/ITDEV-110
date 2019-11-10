/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package highlow2;

import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author barrymolina
 * Barry Molina, ITDEV-110-500, Assignment 7
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
				+ "that you may wager before each guess. You must wager at least 1 credit. \n"
				+ "If you guess wrong, those credits are subtracted from your total.\n"
				+ "If you guess correctly, you may use your remaining credits\n"
				+ "for the next match along with the default amount of credits\n"
				+ "awarded every match. If you have 0 credits or less you lose the game.\n");
	}

	public void goodbye() throws LineUnavailableException {
		System.out.println("\nGoodbye!");
        SoundUtils.tone(523,200);
        SoundUtils.tone(392,200);
        SoundUtils.tone(261,200);
	}
}
