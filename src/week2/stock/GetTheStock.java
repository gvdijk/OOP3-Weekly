package week2.stock;

public class GetTheStock implements Runnable {
    private StockGrabber stockGrabber;

    public GetTheStock(StockGrabber stockGrabber) {
        this.stockGrabber = stockGrabber;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(2000);
            }
        }
        catch (Exception e) {e.printStackTrace(); }
    }
}
