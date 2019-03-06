package week2.stock;

import java.util.ArrayList;

public class StockGrabber implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();

    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;

    public StockGrabber() {}

    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    public void unregister(Observer newObserver) {
        observers.remove(newObserver);
    }

    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(ibmPrice, aaplPrice, googPrice);
        }
    }

    public void setIBMPrice(double newIBMPrice) {
        this.ibmPrice = newIBMPrice;
        notifyObservers();
    }

    public void setAAPLPrice(double newAAPLPrice) {
        this.aaplPrice = newAAPLPrice;
        notifyObservers();
    }

    public void setGOOGPrice(double newGOOGPrice) {
        this.googPrice = newGOOGPrice;
        notifyObservers();
    }
}
