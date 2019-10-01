/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_vtipper;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Date;

public class TipCalculator {
    Scanner keyboard = new Scanner(System.in);

    String restaurantName;
    double billNoTip;
    char splitBill;
    int party;
    int percentTip;
    double tipAmount;
    double billWithTip;
    double billPerPerson;
    int TEN_DOLLARS = 10;
    int TWENTY_DOLLARS = 20;
    int FIFTY_DOLLARS = 50;
    int HUNDRED_DOLLARS = 100;
    double tipAtTen;
    double tipAtTwenty;
    double tipAtFifty;
    double tipAtHundred;
    char repeat = 'n';
    
    public TipCalculator() {
        intro();

        do {
            System.out.println();
            inputScreen();
            tipCalc();
            totalBill();
            System.out.print("Would you like to calculate another bill? y/n: ");
            repeat = keyboard.next().toLowerCase().charAt(0);
        }while(repeat == 'y');
        
    }
    
    public void intro() {
        System.out.println("Welcome to VTipper, the Variable Tipper app.");
        System.out.println();
        System.out.println("VTipper can help you calculate how much to tip your"); 
        System.out.println("waiter given the total bill amount without tip and the"); 
        System.out.println("percent tip that you would like to calculate.");
    }

    public void inputScreen() {
        splitBill = 'n';
        party = 1;

        keyboard.nextLine();

        System.out.println("Where did you dine out today?");
        System.out.print("Enter restaurant name: ");
        restaurantName = keyboard.nextLine();
        System.out.println();

        System.out.println("How much is your total bill without tip?");
        System.out.print("Enter bill amount: ");
        billNoTip = keyboard.nextDouble();
        System.out.println();

        System.out.println("Are there multiple people in your party you would like" +
                           " to split the bill with?");
        System.out.print("y/n: ");
        splitBill = keyboard.next().toLowerCase().charAt(0);

        if(splitBill == 'y') {
            System.out.print("Enter number of people in party: ");
            party = keyboard.nextInt();
        }
        System.out.println();

        System.out.println("What percentage tip would you like to calculate?");
        System.out.print("Enter a number between 1 and 50: ");
        percentTip = keyboard.nextInt();
        System.out.println();
    }

    public void tipCalc() {
        tipAmount = billNoTip * percentTip / 100;
        billWithTip = billNoTip + tipAmount;
        billPerPerson = billWithTip / party;
    }
    
    public void percentCalc() {
        
    }

    public void totalBill() {
        Date d = new Date();
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("You dined out at " + restaurantName + " on " + d);
        System.out.println("Your total bill without tip is $" + df.format(billNoTip));
        System.out.println("With a " + percentTip + "% tip of $" + df.format(tipAmount) + 
                           ", you total bill comes out to $" + df.format(billWithTip));
        if(splitBill == 'y') {
            System.out.println();
            System.out.println("Split between " + party + " people, each person's " +
                               "individual bill is $" + df.format(billPerPerson));
        }
        if(billNoTip < TEN_DOLLARS) {
            tipAtTen = (TEN_DOLLARS - billNoTip) / billNoTip * 100;
            System.out.println("Rounded up to a ten dollar bill, " +
                                "your tip would be " + tipAtTen + "%");
        }
        
        if(billNoTip < TWENTY_DOLLARS) {
            tipAtTwenty = (TWENTY_DOLLARS - billNoTip) / billNoTip * 100;
            System.out.println("Rounded up to a twenty dollar bill, " +
                                "your tip would be " + tipAtTwenty + "%");
        }
        if(billNoTip < FIFTY_DOLLARS) {
            tipAtFifty = (FIFTY_DOLLARS - billNoTip) / billNoTip * 100;
            System.out.println("Rounded up to a fifty dollar bill, " +
                                "your tip would be " + tipAtFifty + "%");
        }
        if(billNoTip < HUNDRED_DOLLARS) {
            tipAtHundred = (HUNDRED_DOLLARS - billNoTip) / billNoTip * 100;
            System.out.println("Rounded up to a hundred dollar bill, " +
                                "your tip would be " + tipAtHundred + "%");
        }
        System.out.println();

    }
}
