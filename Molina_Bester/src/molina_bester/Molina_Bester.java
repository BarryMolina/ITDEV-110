/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_bester;

/**
 *
 * @author barry
 */
public class Molina_Bester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        int ROUNDS = 5;
        int NUM_DICE = 5;
        int FACES_PER_DIE = 6;

        Game game = new Game(ROUNDS, NUM_DICE, FACES_PER_DIE);
        
		do  {
            game.play();
		} while (game.playAgain() == 'y');
    }
    
}
