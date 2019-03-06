package week2.pizza;

// Abstract Decorator
abstract class ToppingDecorator implements Pizza {
    protected Pizza tempPizza;
    
    public ToppingDecorator(Pizza newPizza) {
        tempPizza = newPizza;
    }
    
    public String getDescription() {
        return tempPizza.getDescription();
    }

    public double getCost() {
        return tempPizza.getCost();
    }

    @Override
    public PizzaSize getSize() {
        return tempPizza.getSize();
    }

    @Override
    public void setSize(PizzaSize size) {
        tempPizza.setSize(size);
    }
}
