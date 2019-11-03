import java.util.Scanner; 
public class PayArray {

    public static void main(String[] args) {
        final int EMPLOYEES = 5;
        double payRate, grossPay;

        int[] hours = new int[EMPLOYEES];

        Scanner keyboard = new Scanner(System.in); 

        System.out.println("Enter the hours worked by " + EMPLOYEES +
                            " employees who all earn the same hourly rate.");

        for (int index = 0; index < EMPLOYEES; index++) {
            System.out.print("Employee #" + (index + 1) + ": ");
            hours[index] = keyboard.nextInt();
        }

        System.out.print("Enter the hourly rate for each employee: ");
        payRate = keyboard.nextDouble();

        System.out.println("Here is each employee's gross pay");
        for (int index = 0; index < EMPLOYEES; index++) {
            grossPay = hours[index] * payRate;
            System.out.println("Employee #" + (index + 1) + ": $" + grossPay);
        }
    }
}
