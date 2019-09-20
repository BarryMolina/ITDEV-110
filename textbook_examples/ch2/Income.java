import java.util.Scanner;

public class Income {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("What is your annual income? ");
        int income = keyboard.nextInt();
        
        System.out.println("Wow, you make $" + income + " dollars a year?");


    }
}
