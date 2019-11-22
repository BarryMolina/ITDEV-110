/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luigi.spizza;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 *
 * @author barrymolina
 */
public class Order {
    String name;
    String address;
    String phoneNumber;
    Pizza[] pizzas;
	double[] pizzaPrices;
	char sizeArray[] = {'S', 'M', 'L'};
	double priceArray[] = {10.00, 12.00, 15.00};
    String toppingsArray[] = {"Pepperoni", "Sausage", "Onion", "Mushroom", "Anchovies"};
    final double EXTRA_TOPPING = 1.00;
    boolean delivery = false;
    final double DELIVERY_FEE = 2.00;
	double orderTotal = 0;
    Scanner keyboard = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("0.00");
	
	public void takeOrder() {
		getInfo();
		getDelivery();
		getNumPizzas();
		makePizzas();
		reviewPizzas();
		calculateOrder();
		reviewOrder();
	}
    public void getInfo() {
        System.out.print("Please enter your name: ");
        name = keyboard.nextLine();
        System.out.print("Please enter your address: ");
        address = keyboard.nextLine();
        System.out.print("Please enter your phone number: ");
        phoneNumber = keyboard.nextLine();
    }
	public void getDelivery() {
		char orderType;
        System.out.print("Pickup or delivery?: ");
        orderType = keyboard.next().toLowerCase().charAt(0);
        if (orderType == 'd')
            delivery = true;
	}
	public void getNumPizzas() {
		int numberOfPizzas;
        System.out.print("How many pizzas would you like?: ");
        numberOfPizzas = keyboard.nextInt();
		pizzas = new Pizza[numberOfPizzas];
	}
	public void makePizzas() {
        int pizzaNumber;
		Pizza p;
        for (int x = 0; x < pizzas.length; x++) {
            pizzaNumber = x + 1;
            pizzas[x] = new Pizza(pizzaNumber);
			p = pizzas[x];
			inputSize(p);
            inputToppings(p);
			
            keyboard.nextLine();
        } 
	}
	public void inputSize(Pizza p) {
        char size;
		int sizeIndex;
		System.out.print("What size would you like pizza number " + 
				p.getPizzaNum() + "? (Small/Medium/Large): ");
		size = keyboard.next().toUpperCase().charAt(0);
		sizeIndex = getIndex(size);
		while (sizeIndex == -1) {
			System.out.print("That's not a valid size!");
			System.out.println("What size would you like pizza number " + 
					p.getPizzaNum() + " ?");
			System.out.print("(Small/Medium/Large): ");
			size = keyboard.next().toUpperCase().charAt(0);
			sizeIndex = getIndex(size);
		}
		p.setSize(size);
		p.updatePrice(priceArray[sizeIndex]);
	}
	public int getIndex(char size) {
		boolean valid = false;
		int index = 0;
		while (index < sizeArray.length && valid == false) {
			if (sizeArray[index] == size) {
				valid = true;
			}
			else {
				index++;
			}
		}
		if (valid == false) {
			index = -1;
		}
		return index;
	}
    public void inputToppings(Pizza p) {
        char answer;
		for (String topping : toppingsArray) {
			System.out.print("Would you like " + topping + " on this pizza? ");
			System.out.print("y/n: ");
			answer = keyboard.next().charAt(0);
			if (answer == 'y') {
				p.addTopping(topping);
				if (p.getNumToppings() > 1) {
					p.updatePrice(EXTRA_TOPPING);
				}
			}
		}
    }
	public void reviewPizzas() {
		for (int p = 0; p < pizzas.length; p++)
			System.out.println(pizzas[p]);
	}
	public void calculateOrder() {
		for (Pizza p : pizzas) {
			orderTotal += p.getPrice();
		}
		if (delivery) {
			orderTotal += DELIVERY_FEE;
		}
	}
	public void reviewOrder() {

		System.out.println("Order for:\n" + name + "\n" + address + "\n"
				+ phoneNumber + "\n" + "Delivery: " + (delivery? "yes" : "no"));
				
		System.out.println("Order total: $" + (df.format(orderTotal)));
		System.out.println("Thank you for eating with Luigi!");
	}
}