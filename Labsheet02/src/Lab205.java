import javax.swing.*;

public class Lab205 {
    public static void main(String[] args) {


        int total_minutes = Integer.parseInt(JOptionPane.showInputDialog(null,"Input minutes:"));

        int hour = total_minutes / 60;
        int minutes = total_minutes %60;

        JOptionPane.showMessageDialog(null,total_minutes + " minutes is " + hour + " hour " + minutes + " minute ");
    }
}
 