package week4.statesexample.states;

import week4.statesexample.Grabber;

public class IdleState implements State {
    Grabber grabber;

    public IdleState(Grabber grabber) {
        this.grabber = grabber;
    }

    @Override
    public void start() {
        System.out.println("Please insert a coin");
    }

    @Override
    public void insert(int amount) {
        System.out.println("Adding " + amount + " funds!");
        grabber.setFunds(amount);
        grabber.setState(grabber.getHasFundsState());
    }

    @Override
    public void refund() {
        System.out.println("No funds available");
    }

    @Override
    public void grab() {
        System.out.println("Please insert a coin");
    }

    @Override
    public void release() {
        System.out.println("Cannot release now...");
    }

    @Override
    public void refill(int amount) {
        if (amount > 0) {
            System.out.println("Adding " + amount + " extra prices!");
            grabber.setPrices(grabber.getPrices() + amount);
        }
    }
}
