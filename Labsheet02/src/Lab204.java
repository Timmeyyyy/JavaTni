import java.awt.*;
import java.util.Scanner;

public class Lab204 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input hour  : ");
        int hour = Integer.parseInt(scanner.next());
        scanner.nextLine();

        System.out.print("Input minute: ");
        int minute = Integer.parseInt(scanner.next());

        int total_minute = (hour*60)+minute;

        System.out.println("Total time is "+total_minute+" minute");
    }
}
