package week2.pizza;

// a Concrete Decorator
public class TomatoSauce extends ToppingDecorator {

    public TomatoSauce(Pizza newPizza) {
        super(newPizza);
        System.out.println("Adding sauce");
    }
    
    public String getDescription() {
        return tempPizza.getDescription() + ", tomato sauce";
    }
    
    public double getCost() {
        double cost = 0;
        switch (tempPizza.getSize()){
            case "large": cost = 0.45;
                break;
            case "medium": cost = 0.35;
                break;
            case "small": cost = 0.25;
                break;
        }
        System.out.println("Cost of sauce: " + cost);
        return tempPizza.getCost() + cost;
    }
}
