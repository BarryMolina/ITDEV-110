/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_guesstheword;

import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author barrymolina
 */
public class GameController {
	public GameController() throws LineUnavailableException, InterruptedException {
		Game g;
		do  {
			g = new Game();
            g.play();
		} while (g.playAgain() == 'y');
	}
	
}
