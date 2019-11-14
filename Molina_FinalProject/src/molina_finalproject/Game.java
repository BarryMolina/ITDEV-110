/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_finalproject;

/**
 *
 * @author barry
 */
public class Game {

    final int ROWS = 6;
    final int COLUMNS = 7;
    final int PLAYER1 = 1;
    final int PLAYER2 = 2;
    int[][] board = new int[ROWS][COLUMNS];


    public void play() {
        
        updatePlayer1(5, 5);
        updatePlayer2(5, 4);
        updatePlayer1(4, 4);
        updatePlayer2(5, 3);
        printBoard();
        
    }
    public void updatePlayer1(int row, int col) {
        board[row][col] = PLAYER1;
    }
    public void updatePlayer2(int row, int col) {
        board[row][col] = PLAYER2;
    }
    public void printBoard() {
        
        for (int row = 0; row < board.length; row++) {

            System.out.print("|");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(((board[row][col] == 0)? " " : board[row][col])  + "|");
            }
            System.out.print("\n");
        }
    }
    public void reset() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = 0;
            }
        }
    }
    
}
