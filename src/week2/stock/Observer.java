package week2.stock;

public interface Observer {
    
    public void update(double ibmPrice, 
        double aaplPrice, double googPrice);
}

