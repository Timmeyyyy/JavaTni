import javax.swing.*;

public class ProductMain {
    public static void main(String[] args) {
        Product p1 = new Product();
        boolean change = false;
        JOptionPane.showMessageDialog(null,"Welcome to Product Stock System");



        p1.name=JOptionPane.showInputDialog("Enter product name:");
        p1.price=Double.parseDouble(JOptionPane.showInputDialog("Enter product price per item:"));
        p1.Stock=Integer.parseInt(JOptionPane.showInputDialog("Enter product stock:"));

        p1.showInfo();

        int addMore = JOptionPane.showConfirmDialog(null,"Do you want to ad more item?",
                "Select an Option",JOptionPane.YES_NO_CANCEL_OPTION);
        if (addMore==JOptionPane.YES_OPTION)
        {
            p1.addStock(Integer.parseInt(JOptionPane.showInputDialog("How many item to add in stock?")));
            change = true;
        }
        int changePrice = JOptionPane.showConfirmDialog(null,"Do you want to change price?",
                "Select an Option",JOptionPane.YES_NO_CANCEL_OPTION);
        if (changePrice==JOptionPane.YES_OPTION)
        {
            p1.changePrice(Double.parseDouble(JOptionPane.showInputDialog("How much is the new price per items?")));
            change = true;
        }
        if (change)
            System.out.println();


        p1.showInfo();
    }
}
