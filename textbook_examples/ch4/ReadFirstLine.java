import java.io.*;
import java.util.Scanner;
public class ReadFirstLine {

    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the name of a file: ");
        String filename = keyboard.nextLine();

        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        String line = inputFile.nextLine();
        System.out.println("The first line in the file is: ");
        System.out.println(line);

        inputFile.close();
    }
}
