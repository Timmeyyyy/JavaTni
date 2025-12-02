import java.awt.*;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter mid-term score: ");
        int midterm = scanner.nextInt();

        System.out.print("Enter final    score: ");
        int Final = scanner.nextInt();

        int total_score = midterm+Final;

        if (total_score > 100 || total_score < 0)
            System.out.println("Error score");



    }
}
