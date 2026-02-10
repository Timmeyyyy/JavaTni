package CoffeeShop;

public abstract class Drink {
    private String drinkName;
    private double basePrice;
    private String size;

    public Drink(String drinkName, double basePrice, String size){
        this.drinkName = drinkName;
        this.basePrice = basePrice;
        this.size = size;
    }

    public String getDrinkName(){
        return drinkName;
    }


    public double getBasePrice(){
        return this.basePrice;
    }
    public int getSizeExtra(){
        return (size.strip().equalsIgnoreCase("s"))?0:
                (size.strip().equalsIgnoreCase("m"))?10:
                        (size.strip().equalsIgnoreCase("l"))?15:
                                -1;
    }

    public abstract double calculateFinalPrice();

    public String toString(){
        return "Your oder: "+drinkName+
                "(Size: "+size.toUpperCase()+")";
    }
}
