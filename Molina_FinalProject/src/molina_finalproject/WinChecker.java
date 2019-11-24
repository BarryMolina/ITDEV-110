/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_finalproject;

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

	public WinChecker(int[][] board) {
		this.board = board;
	}
	public boolean checkWin(int row, int col) {
		this.row = row;
		this.col = col;
        boolean win = false;
		player = board[row][col];
        if (down() || sideToSide() || downDiag() || upDiag()) {
        //if (down()) { 
            win = true;
        }
        return win;
	}
	//Checks for four in a row straight down.
    public boolean down() {
		//System.out.println("Down is running");
        int inRow = 1;
        int r = row + 1;
		//Won't run if token isn't at least four spaces up
		if (board.length - row >= CONNECT) {
			//System.out.println("At least 4 spaces up");
			while (r < board.length && board[r][col] == player) {
				//System.out.println("found match at " + r + ", " + col);
				inRow++;
				r++;
			}
		}
        return (inRow >= CONNECT);
    }
	public boolean sideToSide() {
		//System.out.println("sideToSide start");
		int inRow = 1;
		if (col > 0) {
			//System.out.println("checking left");
			inRow += left();
		}
		if (col < board[row].length -1 && inRow < CONNECT) {
			//System.out.println("checking right");
			inRow += right();
		}
		return inRow >= CONNECT;
	}
	public int left() {
		int matches = 0;
		int c = col - 1;
		while (c >= 0 && board[row][c] == player && matches < CONNECT) {
			//System.out.println("found match at " + row + ", " + c);
			//if (board[row][c] == player ) {
				//matches++;
			//}
			matches++;
			c--;
		}
		return matches;
	}
	public int right() {
		int matches = 0;
		int c = col + 1;
		while (c < board[row].length && board[row][c] == player && matches < CONNECT) {
			//System.out.println("found match at " + row + ", " + c);
			//if (board[row][c] == player ) {
				//matches++;
			//}
			matches++;
			c++;
		}
		return matches;
	}
	public boolean upDiag() {
		//System.out.println("upDiag()");
		int inRow = 1;
		if ((col <= -row + 8) && (col >= -row +3)) {
			//System.out.println("Within bounds");
			if (row < board.length - 1) {
				//System.out.println("leftDown()");
				inRow += leftDown();
			}
			if (row > 0 && inRow < CONNECT) {
				//System.out.println("rightUp()");
				inRow += rightUp();
			}
		}
		return inRow >= CONNECT;
	}
	public int leftDown() {
		int matches = 0;
		int r = row + 1;
		int c = col - 1;
		while (r < board.length && c >= 0 && board[r][c] == player && matches < CONNECT) {
			//System.out.println("found match at " + r + ", " + c);
			//if (board[r][c] == player) {
				//matches++;
			//}
			matches++;
			r++;
			c--;
		}
		return matches;
	}
	public int rightUp() {
		int matches = 0;
		int r = row - 1;
		int c = col + 1;
		while (r >= 0 && c < board[r].length && board[r][c] == player && matches < CONNECT) {
			//System.out.println("found match at " + r + ", " + c);
			//if (board[r][c] == player) {
				//System.out.println("found match");
				//matches++;
			//}
			matches++;
			r--;
			c++;
		}
		return matches;
	}
	public boolean downDiag() {
		int inRow = 1;
		//System.out.println("downDiag()");
		if ((col <= row + 3) && (col >= row - 2)) {
			//System.out.println("Within bounds");
			if (row > 0) {
				//System.out.println("leftUp()");
				inRow += leftUp();
			}
			if (row < board.length -1 && inRow < CONNECT) {
				//System.out.println("rightDown()");
				inRow += rightDown();
			}
		}
		return inRow >= CONNECT;
	}
	public int leftUp() {
		int matches = 0;
		int r = row - 1;
		int c = col - 1;
		while (r >= 0 && c >= 0 && board[r][c] == player && matches < CONNECT) {
			//System.out.println("found match at " + r + ", " + c);
			//if (board[r][c] == player) {
				//System.out.println("found match");
				//matches++;
			//}
			matches++;
			r--;
			c--;
		}
		return matches;
	}
	public int rightDown() {
		int matches = 0;
		int r = row + 1;
		int c = col + 1;
		while (r < board.length && c < board[r].length && board[r][c] == player && matches < CONNECT) {
			//System.out.println("found match at " + r + ", " + c);
			//if (board[r][c] == player) {
				//System.out.println("found match");
				//matches++;
			//}
			matches++;
			r++;
			c++;
		}
		return matches;
	}

    public void printBoard() {
        
        for (int r = 0; r < board.length; r++) {

            for (int c = 0; c < board[r].length; c++) {
                System.out.print(board[r][c]);
            }
            System.out.print("\n");
        }
		System.out.println();
    }
			
	
}
