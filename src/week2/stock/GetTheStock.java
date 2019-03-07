package week2.stock;

public class GetTheStock implements Runnable {
    private String stockName;
    private StockGrabber stockGrabber;

    public GetTheStock(String stockName, StockGrabber stockGrabber) {
        this.stockName = stockName;
        this.stockGrabber = stockGrabber;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(2000);
                stockGrabber.setPrice(stockName, Math.random() * 1000);
            }
        }
        catch (Exception e) {e.printStackTrace(); }
    }
}
