/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molinainterestcalculator;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Calculate {
    
    double accruedAmount;
    double pAmount;
    double interestAmount;
    double r = 10;
    double rate;
    double time = 3;
    int months = 36;
    String firstName;
    char runAgain = 'N';
    
    Scanner keyboard = new Scanner(System.in);
    
    public Calculate() {
        
        do {
            getUserInput();
            calculateInterest();
        }while(runAgain == 'Y');
    }
    
    public void getUserInput() {
        keyboard.nextLine();
        
        System.out.println("Enter First Name: ");
        firstName = keyboard.nextLine();
        
        System.out.println("Enter Principle Amount");
        pAmount = keyboard.nextDouble();
        
        System.out.println("Enter a rate with no Decimal: ");
        r = keyboard.nextDouble();
        
        System.out.println("Enter Number of Months");
        months = keyboard.nextInt();
    }
    
    public void calculateInterest() {
        time = months / 12;
        rate = r / 100;
        accruedAmount = pAmount * (1 + (rate * time));
        
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Accrued Balance is: $" + df.format(accruedAmount));
        
        System.out.println("Would you like to run app again? Y or N: ");
        runAgain = keyboard.next().toUpperCase().charAt(0);
        
    }
}
