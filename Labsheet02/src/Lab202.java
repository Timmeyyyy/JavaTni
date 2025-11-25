import java.util.Scanner;

public class Lab202 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter number 2: ");
        double num2 = scanner.nextDouble();

        System.out.println("Summation = " + (num1 + num2));
        System.out.println("Subtraction = " + (num1 - num2));
        System.out.println("Multiplication = " + (num1 * num2));
        System.out.println("Division = " + (num1 / num2));
        System.out.println("Modulus = " + (num1 % num2));
    }
}
