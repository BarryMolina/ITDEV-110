/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_midtermapp;

import javax.sound.sampled.LineUnavailableException;
/**
 *
 * @author barrymolina
 */
public class Controller {
	
	View view = new View();
	Model mod;

	public Controller() throws LineUnavailableException {

		char again = 'y';

		while (again == 'y') {
			mod = new Model();
			calcScoreSet();
			again = view.playAgain();
		}
	}
	public void calcScoreSet() {

		int score;
		final int QUIT = 999;

		score = view.inputScore();

		while (score != QUIT) {
			mod.addScore(score);
			mod.addCount();

			view.runningTotal(score, mod.getCount(), getAverage() );
			score = view.inputScore();
		}
		view.finalTotal(mod.getCount(), getAverage());
	}
	
	public double getAverage() {

		return (double)mod.getScores() / mod.getCount();
	}
	
}
