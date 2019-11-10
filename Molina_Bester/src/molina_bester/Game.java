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
    Dice d = new Dice(); 
    Player computer = new Player("Computer");
    Player user; 
    int ROUNDS = 5;
    int VERY_SHORT = 1000; //1000
    int SHORT = 1500; //1500
    int MEDIUM = 2500; //2500
    int LONG = 3000; //3000
    int VERY_LONG = 4000; //4000
   
    public Game() {
        String name;
        System.out.print("What's your name? ");
        name = keyboard.nextLine();
        user = new Player(name);
    }
    public void play() throws InterruptedException {
		char response; 
        for (int round = 0; round < ROUNDS; round++) {
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
			System.out.print("Press r to roll: ");
			response = keyboard.nextLine().toUpperCase().charAt(0);
			while (response != 'R') {
				System.out.println("You must enter r to roll");
                Thread.sleep(SHORT);
                System.out.print("Press r to roll: ");
                response = keyboard.nextLine().toUpperCase().charAt(0);
			}
            turn(user, round);
        }
        matchResults();
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
        System.out.println("Roll total: " + rollTotal(values));
        p.setScores(round, values);
        Thread.sleep(MEDIUM);
        System.out.println();
        System.out.println("Current Score");
        System.out.println("-------------");
        System.out.println(computer.getName() + ": " + computer.getTotal()
                    + "\n" + user.getName() + ": " + user.getTotal());
        Thread.sleep(VERY_LONG);
        //System.out.println(p.getName() + "'s current total score: " +
                //p.getTotal());

    }
    public int rollTotal(int[] values) {
        int total = 0;
        for (int i = 0; i < values.length; i++) {
            total += values[i];
        }
        return total;
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
}
