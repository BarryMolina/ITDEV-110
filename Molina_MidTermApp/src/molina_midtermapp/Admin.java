/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_midtermapp;

/**
 *
 * @author barrymolina
 */
import javax.sound.sampled.LineUnavailableException;

public class Admin {

	public Admin() throws InterruptedException, LineUnavailableException {

		System.out.println("Hello and welcome. This app will calculate the"); 
		System.out.println("average score of a set of bowling scores."); 
		System.out.println("At the prompt, please enter a single endgame score ");
		System.out.println("or 999 to quit.");

        SoundUtils.tone(261,200);
        SoundUtils.tone(392,200);
        SoundUtils.tone(523,300);

		Controller ctrl = new Controller();

		System.out.println();
		System.out.println("Goodbye!");
        SoundUtils.tone(523,200);
        SoundUtils.tone(392,200);
        SoundUtils.tone(261,200);

		System.exit(0);
	}
}
