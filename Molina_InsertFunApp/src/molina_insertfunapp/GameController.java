/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_insertfunapp;

/**
 *
 * @author barrymolina
 * Barry Molina, ITDEV110-500, Assignment 6
 */
public class GameController {
	
	public GameController() {
		char again = 'n';
		
		do {
			InsertFunUI_View view = new InsertFunUI_View();
			view.inScreen();
			view.Poem();
			again = view.playAgain();
		} while (again == 'y');
	}
}
