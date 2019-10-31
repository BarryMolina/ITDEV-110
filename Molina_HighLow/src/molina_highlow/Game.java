/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_highlow;
import java.util.Scanner;
import java.util.Random;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author barrymolina
 */
public class Game {

	Scanner keyboard = new Scanner(System.in);
	Random rand = new Random();


	public Game() throws LineUnavailableException, InterruptedException {
		char again = 'y';

		while (again == 'y') {
			play();
			again = playAgain();
		}
	}

	public void play() throws LineUnavailableException, InterruptedException {

		int high;
		int ranNum;
		int guess;
		int guessCount = 0;
		boolean guessedIt = false;
		boolean quit = false;
		String trySingular = "try";
		String tryPural = "tries";

		System.out.print("\nEnter an upper limit for the random number: ");
		high = keyboard.nextInt();
		
		ranNum = rand.nextInt(high) + 1;

		System.out.println("\nA random number between 1 and " + high + 
				" has been selected! The game is ready to begin.");
		System.out.println("At the prompt, enter a number or 0 to quit");
				
		while (!quit && !guessedIt) {
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
	public char playAgain() throws LineUnavailableException {
		System.out.println();
		System.out.println("Would you like to play again?");
		System.out.print("y/n: ");

		return keyboard.next().toLowerCase().charAt(0);
	}
}
