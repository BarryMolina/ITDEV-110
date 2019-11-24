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
    final int PLAYER1_NUM = 1;
    final int PLAYER2_NUM = 2;
	final char PLAYER1_TOKEN = 'X';
	final char PLAYER2_TOKEN = 'O';
	final char[] COL_CHARS = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
	final char QUIT = 'q';
	final int QUIT_NUM = -1;
	final int INVALID = -9;
    int winner = 0;
	WinChecker wc;

	Scanner keyboard = new Scanner(System.in);

	public Game() {
		p1 = new Player(PLAYER1_NUM, PLAYER1_TOKEN);
		p2 = new Player(PLAYER2_NUM, PLAYER2_TOKEN);
		b = new Board(p1.getToken(), p2.getToken());
        wc = new WinChecker(b.getBoard());
	}

    public void play() throws InterruptedException {
        int current = p1.getNum();
		while (winner == 0) {
			turn(current);
            current = otherPlayer(current);
		}
		if (winner == p1.getNum()) {
			System.out.println("Player 1 Wins!");
		}
		else if (winner == p2.getNum()) {
			System.out.println("Player 2 Wins!");
		}
    }
	public void turn(int player) throws InterruptedException {
		System.out.println("Player " + player + "'s turn.");
		System.out.println();
		int selectIdx;
        int row;
		selectIdx = makeSelection();
		if (selectIdx == QUIT_NUM) {
            winner = otherPlayer(player);
		}
		else {
			row = b.drop(player, selectIdx);
			if (wc.checkWin(row, selectIdx)) {
                winner = player;
			}
		}
//		boolean confirmed = false;
//		while (!p.getQuit() && !confirmed) {
//			selectIdx = makeSelection();
//			if (selectIdx == QUIT_NUM) {
//				p.setQuit();
//			}
//			else {
//				confirmed = confirmSelection(p.getToken(), selectIdx);
//				if (confirmed) {
//					row = b.drop(p.getNum(), selectIdx);
//                    if (wc.checkWin(row, selectIdx)) {
//                        System.out.println("You Win!");
//                    }
//				}
//			}
//		}
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
    public int otherPlayer(int player) {
        int other;
        if (player == p1.getNum()) {
            other = p2.getNum();
        }
        else {
            other = p1.getNum();
        }
        return other;
    }
    
}
