package CoffeeShop;

public class Frappuccino extends Drink{
    private boolean whipped;

    public Frappuccino(String size,String drinkName,double basePrice,boolean whipped){
        super("Frappushino",40,size);
        this.whipped = whipped;
    }

    @Override
    public double calculateFinalPrice(){
        return getBasePrice()+(whipped?15:0)+getSizeExtra();
    }

    public String toString() {
        return super.toString()
                + (whipped ? "\nAdd whipped  15 Baht" : "")
                + "\nTotal price = " + calculateFinalPrice() + " Baht.";
    }
}
