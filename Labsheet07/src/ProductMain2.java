import java.util.Scanner;

public class ProductMain2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product p1 = new Product();
        p1.name = "Pens";
        p1.price = 10.5;
        p1.Stock = 50;

        Product p2 = new Product();
        p2.name = "Notebooks";
        p2.price = 25.75;
        p2.Stock = 20;

        System.out.println("Welcome to Mini Shop" +
                "\n---------------------------------" +
                "\nPress [1] to buy Pen " +
                "\nPress [2] to but Notebook");

        System.out.print("Enter a number: ");
        int press = sc.nextInt();
        while (press!=1&&press!=2)
        {
            System.out.print("Invalaid number! Enter a number, again: ");
            press= sc.nextInt();
        }
        if (press==1)
        {
            System.out.println();
            p1.showInfo();
            System.out.println("---------------------------------" );
            System.out.print("How many Pens do you want to buy? ");
            p1.sell(sc.nextInt());
            System.out.println("---------------------------------" );
            p1.showInfo();
        }
        else
        {
            System.out.println();
            p2.showInfo();
            System.out.println("---------------------------------" );
            System.out.print("How many Pens do you want to buy? ");
            p2.sell(sc.nextInt());
            System.out.println("---------------------------------" );
            p2.showInfo();
        }


    }
}