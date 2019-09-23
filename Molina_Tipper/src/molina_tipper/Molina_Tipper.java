/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_tipper;

/**
 *
 * @author student
 */
public class Molina_Tipper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Barry Molina, ITDEV-110-500, Assignment 3
        TipperApp tip = new TipperApp();
        tip.intro();
        tip.getInfo();
        tip.tipCalc();
        tip.displayInfo();
    }
    
}
