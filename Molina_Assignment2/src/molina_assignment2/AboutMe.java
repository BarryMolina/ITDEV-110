/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_assignment2;

/**
 *
 * @author barrymolina
 */
import java.time.LocalDate;

public class AboutMe {
    
    public AboutMe() {
        DisplayInfo();
    
}
    public void DisplayInfo() {
        LocalDate d = LocalDate.now();
        System.out.println("Barry Molina \tAssignment 2");
        System.out.println("ITDEV-110-500 \tIntro to Object "
                           + "Oriented Programming");
        System.out.println("Elijah Jones \t" + d);
    }
}
