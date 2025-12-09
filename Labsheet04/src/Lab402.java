import javax.swing.*;

public class Lab402 {
    public static void main(String[] args) {
        //ประกาศตัวแปร
        String serial_number = "";

        //กรอกตัวแปร
        while (serial_number.length()!=10){
            serial_number = JOptionPane.showInputDialog("Enter student-id:");
        }

        //หาสาขาที่นักศึกษาเข้าเรียน
        String Major = serial_number.substring(2,5);
        Major = switch (Major) {
            case ("131") -> "Information Technology (IT)";
            case ("132") -> "Multimedia Technology (MT)";
            case ("133") -> "Digital Business Information Technology (BI)";
            case ("134") -> "Digital Technology in Mass Communication (DC)";
            case ("135") -> "Data Science and Data Analytics (DS)";
            default -> "Cannot found major";
        };

        //แสดงผลตัวเลขและสาขา
        JOptionPane.showMessageDialog(null,"Student ID: "+serial_number+"\nMajor:"+Major);

    }
}
