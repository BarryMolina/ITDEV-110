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
public class HelloBanner {

	public static void hello() throws InterruptedException {
		final int SCREEN_WIDTH = 10;
		String word = "           Hello";
		int length = word.length();
		int lineEnd;
		//int idx = 8;
		//int width = 8;
		//int line = (idx + width < length? idx + width : length);
		//System.out.println(word.substring(idx,line));
		
		while (true) {
			for (int lineStart = 0; lineStart < length; lineStart++) {
				// Ensures substring endIndex isnt greater than length
				// to avoid out of bounds error
				lineEnd = (lineStart + SCREEN_WIDTH < length? lineStart + SCREEN_WIDTH : length);
				System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println(word.substring(lineStart, lineEnd));
				Thread.sleep(250);
			}
		}
	}
	public static String addSpace(int max) {
		char space = ' ';
		String spaces = "";
		for (int count = 0; count < max; count++) {
			spaces += space;
		}
		return spaces;
	}
	
}
