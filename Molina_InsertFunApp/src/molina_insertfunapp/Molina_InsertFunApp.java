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
public class Molina_InsertFunApp {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {

		Admin a = new Admin();
		
		a.Intro();

		GameController controller = new GameController();
		
		a.goodbye();
	}
}
