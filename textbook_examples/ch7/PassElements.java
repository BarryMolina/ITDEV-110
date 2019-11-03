public class PassElements {

    public static void main(String[] args) {

        int[] numbers = {5, 10, 15, 20, 25, 30, 35, 40};

        for (int index = 0; index < numbers.length; index++)
            showValue(numbers[index]);
    }
    public static void showValue(int n) {
        System.out.print(n + " ");
    }
}
