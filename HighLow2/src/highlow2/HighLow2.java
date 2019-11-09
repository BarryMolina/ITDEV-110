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
 * Barry Molina, ITDEV-110-500, Assignment 8
 */
public class HighLow2 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws LineUnavailableException, InterruptedException {
		Admin a = new Admin();
		a.intro();
        Game g = new Game();
		a.goodbye();
	}
	
}
