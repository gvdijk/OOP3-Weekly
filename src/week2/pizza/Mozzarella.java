package week2.pizza;

// a Concrete Decorator
public class Mozzarella extends ToppingDecorator {

    public Mozzarella(Pizza newPizza) {
        super(newPizza);
        System.out.println("Adding Mozzarella");
    }
    
    public String getDescription() {
        return tempPizza.getDescription() + ", mozzarella";
    }
    
    public double getCost() {
        double cost = 0;
        switch (tempPizza.getSize()){
            case large: cost = 0.70;
                break;
            case medium: cost = 0.50;
                break;
            case small: cost = 0.30;
                break;
        }
        System.out.println("Cost of mozzarella: " + cost);
        return tempPizza.getCost() + cost;
    }
}
