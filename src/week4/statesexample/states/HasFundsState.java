package week4.statesexample.states;

import week4.statesexample.Grabber;

public class HasFundsState implements State {
    Grabber grabber;

    public HasFundsState(Grabber grabber) {
        this.grabber = grabber;
    }

    @Override
    public void start() {
        System.out.println("Starting game...");
        grabber.setFunds(grabber.getFunds() - 1);
        grabber.startTimer();
        grabber.setState(grabber.getPlayingState());
    }

    @Override
    public void insert(int amount) {
        System.out.println("Adding " + amount + " extra funds!");
        grabber.setFunds(grabber.getFunds() + amount);
    }

    @Override
    public void refund() {
        System.out.println("Refunding " + grabber.getFunds() + " funds...");
        grabber.setState(grabber.getIdleState());
    }

    @Override
    public void grab() {
        System.out.println("Please start the game first...");
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
