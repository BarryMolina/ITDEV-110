/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertbase;
import java.util.Scanner;
/**
 *
 * @author barrymolina
 */
public class ConvertBase {

	/**
	 * @param args the command line arguments
	 */
	static Scanner keyboard = new Scanner(System.in);
	static int number;
	static int base;
	static String[] allChars = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
	static int quotient;
	static int remainder;
	static String converted = "";

	public static void main(String[] args) {

        getNumber();
        getBase();
        convert();
        displayNumber();
    }
    
    public static void getNumber() {
        System.out.print("Enter number to convert: ");
        number = keyboard.nextInt();
    }

    public static void getBase() {
        System.out.print("Enter base between 2-16: ");
        base = keyboard.nextInt();
    }

    public static void convert() {
		quotient = number;
        while (quotient != 0) {
			//System.out.println("Calculating remainder");
            remainder = quotient % base;
			//System.out.println("Remainder is " + remainder);
			//System.out.println("Prepending remainder");
            prepend(remainder);
			//System.out.println("Calculating quotient");
            quotient = quotient / base;
			//System.out.println("Quotient is " + quotient);
        }
    }

    public static void prepend(int digit) {
        String nextDigit;

		//System.out.println("Inside prepend digit is " + digit);
		nextDigit = allChars[digit];
		//System.out.println("nextDigit is " + nextDigit);

		//System.out.println("Adding nextDigit to converted");
        converted = nextDigit + converted;
		//System.out.println("converted is now " + converted);
    }

    public static void displayNumber() {
        System.out.println(number + " base " + base + " is " + converted);
    }
	// TODO code application logic here
}
	
