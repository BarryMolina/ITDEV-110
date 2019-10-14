import javax.swing.JOptionPane;

public class CurrencyFormat2 {

    public static void main(String[] args) {
        double monthlyPay = 5000.0;
        double annualPay = monthlyPay * 12;
        String output = String.format("Your annual pay is $%,.2f", annualPay);

        JOptionPane.showMessageDialog(null, output);
    }
}
