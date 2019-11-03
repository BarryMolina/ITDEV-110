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
	static char[] allChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	static int quotient;
	static int remainder;
	static String converted = "";
    static int[] inputArray;
    static String input;

	public static void main(String[] args) {

        //getNumber();
        //getBase();
        //fromDecimal();
        //displayNumber();
        getString();
        indexInput();
        displayArray(inputArray);

    }
    public static void displayArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
    }
    
    public static void getNumber() {
        System.out.print("Enter number to convert: ");
        number = keyboard.nextInt();
    }
    public static void getString() {
        System.out.print("Enter number to convert: ");
        input = keyboard.nextLine();
    }

    public static void getBase() {
        System.out.print("Enter base between 2-16: ");
        base = keyboard.nextInt();
    }

    public static void fromDecimal() {
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
        char nextDigit;

		//System.out.println("Inside prepend digit is " + digit);
		nextDigit = allChars[digit];
		//System.out.println("nextDigit is " + nextDigit);

		//System.out.println("Adding nextDigit to converted");
        converted = nextDigit + converted;
		//System.out.println("converted is now " + converted);
    }

    public static void toDecimal() {
        
    }
    public static void indexInput() {
        inputArray = new int[input.length()];
        for (int i = 0; i < input.length(); i ++) {
            //System.out.println("Processing char " + input.charAt(i));
            int x = 0;
            boolean foundIt = false;
            while (x < allChars.length && !foundIt) {
                //System.out.println("Testing if equal to " + allChars[x] );
                if (input.charAt(i) == (allChars[x])) {
                    //System.out.println("Found it!");
                    foundIt = true;
                    inputArray[i] = x;
                }
                x++;
            }
        }
            
      
    
    }

    public static void displayNumber() {
        System.out.println(number + " base " + base + " is " + converted);
    }
	// TODO code application logic here
}
	
