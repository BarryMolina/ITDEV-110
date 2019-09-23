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
import java.util.Date;

public class TipperApp {
    
    Scanner keyboard = new Scanner(System.in);
    Date d = new Date();
    String restaurant;
    double bill;
    double tip;
    double billWithTip;
    double PERCENT_TIP = .15;
    
    
    public void intro() {
        System.out.println("Welcome to TipperApp."); 
        System.out.println("TipperApp can help you calculate " +
                           "how much to tip your waiter.\n");  
    }
    
    public void getInfo() {
        System.out.println("Where did you dine out today?");
        System.out.print("Please enter a restaurant name: ");
        restaurant = keyboard.nextLine();
        System.out.println("You dined out at: " + restaurant);
        System.out.println();
        System.out.println("How much was your bill without tip?");
        System.out.print("Please enter a dollar amount: ");
        bill = keyboard.nextDouble();
        System.out.println("Your total bill without tip is: $" + bill);
    }
    
    public void tipCalc() {
        tip = bill * PERCENT_TIP;
        billWithTip = bill + tip;
    }
    
    public void displayInfo(){
        System.out.println();
        System.out.println("Your bill info for " + restaurant +
                           " on " + d + ":");
        System.out.println("Your total bill without tip is $" + bill);
        System.out.println("15% tip is $" + tip);
        System.out.println("Your total bill with tip is $" + billWithTip);
        System.out.println();
        System.out.println("Thanks for using TipperApp! Goodbye.");
        
    }
}
