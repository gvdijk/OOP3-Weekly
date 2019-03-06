package week2.pizza;

// a Concrete Component
public class PlainPizza implements Pizza {

    private String size;

    public PlainPizza(String size){
        this.size = size;
    }
 
    public String getDescription() {
        return "Just a " + size + " plain pizza";
    }

    public double getCost() {
        double cost = 0;
        switch (size){
            case "large": cost = 5.00;
                break;
            case "medium": cost = 4.00;
                break;
            case "small": cost = 3.00;
                break;
        }
        System.out.println("Cost of plain pizza: " + cost);
        return cost;
    }

    public String getSize(){
        return size;
    }

    public void setSize(String size){
        this.size = size;
    }
}
