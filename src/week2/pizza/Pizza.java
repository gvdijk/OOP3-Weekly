package week2.pizza;

enum PizzaSize {large, medium, small}

// the Component
public interface Pizza {
    public String getDescription();
    public double getCost();
    public PizzaSize getSize();
    public void setSize(PizzaSize size);
}
