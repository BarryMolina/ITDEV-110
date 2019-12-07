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
public class WinBanner {
	final int SCREEN_WIDTH = 40;
	String empty = "                                        ";
	String[] player = {
		"  _____  _                       ",
		" |  __ \\| |                      ",
		" | |__) | | __ _ _   _  ___ _ __ ",
		" |  ___/| |/ _` | | | |/ _ \\ '__|",
		" | |    | | (_| | |_| |  __/ |   ",
		" |_|    |_|\\__,_|\\__, |\\___|_|   ",
		"                  __/ |          ",
		"                 |___/           "
	};
	String[] p1= {
		"  __  ",
		" /_ | ",
		"  | | ",
		"  | | ",
		"  | | ",
		"  |_| ",
		"      ",
		"      "
	};
	String[] p2= {
		"  ___   ",
		" |__ \\  ",
		"    ) | ",
		"   / /  ",
		"  / /_  ",
		" |____| ",
		"        ",
		"        "
	};
	String[] wins = {
		"__          ___             _  ",
		"\\ \\        / (_)           | | ",
		" \\ \\  /\\  / / _ _ __  ___  | | ",
		"  \\ \\/  \\/ / | | '_ \\/ __| | | ",
		"   \\  /\\  /  | | | | \\__ \\ |_| ",
		"    \\/  \\/   |_|_| |_|___/ (_) ",
		"                               ",
		"                               "
	};
	String[] banner;
	// creates banner strings
	public WinBanner(int playerNum) {
		banner = new String[player.length];
		String[] pNum;
		pNum = (playerNum == 1? p1 : p2);
		for (int x = 0; x < banner.length; x++) {
			banner[x] = empty + player[x] + pNum[x] + wins[x];
		}
	}
	// display win banner
	public void displayWinner() throws InterruptedException {
		int length = banner[0].length();
		int lineEnd;
			
		for (int lineStart = 0; lineStart < length; lineStart++) {
			// Ensures substring endIndex isnt greater than length
			// to avoid out of bounds error
			lineEnd = (lineStart + SCREEN_WIDTH < length? lineStart + SCREEN_WIDTH : length);
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			for (int i = 0; i < banner.length; i ++) {
				System.out.println(banner[i].substring(lineStart, lineEnd));
			}
			Thread.sleep(250);
		}
	}
}
