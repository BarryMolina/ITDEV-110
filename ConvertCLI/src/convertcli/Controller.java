/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertcli;

/**
 *
 * @author barrymolina
 */
public class Controller {
	
	Converter c;
	UserInterface ui;

	public Controller() {
		ui = new UserInterface();
		do  {
			ui.getInput();
			c = new Converter(ui.getStartBase(), ui.getEndBase(), ui.getNumber());
            c.convert();
			ui.displayResult(c.getNewNumber());
		} while (ui.convertAgain() == 'y');
	}
}
