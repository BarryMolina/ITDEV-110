/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molinaweek2demo;

/**
 *
 * @author student
 */
public class AboutScooby 
{
    
    public AboutScooby() 
    {
        displayPoem();
        displayScoobyInfo();
    }
    
    public void displayPoem()
    {
        System.out.println("Roses are red, "
                         + "violets are blue, "
                         + "feet are smelly and so are shoes\n");
        System.out.println("\n");
    }
    
    public void displayScoobyInfo()
    {
        System.out.println("Scooby doo " + "\tCrime Fighting Detective Dog");
        System.out.println("50" + "\t\tShaggy");
        System.out.println("Scooby Snacks " + "\tBroadcast by ABC");
    }
}
