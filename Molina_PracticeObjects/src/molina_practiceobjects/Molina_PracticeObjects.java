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
public class Molina_PracticeObjects {

	/**
	 * Barry Molina, ITDEV-110-500, Assignment 5
	 */
	public static void main(String[] args) {
		
		Admin GetReady = new Admin();

		GetReady.Intro();

		MathFun Calc1 = new MathFun();
		MathFun Calc2 = new MathFun();

		Calc1.setNumber1(4);
		Calc1.setNumber2(6);

		Calc2.setNumber1(20);
		Calc2.setNumber2(16);
		
		System.out.println("Calc1 Number1 is " + Calc1.getNumber1());
		System.out.println("Calc1 Number2 is " + Calc1.getNumber2());
		System.out.println();

		System.out.println("Calc2 Number 1 is " + Calc2.getNumber1());
		System.out.println("Calc2 Number 2 is " + Calc2.getNumber2());
		System.out.println();

		System.out.println("Calc1 Number1 * Number2 is " + 
				Calc1.multiplyThem());
		System.out.println("Calc1 Number1 + Number2 is " +
				Calc1.addThem());
		System.out.println();

		System.out.println("Calc2 Number1 * Number2 is " +
				Calc2.multiplyThem());
		System.out.println("Calc2 Number1 + Number2 is " +
				Calc2.addThem());
		System.out.println();

		GetReady.goodbye();
	}
	
}
