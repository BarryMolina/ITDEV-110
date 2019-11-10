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
public class Player {
    
    private String name;
	int[][] allScores = {
	{0, 0, 0, 0, 0},		//round1
	{0, 0, 0, 0, 0},		//round2
	{0, 0, 0, 0, 0},		//round3
	{0, 0, 0, 0, 0},		//round4
	{0, 0, 0, 0, 0}		//round5
	};

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[][] getScores() {
        return allScores;
    }
    public int getTotal() {
        int total = 0;
        //System.out.println("Total = " + total);
        for (int round = 0; round < allScores.length; round++) {
            //System.out.println("Processing round " + round + "scores");
            for (int value = 0; value < allScores[round].length; value++) {
                //System.out.println("Processing value " + value);
                //System.out.println("Adding " + allScores[round][value] + " to total");
                total += allScores[round][value];
                //System.out.println("total is now: " + total);
            }
        }
        return total;
    }
    public void setScores(int round, int[] scores) {
        for (int i = 0; i < allScores[round].length; i++) {
            allScores[round][i] = scores[i];
        }

    }
    public void roll(Dice d) {
        d.rollDice();

    }

}
