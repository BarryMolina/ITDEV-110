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
public class Model {

	int scores = 0;
	int count = 0;

	public int getScores() {
		return scores;
	}

	public int getCount() {
		return count;
	}

	public void addScore(int score) {
		scores += score;
	}

	public void addCount() {
		count++;
	}
}
