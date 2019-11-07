/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package highlow2;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author barrymolina
 */
public class Game {
	
	Scanner keyboard = new Scanner(System.in);
	Random rand = new Random();
	
	int level;
	int high;
	int ranNum;
	int credits = 0;
	int wagerAmount;


	public Game() throws LineUnavailableException, InterruptedException {
		char again = 'y';

		while (again == 'y') {
			play();
			again = playAgain();
		}
	}

	public void play() throws LineUnavailableException, InterruptedException {


		getLevel();
		getHigh();
		getRandom();
		
		System.out.println("You have been awarded 20 credits.");
		System.out.println("You have a total of " + credits + " credits.");

		makeGuess();

		System.out.println("Available credits: " + credits);
	}
	// gets level selected by user
	public void getLevel() {
		boolean validLevel = false;
		while (!validLevel) {
			System.out.println("\nSelect a game difficulty: ");
			System.out.println("1. Easy");
			System.out.println("2. Medium");
			System.out.println("3. Hard");
			System.out.print("(Digit from 1-3) >>> ");
			level = keyboard.nextInt();
			if (level == 1 || level == 2 || level == 3) {
				validLevel = true;
			}
		}
	}
	public void getHigh() {
		switch (level) {
			case 1:
				high = 20;
				break;
			case 2:
				high = 50;
				break;
			case 3:
				high = 100;
				break;
		}
	}
	public char playAgain() throws LineUnavailableException {
		System.out.println();
		System.out.println("Would you like to play again?");
		System.out.print("y/n: ");

		return keyboard.next().toLowerCase().charAt(0);
	}
	public void getRandom() {

		ranNum = rand.nextInt(high) + 1;

		System.out.println("\nA random number between 1 and " + high + 
				" has been selected! The game is ready to begin.");
	}
	public void wager() {
		System.out.print("Feeling lucky? Enter amount of credits to wager: ");
		wagerAmount = keyboard.nextInt();
		while (wagerAmount > credits) {
			System.out.println("Thats more credits than you have!");
			System.out.print("Enter amount of credits to wager: ");
			wagerAmount = keyboard.nextInt();
		}
		
	}
	public void makeGuess() throws LineUnavailableException, InterruptedException {
		int guess;
		int guessCount = 0;
		boolean guessedIt = false;
		boolean quit = false;

		System.out.println("At the prompt, enter a number or 0 to quit");

		while (!quit && !guessedIt) {
			wager();
			System.out.print(">>> ");
			guess = keyboard.nextInt();

			guessCount++;

			if (guess == 0) {
				quit = true;
			}
			else if (guess == ranNum) {
				SoundUtils.tone(261,120);
				SoundUtils.tone(392,120);
				SoundUtils.tone(523,120);
				Thread.sleep(60);
				SoundUtils.tone(392,120);
				SoundUtils.tone(523,200);

				System.out.print("\n" + guess + " is correct!!");
				System.out.println(" It only took you " + guessCount + 
						((guessCount > 1)? " tries" : " try"));
				guessedIt = true;
			}
			else if (guess < ranNum) {
				SoundUtils.tone(261,200);
				
				System.out.println("\n" + guess + " is too low. Try again "
						+ "or enter 0 to quit");
			}
			else if (guess > ranNum) {
				SoundUtils.tone(523,200);

				System.out.println("\n" + guess + " is too high. Try again "
						+ "or enter 0 to quit");
			}
		} 
	}
}
