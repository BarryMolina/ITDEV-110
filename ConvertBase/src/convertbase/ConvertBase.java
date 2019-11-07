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
	
	static Scanner keyboard = new Scanner(System.in);
	static char[] allChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    static int[] numberArray;
	static int base1;
	static int base2;
	static int decimal;
	static String number;
	static String newNumber = "";
	static int quotient;
	static int remainder;
	static int total = 0;
	static boolean toDec;
	static boolean fromDec;

	public static void main(String[] args) {

		getInput();
		convert();
		displayResult();
    }
	public static void getInput() {
		System.out.print("Enter base to convert from: ");
		base1 = keyboard.nextInt();
		keyboard.nextLine();
		if (base1 == 10) {
			System.out.print("Enter number to convert: ");
			decimal = keyboard.nextInt();
		}
		else {
			System.out.print("Enter number to convert: ");
			number = keyboard.nextLine();
		}
		System.out.print("Enter base to convert to: ");
		base2 = keyboard.nextInt();
	}
	public static void convert() {
		if (base1 == 10) {
			fromDec = true;
			fromDecimal();
		}
		else if (base2 == 10) {
			toDec = true;
			toDecimal();
		}
		else {
			toDecimal();
			fromDecimal();
		}
	}
	public static void displayResult() {
		System.out.println((fromDec? decimal : number) + " base " + base1 + 
				" is " + (toDec? decimal : newNumber) + " base " + base2);
	}
    public static void fromDecimal() {
		quotient = decimal;
        while (quotient != 0) {
            remainder = quotient % base2;
            prepend(remainder);
            quotient = quotient / base2;
        }
    }
	public static void toDecimal() {
		toArray();
		multiplyArray();
		addArray();
		decimal = total;
	}
    public static void prepend(int digit) {
        char nextDigit;
		nextDigit = allChars[digit];
        newNumber = nextDigit + newNumber;
    }
    public static void toArray() {
        numberArray = new int[number.length()];
        for (int i = 0; i < number.length(); i ++) {
            int x = 0;
            boolean foundIt = false;
            while (x < allChars.length && !foundIt) {
                if (number.charAt(i) == (allChars[x])) {
                    foundIt = true;
                    numberArray[i] = x;
                }
                x++;
            }
        }
	}
	public static void multiplyArray() {
		int power = numberArray.length - 1;
		for (int i = 0; i < numberArray.length; i++) {
			numberArray[i] *= (int)Math.pow(base1, power);
			power--;
		}
    }
	public static void addArray() {
		for (int x = 0; x < numberArray.length; x++) {
			total += numberArray[x];
		}
	}
}
	
