/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_practiceobjects;

/**
 *
 * @author barrymolina
 */
public class MathFun {

	private int Number1;
	private int Number2;
	
	public int getNumber1() {
		return Number1;
	}
	
	public int getNumber2() {
		return Number2;
	}

	public void setNumber1(int newNumber1) {
		Number1 = newNumber1;
	}

	public void setNumber2(int newNumber2) {
		Number2 = newNumber2;
	}

	public int multiplyThem() {
		return Number1 * Number2;
	}

	public int addThem() {
		return Number1 + Number2;
	}
}
