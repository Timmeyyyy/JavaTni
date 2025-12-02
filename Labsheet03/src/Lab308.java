import javax.swing.*;
import java.util.Scanner;

public class Lab308 {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many number to input: ");
        int number = scanner.nextInt();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int even = 0;
        int odd = 0;

        for (int i = 1; i <= number; i++)
        {
            System.out.print("Enter number " + i + ": ");
            int num = scanner.nextInt();


            if (num > max)
            {
                max = num;
            }
            if (num < min)
            {
                min = num;
            }


            if (num % 2 == 0)
            {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println();
        System.out.println("Maximum = " + max);
        System.out.println("Minimum = " + min);
        System.out.println();
        System.out.println("Even number = " + even);
        System.out.println("Odd number = " + odd);
    }
}