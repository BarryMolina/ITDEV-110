/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_finalproject;

import java.util.ArrayList;

/**
 *
 * @author barrymolina
 */
public class Board {
	
    final int ROWS = 6;
    final int COLUMNS = 7;
    int[][] board = new int[ROWS][COLUMNS];
	final int NUM_TOKENS = 3;
	char[] tokens = new char[NUM_TOKENS];
	final char BLANK = '_';
	final char[] COL_CHARS = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
    final int FLASH_NUM = 3;
    final int REFRESH_RATE = 250;
	
	public Board(char p1Token, char p2Token) {
		tokens[0] = BLANK;
		tokens[1] = p1Token;
		tokens[2] = p2Token;
		
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = 0;
            }
        }
	}
    public int[][] getBoard() {
        return board;
    }
    public void printBoard() {
        
        for (int row = 0; row < board.length; row++) {

            System.out.print("|");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(tokens[board[row][col]] + "|");
            }
            System.out.print("\n");
        }
		for (char letter : COL_CHARS) {
			System.out.print(" " + letter);
		}
		System.out.println();
		System.out.println();
    }
    public void printBoard(int[][] b) {
        
        for (int row = 0; row < b.length; row++) {

            System.out.print("|");
            for (int col = 0; col < b[row].length; col++) {
                System.out.print(tokens[b[row][col]] + "|");
            }
            System.out.print("\n");
        }
		for (char letter : COL_CHARS) {
			System.out.print(" " + letter);
		}
		System.out.println();
		System.out.println();
    }
	public int drop(int pNum, int idx) throws InterruptedException {
		int row = 0;
		while (row < board.length && board[row][idx] == 0) {
			board[row][idx] = pNum;
			if (row > 0) {
				board[row - 1][idx] = 0;
			}
			//System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			//printBoard();
			row++;
			//Thread.sleep(REFRESH_RATE);
		}
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        return row - 1;
	}
    public void flash(ArrayList<Integer> rows, ArrayList<Integer> cols) throws InterruptedException {
        int[][] copy = copyBoard();
        for (int i = 0; i < rows.size(); i++) {
            copy[rows.get(i)][cols.get(i)] = 0;
        }
        for (int x = 0; x < FLASH_NUM; x++) {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard(copy);
			Thread.sleep(REFRESH_RATE);
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            printBoard();
			Thread.sleep(REFRESH_RATE);
        }
    }
    public int[][] copyBoard() {
        int[][] copy = new int[ROWS][COLUMNS];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                copy[row][col] = board[row][col];
            }
        }
        return copy;
    }
}
