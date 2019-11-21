/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_guesstheword;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author barrymolina
 */
public class Game {
	String[] words = {"inquisitive", "discovery", "acquire", "insidious", "reaction", "rhetorical", "cautious", "valuable", "implode", "charming"};
	ArrayList<Character> incorrect;
	int guessCount = 0;
	final int GUESS_LIMIT = 7;
	String word;
	char[] letters;
	char[] guessed;
	boolean guessedIt = false;

	Scanner keyboard = new Scanner(System.in);

	public Game() {
		this.incorrect = new ArrayList<>();
		Random r = new Random();
		word = words[r.nextInt(words.length)];
		letters = word.toCharArray();
		guessed = new char[letters.length];
		for (int i = 0; i < guessed.length; i++) {
			guessed[i] = '_';
		}
	}
	public void play() throws LineUnavailableException, InterruptedException {
		char guess;
		boolean quit = false;
		System.out.println("A word has been chosen! It is " + letters.length +
				" letters long.");
		while (guessCount < GUESS_LIMIT && !guessedIt && !quit) {
			guess = guess();
			while (checkGuesses(guess, incorrect) || checkGuesses(guess, guessed)) {
				SoundUtils.tone(261,120);
				SoundUtils.tone(261,120);
				System.out.println("\nYou already tried that letter");
				Thread.sleep(2000);
				guess = guess();
			}
			if (guess == '0') {
				quit = true;
			}
			else if (guessCorrect(guess)) {
				checkWord();
				if (guessedIt) {
					printGuessed();
					System.out.println("You guessed it!!");
					SoundUtils.tone(261,120);
					SoundUtils.tone(392,120);
					SoundUtils.tone(523,120);
					Thread.sleep(60);
					SoundUtils.tone(392,120);
					SoundUtils.tone(523,200);
				}
				else {
					SoundUtils.tone(392,150);
					SoundUtils.tone(523,150);
				}
			}
			else {
				SoundUtils.tone(261,120);
				SoundUtils.tone(261,120);
				incorrect.add(guess);
				guessCount++;
			}
		}
		if (guessCount >= GUESS_LIMIT) {
			SoundUtils.tone(523,150);
			SoundUtils.tone(261,300);
			System.out.println("You ran out of guesses!");
		}
	}
	public char guess() {
		printGuessed();
		System.out.println("Guesses remaining: " + (GUESS_LIMIT - guessCount));
		System.out.print("Incorrect guesses: ");
		for (int i = 0; i < incorrect.size(); i ++) {
			System.out.print(((i > 0)? ", " : "") + incorrect.get(i));
		}
		System.out.print("\n\nEnter your guess or 0 to quit: ");
		return keyboard.next().toLowerCase().charAt(0);
	}
	public void printGuessed() {
		System.out.println();
		for (char letter : guessed) {
			System.out.print(letter + " ");
		}
		System.out.println("\n");
	}
	public boolean checkGuesses(char guess, ArrayList<Character> guesses) {
		boolean used = false;
		int i = 0;
		while (i < guesses.size() && !used) {
			if (guess == guesses.get(i)) {
				used = true;
			}
			i++;
		}
		return used;
	}
	public boolean checkGuesses(char guess, char[] guesses) {
		boolean used = false;
		int i = 0;
		while (i < guesses.length && !used) {
			if (guess == guesses[i]) {
				used = true;
			}
			i++;
		}
		return used;
	}
	public boolean guessCorrect(char guess) {
		boolean correct = false;
		for (int i = 0; i < letters.length; i++) {
			if (guess == letters[i]) {
				guessed[i] = letters[i];
				if (correct == false) {
					correct = true;
				}
			}
		}
		return correct;
	}
	public void checkWord() {
		boolean maybe = true;
		int x = 0;
		while (x < letters.length && maybe == true) {
			if (guessed[x] != letters[x]) {
				maybe = false;
			}
			x++;
		}
		if (maybe == true) {
			guessedIt = true;
		}
	}
	public void printLetters() {
		for (int c = 0; c < letters.length; c++) {
			System.out.print(letters[c] + ", ");
		}
	}
	public void printWord() {
		System.out.println(word);
	}
	public char playAgain() {
        char again;
		System.out.println();
		System.out.println("Would you like to play again?");
		System.out.print("y/n: ");

        again = keyboard.next().toLowerCase().charAt(0);
        keyboard.nextLine();

		return again;
	}
}
