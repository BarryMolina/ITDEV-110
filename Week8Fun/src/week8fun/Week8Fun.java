/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week8fun;

/**
 *
 * @author barrymolina
 */
public class Week8Fun {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Admin adminthis = new Admin();
		adminthis.consoleSetup();
		adminthis.displayInfo();

		Game mainGame = new Game();

		mainGame.play();

		adminthis.sayGoodbye();
	}
	
}
