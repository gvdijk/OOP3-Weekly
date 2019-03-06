package week2.stock;

import java.util.ArrayList;

public class StockObserver implements Observer, ViewSubject {

    private ArrayList<View> views = new ArrayList<>();
    
    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;
    
    // static used as a counter
    private static int observerIDTracker = 0;
    
    // to track the observers
    private int observerID;
    
    // a reference to concrete subject
    private Subject stockGrabber;
    
    public StockObserver(Subject stockGrabber) {
        this.stockGrabber = stockGrabber;
        this.observerID = ++observerIDTracker;
        stockGrabber.register(this);

        System.out.println("New Observer " + this.observerID);
    }
    
    // update all observers
    public void update(double ibmPrice, double aaplPrice, double googPrice) {
        this.ibmPrice = ibmPrice;
        this.aaplPrice = aaplPrice;
        this.googPrice = googPrice;
        notifyViews();
    }

    @Override
    public void register(View v) {
        views.add(v);
    }

    @Override
    public void unregister(View v) {
        views.remove(v);
    }

    @Override
    public void notifyViews() {
        for (View v : views){
            v.update(ibmPrice, aaplPrice, googPrice);
        }
    }
}
