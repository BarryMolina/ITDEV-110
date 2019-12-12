/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_finalproject;

import java.util.Scanner;

/**
 *
 * @author barry
 */
public class GameController {
    
	Scanner keyboard = new Scanner(System.in);

    public GameController() throws InterruptedException {
		Game g;
		
		do  {
			g = new Game();
            g.play();
		} while (playAgain() == 'y');

    }
	public char playAgain() {
        char again;
		System.out.print("Would you like to play again? (y/n): ");
        again = keyboard.next().toLowerCase().charAt(0);
        keyboard.nextLine();
		System.out.println();

		return again;
	}
}
