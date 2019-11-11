/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_bester;

import java.util.Random;

/**
 *
 * @author barry
 */
public class Dice {

    Random p = new Random();
    int numFaces;
    int[] values;
    int rollTotal;
    
    public Dice(int dice, int faces) {
        numFaces = faces;

        values = new int[dice];
    }
    public int[] getValues() {
        return values;
    }
    public int getRollTotal() {
        return rollTotal;
    }
    public void rollDice() {
        for (int x = 0; x < values.length; x++) {
            values[x] = p.nextInt(numFaces) + 1;
        }
        setRollTotal();
    }
    public void setRollTotal() {
        int total = 0;
        for (int i = 0; i < values.length; i++) {
            total += values[i];
        }
        rollTotal = total;
    }
}
