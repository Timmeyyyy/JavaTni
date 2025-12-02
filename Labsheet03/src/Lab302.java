import javax.swing.*;

public class Lab302 {
    static void main(String[] args) {
        final double HIGHT_MAN = -100;
        final double HIGHT_WOMEN = -110;
        double result =0;
        String name = JOptionPane.showInputDialog("Enter your name:");
        double hight_cm = Double.parseDouble(JOptionPane.showInputDialog("Enter your height(cm):"));
        int gender = JOptionPane.showConfirmDialog(
                null,
                "Are your biological gender is Male?","Gender",JOptionPane.YES_NO_OPTION);


        if (gender == JOptionPane.YES_OPTION){
            result = hight_cm+HIGHT_MAN;
        }
        else if (gender == JOptionPane.NO_OPTION){
            gender = JOptionPane.showConfirmDialog(
                    null,
                    "Are your biological gender is Female?","Gender",JOptionPane.YES_NO_OPTION);
            if (gender == JOptionPane.YES_OPTION){
                result = hight_cm+HIGHT_WOMEN;
            }
            else {
                JOptionPane.showMessageDialog(null,"You can use BMI to measure your weight and height.");
            }

        }

        if (gender == JOptionPane.YES_OPTION)
            JOptionPane.showMessageDialog(null,"Hello,Mr."+name
                    +"\nif your height is "+hight_cm
                    +"\nYour weight should be "+result+" km.");

    }
}