/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_guesstheword;

import javax.sound.sampled.LineUnavailableException;

/**
 *
 * Barry Molina, ITDEV-110-500, Assignment 10
 */
public class Molina_GuessTheWord {

	/**
	 * @param args the command line arguments
	 * @throws javax.sound.sampled.LineUnavailableException
	 */
	public static void main(String[] args) throws LineUnavailableException, InterruptedException {
		Admin a = new Admin();
		a.intro();
		GameController gc = new GameController();
		a.goodbye();
	}
	
}
