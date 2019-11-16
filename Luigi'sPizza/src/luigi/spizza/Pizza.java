/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luigi.spizza;


/**
 *
 * @author student
 */
public class Pizza {
        int pizzaNum;
		String toppings = "";
		int numToppings = 0;
        char sizeChar;
        String sizeString;
		double price = 0;

    public Pizza(int num) {
        pizzaNum = num;
    }
    public int getPizzaNum() {
        return pizzaNum;
    }
	public String getSize() {
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
	public int getNumToppings() {
		return numToppings;
	}
	public void addTopping(String topping) {
		toppings += topping + " ";
		numToppings++;
	}
	public void updatePrice(double amount) {
		price += amount;
	}
	public double getPrice() {
		return price;
	}
	@Override
	public String toString() {
		return "Info for pizza number " + pizzaNum + ":" +
				"\n\t Size: " + sizeString +
				"\n\t Toppings: " + toppings +
				"\n\t Total price for this pizza: $" + price;
	}
}
