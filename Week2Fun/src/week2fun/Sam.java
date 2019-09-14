
package week2fun;


import java.net.InetAddress; 
import java.util.Scanner;

public class Sam {
  
    public Sam() throws InterruptedException
        {
            System.out.println("My name is Sam");
            System.out.println("I am Sam, I am");
            Thread.sleep(2000);

            System.out.println("\n Here is information about me:");
            DisplayMe();
            //give illusion of a clear console screen
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
     
            WhoAreYou();
            //give illusion of a clear console screen
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

            System.out.println("\n\t Gotta go....");

            Thread.sleep(1500);
           
            System.out.println("\n\t Goodbye!");
            Thread.sleep(1500);
    } //end Constructor method

        public void DisplayMe() throws InterruptedException
        {
            String OS = System.getProperty("os.name").toLowerCase();
            System.out.println(" \n\t OS Version:    " + OS);
            

            String computerName = ""; 
            
            try 
            { 
               computerName = InetAddress.getLocalHost().getHostName(); 
            }  
            catch(Exception ex) 
            { 
               System.out.println("throw error"); 
            };        
             
              System.out.println(" \n\t Machine Name: " + computerName);
            
              Thread.sleep(3000);
        } //end DisplayMe90

        public void WhoAreYou() throws InterruptedException
        {
            String a;
            String b = "Spongebob";
            System.out.print("\n");
            System.out.println("\t What is your name? ");
            
            //Scanner string;
            Scanner scanner = new Scanner(System.in);
            a = scanner.nextLine();
            System.out.println("\n\t Nice to meet you " + b);
           
            System.out.println(String.format("Oops I meant %s", a));
            
            Thread.sleep(3000);

        } //end WhoAreYou()

} //end class
  
