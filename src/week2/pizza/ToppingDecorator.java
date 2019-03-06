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
    public String getSize() {
        return tempPizza.getSize();
    }

    @Override
    public void setSize(String size) {
        tempPizza.setSize(size);
    }
}
