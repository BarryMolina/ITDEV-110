/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_insertfunapp;
import java.util.Scanner;
/**
 *
 * @author barrymolina
 * Barry Molina, ITDEV110-500, Assignment 6
 */
public class InsertFunUI_View {
	
	Scanner keyboard = new Scanner(System.in);

	String name;
	String noun;
	String food1;
	String food2;
	String animal;

	public void inScreen() {
		System.out.println();
		System.out.print("Female name: ");
		name = keyboard.nextLine();

		System.out.println();
		System.out.print("Something that you sit on: ");
		noun = keyboard.nextLine();

		System.out.println();
		System.out.print("A food item: ");
		food1 = keyboard.nextLine();

		System.out.println();
		System.out.print("Another food item: ");
		food2 = keyboard.nextLine();

		System.out.println();
		System.out.print("An animal: ");
		animal = keyboard.nextLine();
	}

	public void Poem() {
		System.out.println();
		System.out.printf("Little Miss %s\n", name);
		System.out.printf("Sat on a %s,\n", noun);
		System.out.printf("Eating her %s and %s;\n", food1, food2);
		System.out.printf("Along came a %s,\n", animal);
		System.out.printf("Who sat down beside her\n");
		System.out.printf("And frightened Miss %s away.\n", name);
	}

	public char playAgain() {
		System.out.println();
		System.out.print("Play again? y/n: ");
		return keyboard.next().toLowerCase().charAt(0);
	}
}
