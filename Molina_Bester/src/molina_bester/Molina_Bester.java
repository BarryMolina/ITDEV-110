/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_bester;

import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author barry
 * Barry Molina, ITDEV-110-500, Assignment 8
 */
public class Molina_Bester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, LineUnavailableException {
        int ROUNDS = 5;
        int NUM_DICE = 5;
        int FACES_PER_DIE = 6;

		Admin a = new Admin();
        Game g;

		a.intro();
		g = new Game(ROUNDS, NUM_DICE, FACES_PER_DIE);
		do  {
            g.play();
		} while (g.playAgain() == 'y');
		a.goodbye();
    }
    
}
