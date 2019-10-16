/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indprojtest1;
import java.util.Scanner;
/**
 *
 * @author barrymolina
 */
public class IndProjTest1 {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws InterruptedException {

		//hello();
		//hello2();
		//HelloBanner banner = new HelloBanner();
		//banner.hello();
		WelcomeBanner w = new WelcomeBanner();
		w.welcome();
	}
	public static String addSpace(int max) {
		char space = ' ';
		String spaces = "";
		for (int count = 0; count < max; count++) {
			spaces += space;
		}
		return spaces;
	}
	public static void hello() throws InterruptedException {
		while (true) {
			for (int count = 0; count < 7; count++) {
				System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println(addSpace(count) + "Hello");
				Thread.sleep(250);
			}
			for (int count = 7; count > 0; count--) {
				System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println(addSpace(count) + "Hello");
				Thread.sleep(250);
			}
		}
	}
	public static void hello2() throws InterruptedException {
		while (true) {
			for (int count = 0; count < 10; count++) {
				System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				for (int x = 0; x < count; x++) {
					System.out.print(" ");
				}
				System.out.println("Hello");
				Thread.sleep(250);
			}
		}
	}
}
