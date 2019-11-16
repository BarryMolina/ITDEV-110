/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luigi.spizza;

import java.util.ArrayList;

/**
 *
 * @author student
 */
public class Pizza {
        int pizzaNum;
        ArrayList<String> toppings;
		String toppingsString = "";
        char sizeChar;
        String sizeString;
		double price = 0;

    public Pizza(int num) {
        pizzaNum = num;
        toppings = new ArrayList<>();
    }

    public int getPizzaNum() {
        return pizzaNum;
    }
    public char getSizeChar() {
        return sizeChar;
    }
	public String getSizeString() {
		return sizeString;
	}

    public void setSize(char size) {
		sizeChar = size;
		switch (size){
			case 'S': sizeString = "Small";
			break;
			case 'M': sizeString = "Medium";
			break;
			case 'L': sizeString = "Large";
			break;
		}
    }
    public void setTopping(String topping) {
        toppings.add(topping);
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }
	public void toppingsToString() {
		for (String topping : toppings) {
			toppingsString += topping + " ";
		}
	}
	public void updatePrice(double amount) {
		price += amount;
	}
	@Override
	public String toString() {
		return "Info for pizza number " + pizzaNum + ":" +
				"\n\t Size: " + sizeString +
				"\n\t Toppings: " + toppingsString +
				"\n\t Total price for this pizza: $" + price;
	}
}
