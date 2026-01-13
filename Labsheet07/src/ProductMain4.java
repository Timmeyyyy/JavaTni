import java.util.Scanner;

public class ProductMain4 {
    public static void setting_product(Product... products) {

        String[] names = {"Pens", "Pencils", "Markers", "Highlighters"};
        double[] prices = {25.5, 17.25, 30, 35};
        int[] quantities = {20, 35, 10, 40};

        for (int i=0; i<products.length; i++) {
            products[i] = new Product();
            products[i].name = names[i];
            products[i].price = prices[i];
            products[i].Stock = quantities[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product p1 = new Product();
        Product[]products = new Product[4];
        setting_product(products);

        System.out.println("Welcome to MINI SHOP!" +
                "\n--------------------------------------------------");

        for (int i =0;i<products.length;i++)
        {
            System.out.println("Press "+(i+1)+" to buy "+products[i].name+
                    " (items="+products[i].Stock+")");
        }
        System.out.println("--------------------------------------------------");

        System.out.print("Enter a number: ");
        int press = sc.nextInt();
        while (press<=0||press>4)
        {
            System.out.print("Invalaid!! Enter a number: ");
            press = sc.nextInt();
        }
        System.out.println("--------------------------------------------------");

        Product p = products[press-1];
        System.out.print("How many"+p.name+" do you want to buy? ");
        int wantBuy = sc.nextInt();
        p.sell(wantBuy);

        System.out.println();
        p.showInfo();
    }


}