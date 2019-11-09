/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_magazinedemo;

/**
 *
 * @author barry
 * Barry Molina, ITDEV-117-500, Assignment 7
 */
public class Molina_MagazineDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MagazineSubscription e = new MagazineSubscription();
        MagazineSubscription p = new MagazineSubscription();

        e.setSubscriber("Barry");
		e.setMagazine("Esquire");
		e.setMonths(6);

		p.setSubscriber("Josh");
		p.setMagazine("Popular Mechanics");
		p.setMonths(4);

		System.out.println(e.getSubscriber() + " is subscribed to " + e.getMagazine() + " and has " +
					e.getMonths() + " months remaining.");

		System.out.println(p.getSubscriber() + " is subscribed to " + p.getMagazine() + " and has " +
					p.getMonths() + " months remaining.");

    }
    
}
