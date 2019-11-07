import java.util.Scanner;
public class CorpsSales {

    public static void main(String[] args) {

        final int DIVS = 3; 
        final int QTRS = 4;
        double totalSales = 0.0;

        double[][] sales = new double[DIVS][QTRS];

        Scanner keyboard = new Scanner(System.in);

        System.out.println("This program will calculate the total sales of");
        System.out.println("all the company's divisions. Enter the following sales data:");

        for (int div = 0; div < DIVS; div++) {
            for (int qtr = 0; qtr < QTRS; qtr++) {
                System.out.printf("Division %d, Quarter %d: $", (div + 1), (qtr + 1));
                sales[div][qtr] = keyboard.nextDouble();
            }
            System.out.println();
        }
        for (int div = 0; div < DIVS; div++) {
            for (int qtr = 0; qtr < QTRS; qtr++) {
                totalSales += sales[div][qtr];
            }
        }
        System.out.printf("Total company sales: $%,.2f\n", totalSales);

    }
}
