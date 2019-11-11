/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_bester;

import java.util.Scanner;

/**
 *
 * @author barry
 */
public class Game {

    Scanner keyboard = new Scanner(System.in);
    Dice d;
    Player computer;
    Player user; 

    int numRounds;
    int VERY_SHORT = 0; //1000
    int SHORT = 0; //1500
    int MEDIUM = 0; //2500
    int LONG = 0; //3000
    int VERY_LONG = 0; //4000
   
    public Game(int rounds, int dice, int faces) {
        String name;
        numRounds = rounds;

        d = new Dice(dice, faces);

        computer = new Player("Computer", numRounds, dice);

        System.out.print("What's your name? ");
        name = keyboard.nextLine();
        user = new Player(name, numRounds, dice);
    }
    public void play() throws InterruptedException {
		char response; 
        boolean quit = false;
        int round = 0;

        computer.resetScores();
        user.resetScores();
        
        while (round < numRounds && quit == false) {
            System.out.println("\n");
            System.out.println("Round " + (round + 1));
            System.out.println("-------------------------------------");
            System.out.println();
            Thread.sleep(LONG);
            System.out.println(computer.getName() + "'s turn.");
            Thread.sleep(MEDIUM);
            turn(computer, round);
            System.out.println();
            System.out.println(user.getName() + "'s turn.");
            Thread.sleep(MEDIUM);
            System.out.println();
			System.out.print("Press 'r' to roll or 'q' to quit: ");
			response = keyboard.nextLine().toUpperCase().charAt(0);
			while (response != 'R' && response != 'Q') {
				System.out.println("You must enter either 'r' to roll or 'q' to quit");
                Thread.sleep(SHORT);
                System.out.print("Press 'r' to roll or 'q' to quit: ");
                response = keyboard.nextLine().toUpperCase().charAt(0);
			}
            if (response == 'R') {
                turn(user, round);
            }
            else {
                quit = true;
            }
            round++;
        }
        if (quit == false) {
            matchResults();
        }
    }
    public void turn(Player p, int round) throws InterruptedException {
        int[] values;
        p.roll(d);
        values = d.getValues();

        System.out.println();
        System.out.print("Rolling");
        for (int x = 0; x < 3; x++) {
            System.out.print(".");
            Thread.sleep(VERY_SHORT);
        }
        System.out.println("\n");
        System.out.print(p.getName() + "'s roll: ");
        for (int x = 0; x < values.length; x++) {
            System.out.print("[" + values[x] + "]" + " ");
        }
        System.out.println();
        Thread.sleep(LONG);
        System.out.println();
        System.out.println("Roll total: " + d.getRollTotal());
        p.setScores(round, values);
        Thread.sleep(MEDIUM);
        System.out.println();
        System.out.println("Current Score");
        System.out.println("-------------");
        System.out.println(computer.getName() + ": " + computer.getTotal()
                    + "\n" + user.getName() + ": " + user.getTotal());
        Thread.sleep(VERY_LONG);
    }
    public void matchResults() throws InterruptedException {
        System.out.println();
        System.out.print("And the winner is");
        for (int x = 0; x < 3; x++) {
            System.out.print(".");
            Thread.sleep(VERY_SHORT);
        }
        System.out.println("\n");
        if (computer.getTotal() > user.getTotal()) {
            System.out.println(computer.getName() + "!!");
        }
        else if (computer.getTotal() < user.getTotal()) {
            System.out.println(user.getName() + "!!");
        }
        else {
            System.out.println("It's a tie!!!");
        }
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
