public class Product {
    public String name;
    public int Stock;
    public double price;

    public void addStock(int amount){
        Stock += amount;
        System.out.println("Added "+amount+" items to stock");
    }

    public void changePrice(double newPrice){
            if (newPrice>0)
                price=newPrice;
            System.out.println("Change price  to "+price+" Baht");
    }

    public double stockvalue()
    {
        return price*Stock;
    }

    public void showInfo()
    {
        System.out.println("Name   : "+name);
        System.out.println("Price  : "+price+" Baht/Item");
        System.out.println("Stock  : "+Stock+" Items");
        System.out.println("Stock Value : "+ stockvalue()+" Baht");
        System.out.println();
    }

    public void sell(int amount)
    {
        if (amount<=Stock)
        {
            System.out.println("Sold "+amount+" items");
            Stock-=amount;
        }else
        {
            System.out.println("Not enough items in stock...");
        }
    }


}
