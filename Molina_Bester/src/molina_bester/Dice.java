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
    int NUM_DICE = 5;
    int[] values = new int[NUM_DICE];
    
    public int[] getValues() {
        return values;
    }
    public void rollDice() {
        for (int x = 0; x < values.length; x++) {
            values[x] = p.nextInt(6 - 1) + 1;
        }
    }
}
