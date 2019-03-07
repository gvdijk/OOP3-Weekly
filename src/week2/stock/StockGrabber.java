package week2.stock;

import java.util.ArrayList;

public class StockGrabber implements Subject {
    private ArrayList<Observer> observers;

    public StockGrabber() {
        observers = new ArrayList<>();
    }

    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    public void unregister(Observer newObserver) {
        observers.remove(newObserver);
    }

    public void notifyObservers(String stockName, double stockPrice) {
        for(Observer observer : observers){
            observer.update(stockName, stockPrice);
        }
    }

    public void setPrice(String stockName, double stockPrice) {
        notifyObservers(stockName, stockPrice);
    }
}
