
package week2fun;


import java.util.Date;

public class MeetSamApp {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // must add above throws clause in order to use Thread.sleep method.
        Date d = new Date();                      //creates a new date object.
        System.out.println("It is now: " +  d );  //prints date
        System.out.print("\n");

        Thread.sleep(3000);                       //pause 3 seconds

        Sam TisHim = new Sam();                   //create a new sam object
    }
    
}
