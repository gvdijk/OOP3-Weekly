package week2.stock;

import java.util.ArrayList;

public class StockObserver implements Observer, ViewSubject {

    private ArrayList<View> views;

    private String stockName;
    private double stockPrice;
    
    // to track the observers
    private int observerID;
    
    // a reference to concrete subject
    private Subject stockGrabber;
    
    public StockObserver(Subject stockGrabber, String stockName) {
        views = new ArrayList<>();
        this.stockName = stockName;
        this.stockGrabber = stockGrabber;
        stockGrabber.register(this);

        System.out.println("New Observer " + this.observerID);
    }
    
    // update all observers
    public void update(String stockName, double stockPrice) {
        if (this.stockName == stockName) {
            this.stockPrice = stockPrice;
            notifyViews();
        }
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
            v.update(stockName, stockPrice);
        }
    }
}
