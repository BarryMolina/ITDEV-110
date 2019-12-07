/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertcli;

/**
 *
 * @author barrymolina
 */
public class Converter {
	
	int startBase;
	int endBase;
	char[] allChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    int[] numberArray;
	int decimal;
	String number;
	String newNumber = "";
	int quotient;
	int remainder;
	int total = 0;

	public Converter (int start, int end, String num) {
		startBase = start;
		endBase = end;
		number = num;
		
	}
	public void convert() {
		if (startBase == 10) {
			decimal = Integer.parseInt(number);
			fromDecimal();
		}
		else if (endBase == 10) {
			toDecimal();
			newNumber = Integer.toString(decimal);
		}
		else {
			toDecimal();
			fromDecimal();
		}
	}
    public void fromDecimal() {
		quotient = decimal;
        while (quotient != 0) {
            remainder = quotient % endBase;
            prepend(remainder);
            quotient = quotient / endBase;
        }
    }
	public void toDecimal() {
		toArray();
		multiplyArray();
		addArray();
		decimal = total;
	}
    public void prepend(int digit) {
        char nextDigit;
		nextDigit = allChars[digit];
        newNumber = nextDigit + newNumber;
    }
    public void toArray() {
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
	public void multiplyArray() {
		int power = numberArray.length - 1;
		for (int i = 0; i < numberArray.length; i++) {
			numberArray[i] *= (int)Math.pow(startBase, power);
			power--;
		}
    }
	public void addArray() {
		for (int x = 0; x < numberArray.length; x++) {
			total += numberArray[x];
		}
	}
	public String getNewNumber() {
		return newNumber;
	}
	
}
