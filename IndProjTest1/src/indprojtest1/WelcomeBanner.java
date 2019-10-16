/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indprojtest1;

/**
 *
 * @author barrymolina
 */
public class WelcomeBanner {
	public static void welcome() throws InterruptedException {
		final int SCREEN_WIDTH = 30;
		String word0 = "                              ";
		String word1 = word0 + " __          __  _                          ";
		String word2 = word0 + " \\ \\        / / | |                         ";
		String word3 = word0 + "  \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___ ";
		String word4 = word0 + "   \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\";
		String word5 = word0 + "    \\  /\\  /  __/ | (_| (_) | | | | | |  __/";
		String word6 = word0 + "     \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|";
		int length = word1.length();
		int lineEnd;
		
		while (true) {
			for (int lineStart = 0; lineStart < length; lineStart++) {
				// Ensures substring endIndex isnt greater than length
				// to avoid out of bounds error
				lineEnd = (lineStart + SCREEN_WIDTH < length? lineStart + SCREEN_WIDTH : length);
				System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println(word1.substring(lineStart, lineEnd));
				System.out.println(word2.substring(lineStart, lineEnd));
				System.out.println(word3.substring(lineStart, lineEnd));
				System.out.println(word4.substring(lineStart, lineEnd));
				System.out.println(word5.substring(lineStart, lineEnd));
				System.out.println(word6.substring(lineStart, lineEnd));
				Thread.sleep(250);
			}
		}
	}
	
}
