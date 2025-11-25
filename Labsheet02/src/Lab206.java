import javax.swing.*;
import java.text.DecimalFormat;

public class Lab206 {
    public static void main(String[] args) {
        final int BUFFET_PRICE = 299;
        final int NET = 7;
        DecimalFormat frm = new DecimalFormat("#,###.00");


        int customer_count = Integer.parseInt(JOptionPane.showInputDialog(null,"How many customer?"));
        double customer_buffet_price = BUFFET_PRICE * customer_count;
        double buffet_price_with_net = (customer_buffet_price*NET)/100 + customer_buffet_price;
        int discount_customer = Integer.parseInt(JOptionPane.showInputDialog(null,"Price with NET is "
                + frm.format(buffet_price_with_net)+" baht."
                + "\nHow much of discount(%) on your coupon?"));

        double discount_buffet = (buffet_price_with_net*discount_customer)/100;
        double total_price = buffet_price_with_net-discount_buffet;

        int customer_paid = Integer.parseInt(JOptionPane.showInputDialog(null,"Total price is "+ frm.format(total_price)
                + " baht." + "\nEnter the amount the customer paid: "));

        double cashback = customer_paid-total_price;

        JOptionPane.showMessageDialog(null,"Total price is " + frm.format(total_price) + " baht."
                + "\nCustomer paid "+ frm.format(customer_paid) + " baht." + "\nGet change " + frm.format(cashback) + " baht." , "Massage",JOptionPane.INFORMATION_MESSAGE);




    }
}