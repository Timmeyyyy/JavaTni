package CoffeeShop;

import java.util.Scanner;

class CoffeeShop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char more;
        int EspressoCount = 0;
        int FrappuccinoCount = 0;
        double total = 0;

        do {
            System.out.print(
                    "Press 1 for ordering Espresso" +
                            "\nPress 2 for ordering Frappuccino" +
                            "\nEnter an option: "
            );

            int pressOrder = sc.nextInt();
            sc.nextLine(); // เคลียร์บรรทัด

            if (pressOrder == 1) {
                Espresso order = orderEspresso(sc);
                System.out.println(order);
                EspressoCount++;
                total += order.calculateFinalPrice();

            } else if (pressOrder == 2) {
                Frappuccino order = orderFrappuccino(sc);
                System.out.println(order);
                FrappuccinoCount++;
                total += order.calculateFinalPrice();
            }

            System.out.print("\nDo you want to order more [y/Y]? ");
            more = sc.next().charAt(0);
            sc.nextLine(); // เคลียร์บรรทัด
            System.out.println();

        } while (more == 'y' || more == 'Y');

        System.out.println("You ordered " + EspressoCount + " Espresso");
        System.out.println("You ordered " + FrappuccinoCount + " Frappuccino");
        System.out.println("Total Price = " + total + " Baht");

        sc.close();
    }

    public static Espresso orderEspresso(Scanner sc) {
        System.out.print("Enter a size: ");
        String size = sc.nextLine();

        System.out.print("Press 'y' or 'Y' for adding a shot: ");
        char addShot = sc.next().charAt(0);

        Espresso espresso = new Espresso(size,"Espresso",35,0 );

        if (addShot == 'y' || addShot == 'Y') {
            System.out.print("How many shots to add? ");
            int shots = sc.nextInt();
            espresso.addShot(shots);
        }

        return espresso;
    }

    public static Frappuccino orderFrappuccino(Scanner sc) {
        System.out.print("Enter a size: ");
        String size = sc.nextLine();

        System.out.print("Do you want to add whipped cream [y/Y]? ");
        char whip = sc.next().charAt(0);

        boolean addWhip = (whip == 'y' || whip == 'Y');

        return new Frappuccino(size,"Frappuccino",40,addWhip);
    }
}
