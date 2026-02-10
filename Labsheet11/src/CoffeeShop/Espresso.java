package CoffeeShop;

public class Espresso extends Drink{
    private int shot;

    public Espresso(String size,String drinkName,double basePrice,int shot){
        super("Espresso",35,size);
        this.shot = 0;
    }

    public int getShot() {
        return shot;
    }

    public void addShot(int shot){
        this.shot = this.shot + shot;

    }

@Override
    public double calculateFinalPrice(){
        return getBasePrice()+(this.shot*15)+getSizeExtra();
    }

    public String toString(){
        return toString()+((this.shot >0)?"Added "+this.shot:"")+
                "\nTotal price = "+ calculateFinalPrice()+" Baht";
    }
}
