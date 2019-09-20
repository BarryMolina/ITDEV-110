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
import java.util.Scanner;

public class TipperApp {
    
    Scanner keyboard = new Scanner(System.in);
    
    public void intro() {
        System.out.println("Welcome to TipperApp. TipperApp can help you" +
                            " calculate how much to tip your waiter." +
                            " Please have your bill amount handy.");   
    }
    
    public void tipCalc() {
        System.out.println("Where did you dine out today?");
        
    }
}
