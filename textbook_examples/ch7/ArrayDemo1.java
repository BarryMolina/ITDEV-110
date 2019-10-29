import java.util.Scanner;

public class ArrayDemo1 {

    public static void main(String[] args) {

        final int EMPLOYEES = 3;
        int[] hours = new int[EMPLOYEES];

        Scanner keyboard = new Scanner(System.in); 

        System.out.println("Enter the hours worked by " + EMPLOYEES + " employees 1.");
        System.out.print("Employee 1: ");
        hours[0] = keyboard.nextInt();

        System.out.println("Enter the hours worked by " + EMPLOYEES + " employees 2.");
        System.out.print("Employee 2: ");
        hours[1] = keyboard.nextInt();

        System.out.println("Enter the hours worked by " + EMPLOYEES + " employees 3.");
        System.out.print("Employee 3: ");
        hours[2] = keyboard.nextInt();

        System.out.println("The hours you entered are:");
        System.out.println(hours[0]);
        System.out.println(hours[1]);
        System.out.println(hours[2]);

    }
}
