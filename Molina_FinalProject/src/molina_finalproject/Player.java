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
public class Player {
	
	int playerNum;
	char token;
	
	public Player(int playerNum, char token) {
		this.token = token;
		this.playerNum = playerNum;
	}
	public int getNum() {
		return playerNum;
	}
	public char getToken() {
		return token;
	}
}
