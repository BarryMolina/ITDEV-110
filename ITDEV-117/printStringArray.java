public class printStringArray {

    public static void main(String[] args) {

        String[] strArray = {"Jacob", "John", "Adam"};
        int x = 0;

        try {
            while (true) {
                System.out.println(strArray[x]);
                x++;
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Now you've gone to far");
        }
    }
}
