/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_finalproject;

import java.util.Scanner;

/**
 *
 * @author barry
 */
public class Game {

	Board b;
	Player p1;
	Player p2;
	final char p1Token = 'X';
	final char p2Token = 'O';
	final char[] COL_CHARS = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
	final char QUIT = 'q';
	final int QUIT_NUM = -1;
	final int INVALID = -9;
	boolean player1Quit = false;
	boolean player2Quit = false;
	WinChecker wc;

	Scanner keyboard = new Scanner(System.in);

	public Game() {
		p1 = new Player(1, p1Token);
		p2 = new Player(2, p2Token);
		b = new Board(p1.getToken(), p2.getToken());
        wc = new WinChecker(b.getBoard());
	}

    public void play() throws InterruptedException {
		while (!p1.getQuit() && !p2.getQuit()) {
			turn(p1);
			if (!p1.getQuit()) {
				turn(p2);
			}
		}
		if (p1.getQuit()) {
			System.out.println("Player 2 Wins!");
		}
		else if (p2.getQuit()) {
			System.out.println("Player 1 Wins!");
		}
    }
	public void turn(Player p) throws InterruptedException {
		System.out.println("Player " + p.getNum() + "'s turn.");
		System.out.println();
		int selectIdx;
        int row;
		boolean confirmed = false;
		while (!p.getQuit() && !confirmed) {
			selectIdx = makeSelection();
			if (selectIdx == QUIT_NUM) {
				p.setQuit();
			}
			else {
				confirmed = confirmSelection(p.getToken(), selectIdx);
				if (confirmed) {
					row = b.drop(p.getNum(), selectIdx);
                    if (wc.checkWin(row, selectIdx)) {
                        System.out.println("You Win!");
                    }
				}
			}
		}
	}
	public int makeSelection() {
		char select;
		int selectIdx;
        b.printBoard();
		System.out.print("Pick a column (a-g) or enter 'q' to quit: ");
		select = keyboard.next().toLowerCase().charAt(0);
		selectIdx = getIndex(select);
		while (selectIdx == INVALID) {
			b.printBoard();
			System.out.println("Invalid selection.\n");
			System.out.print("Pick a column (a-g) or enter 'q' to quit: ");
			select = keyboard.next().toLowerCase().charAt(0);
			selectIdx = getIndex(select);
		}
		System.out.println();
		return selectIdx;
	}
	public int getIndex(char selection) {
		int index = INVALID;
 		boolean valid = false;
		if (selection == QUIT) {
			index = QUIT_NUM;
		}
		else {
			int i = 0;
			while (valid == false && i < COL_CHARS.length) {
				if (selection == COL_CHARS[i]) {
					valid = true;
					index = i;
				}
				i++;
			}
		}
		return index;
	}
	public boolean confirmSelection(char token, int selectIdx) {
		boolean confirm = false;
		char answer;
		System.out.print(" ");
		for (int x = 0; x < selectIdx; x++) {
			System.out.print("  ");
		}
		System.out.println(token);
		b.printBoard();
		System.out.print("Drop token here? (y/n): ");
		answer = keyboard.next().toLowerCase().charAt(0);
		if (answer == 'y') {
			confirm = true;
		}
		return confirm;
	}
    //public void updatePlayer1(int row, int col) {
        //board[row][col] = PLAYER1;
    //}
    //public void updatePlayer2(int row, int col) {
        //board[row][col] = PLAYER2;
    //}
    
}
