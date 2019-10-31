/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_highlow;

import javax.sound.sampled.LineUnavailableException;

/**
 *
 * Barry Molina, ITDEV-110-500, Assignment 7
 */
public class Molina_HighLow {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws LineUnavailableException, InterruptedException {
		Admin a = new Admin();
		a.intro();

		Game game = new Game();

		a.goodbye();
		System.exit(0);
	}
	
}
