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
public class WinChecker {
	int row;
	int col;
	int player;
	int[][] board;
    int CONNECT = 4;
	ArrayList<Integer> matchRows;
    ArrayList<Integer> matchCols;
    int matches;

	public WinChecker(int[][] board) {
		this.board = board;
	}
	public boolean checkWin(int row, int col) {
		this.row = row;
		this.col = col;
		player = board[row][col];
        matchRows = new ArrayList<>();
        matchCols = new ArrayList<>();
		matches = 0;
		addMatch(row, col);

        boolean win = false;

        if (down() || sideToSide() || downDiag() || upDiag()) {
            win = true;
        }
        return win;
	}
	//Checks for four in a row straight down.
    public boolean down() {
        int r = row + 1;
		//Won't run if token isn't at least four spaces up
		if (board.length - row >= CONNECT) {
			while (r < board.length && board[r][col] == player) {
                addMatch(r, col);
				r++;
			}
		}
        return (matches >= CONNECT);
    }
	public boolean sideToSide() {
		resetMatches();
		if (col > 0) {
			left();
		}
		if (col < board[row].length -1) {
			right();
		}
		return matches >= CONNECT;
	}
	public void left() {
		int c = col - 1;
		while (c >= 0 && board[row][c] == player) {
			addMatch(row, c);
			c--;
		}
	}
	public void right() {
		int c = col + 1;
		while (c < board[row].length && board[row][c] == player) {
			addMatch(row, c);
			c++;
		}
	}
	public boolean upDiag() {
		resetMatches();
		if ((col <= -row + 8) && (col >= -row +3)) {
			if (row < board.length - 1) {
				leftDown();
			}
			if (row > 0) {
				rightUp();
			}
		}
		return matches >= CONNECT;
	}
	public void leftDown() {
		int r = row + 1;
		int c = col - 1;
		while (r < board.length && c >= 0 && board[r][c] == player) {
			addMatch(r, c);
			r++;
			c--;
		}
	}
	public void rightUp() {
		int r = row - 1;
		int c = col + 1;
		while (r >= 0 && c < board[r].length && board[r][c] == player) {
			addMatch(r, c);
			r--;
			c++;
		}
	}
	public boolean downDiag() {
		resetMatches();
		if ((col <= row + 3) && (col >= row - 2)) {
			if (row > 0) {
				leftUp();
			}
			if (row < board.length -1) {
				rightDown();
			}
		}
		return matches >= CONNECT;
	}
	public void leftUp() {
		int r = row - 1;
		int c = col - 1;
		while (r >= 0 && c >= 0 && board[r][c] == player) {
			addMatch(r, c);
			r--;
			c--;
		}
	}
	public void rightDown() {
		int r = row + 1;
		int c = col + 1;
		while (r < board.length && c < board[r].length && board[r][c] == player) {
			addMatch(r, c);
			r++;
			c++;
		}
	}
    public void addMatch(int r, int c) {
		matchRows.add(r);
		matchCols.add(c);

        matches++;
    }
	public void resetMatches() {
		matchRows.subList(1, matchRows.size()).clear();
		matchCols.subList(1, matchCols.size()).clear();

		matches = 1;
	}

    public ArrayList<Integer> getCols() {
        return matchCols;
    }

    public ArrayList<Integer> getRows() {
        return matchRows;
    }
}
