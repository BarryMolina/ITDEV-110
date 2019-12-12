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
public class Molina_FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
		Admin a = new Admin();

		a.intro();
        GameController gc = new GameController();
		a.goodbye();
    }
    
}
