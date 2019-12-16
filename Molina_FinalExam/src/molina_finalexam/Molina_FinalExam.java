/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_finalexam;

import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author barrymolina
 */
public class Molina_FinalExam {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws LineUnavailableException {
		Admin a = new Admin();
		Controller ctrl;

		a.intro();

		ctrl = new Controller();
		ctrl.run();

		a.goodbye();
	}
	
}
