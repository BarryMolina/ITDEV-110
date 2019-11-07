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
	int credits;
    boolean guessedIt;
    boolean quit;


	public Game() throws LineUnavailableException, InterruptedException {
		char again = 'y';

		while (again == 'y') {
            play();
			again = playAgain();
		}
	}

	public void play() throws LineUnavailableException, InterruptedException {

        credits = 0;
        guessedIt = false;
        quit = false;
        getLevel();
        getHigh();
        do {
            addCredits();
            getRandom();
            makeGuess();
        } while (credits > 0 && !quit); 
        if (credits <= 0) {
            System.out.println("You ran out of credits!");
        }
        System.out.println("Game Over.");
	}
	// gets level selected by user
    public void newMatch() {
    }
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
    public void addCredits() {
        credits += 20;
		System.out.println("You have been awarded 20 credits.");
		System.out.println("You have a total of " + credits + " credits.");

    }
	public void getRandom() {

		ranNum = rand.nextInt(high) + 1;

		System.out.println("\nA random number between 1 and " + high + 
				" has been selected! The match is ready to begin.");
	}
	public void makeGuess() throws LineUnavailableException, InterruptedException {
        int wagerAmount = 0;
		int guess;
		int guessCount = 0;


        System.out.print("Enter amount of credits to wager or 0 to quit: ");
        wagerAmount = keyboard.nextInt();
		while (wagerAmount != 0 && !guessedIt && credits > 0) {
            System.out.println("What is your guess?: ");
			guess = keyboard.nextInt();

			guessCount++;

			if (guess == ranNum) {
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
				
				System.out.println("\n" + guess + " is too low."); 
                credits -= wagerAmount;
                
			}
			else if (guess > ranNum) {
				SoundUtils.tone(523,200);

				System.out.println("\n" + guess + " is too high."); 
                credits -= wagerAmount;
			}
            if (credits > 0 && !guessedIt) {
                System.out.print("Enter amount of credits to wager or 0 to quit: ");
                wagerAmount = keyboard.nextInt();
            }
		} 
        if (wagerAmount == 0) {
            quit = true;
        }
	}
	public char playAgain() throws LineUnavailableException {
		System.out.println();
		System.out.println("Would you like to play again?");
		System.out.print("y/n: ");

		return keyboard.next().toLowerCase().charAt(0);
	}
}
