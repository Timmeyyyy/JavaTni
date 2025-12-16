import javax.swing.*;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.Scanner;

public class Lab501 {
    public static double cal_bmi(double weight ,double height_cm){
        return weight/Math.pow((height_cm/100),2);
    }
    //    o BMI น้อยกว่า 18.5 คืนค่า “Underweight”
//    o BMI 18.5 - 24.9 คืนค่า “Healthy Weight”
//    o BMI 25 - 29.9 คืนค่า “Overweight”
//    o BMI ตั้งแต่ 30 ขึ้นไป คืนค่า “Obese”
    public static  String  check_bmi(double bmi){
        return (bmi<18.5)?"Underweight":(bmi >= 18.5 && bmi <= 24.9)?"Healthy Weight":(bmi >= 25 && bmi <= 29.9)?"Overweight":"Obese" ;
    }

    static void main(String[] args) {
        int check = JOptionPane.showConfirmDialog(null,
                "Do you want to check your BMI?","Check_BMI",JOptionPane.YES_NO_OPTION);

        DecimalFormat format = new DecimalFormat("##.00");
        if (check == JOptionPane.YES_OPTION){
            double weight = Double.parseDouble(JOptionPane.showInputDialog("Enter your weight (kg.):"));
            double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height (cm.):"));

            JOptionPane.showMessageDialog(null,"Your BMI = "
                    +format.format(cal_bmi(weight,height))
                    +"\nYour BMI result = "+ check_bmi(cal_bmi(weight,height)));

        }
    }

}
 