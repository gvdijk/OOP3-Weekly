package week2.stock;

public interface Subject {
   
    public void register(Observer o);
    public void unregister(Observer o);
    public void notifyObservers(String stockName, double stockPrice);
}

