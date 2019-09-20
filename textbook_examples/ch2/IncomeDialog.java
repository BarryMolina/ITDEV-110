import javax.swing.JOptionPane;

public class IncomeDialog {

    public static void main(String[] args) {
        String income;
        income = JOptionPane.showInputDialog("What is your salary?");
        double incomeDouble = Double.parseDouble(income); 

        
        JOptionPane.showMessageDialog(null, "What?? $" + incomeDouble + " dollars a year??");


    }
}
