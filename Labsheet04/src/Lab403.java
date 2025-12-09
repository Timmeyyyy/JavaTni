import javax.swing.*;

public class Lab403 {
    public static void main(String[] args) {
        final String username = "admin";
        final String password = "Admin1234";
        while(true)
        {
            String user = JOptionPane.showInputDialog("Enter username: ");
            String pass = JOptionPane.showInputDialog("Enter password: ");

            if(username.equalsIgnoreCase(user) && password.equals(pass))
            {
                break;
            }

            JOptionPane.showMessageDialog(null,"Login Fail...","Incorrect username or passeord",JOptionPane.WARNING_MESSAGE);
        }
        JOptionPane.showMessageDialog(null,"Login Success!!");
    }
}
 