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
        //if (down() || leftRight() || downDiag() || upDiag()) {
        if (down()) { 
            win = true;
        }
        return win;
	}
    public boolean down() {
        int inRow = 1;
        int r = row + 1;
        while (r < board.length && board[r][col] == player) {
            inRow++;
            r++;
        }
        return (inRow >= CONNECT);
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
