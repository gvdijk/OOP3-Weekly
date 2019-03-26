package week4.statesexample.states;

import week4.statesexample.Grabber;

import java.util.Random;

public class GrabbingState implements State {
    Grabber grabber;

    public GrabbingState(Grabber grabber) {
        this.grabber = grabber;
    }

    @Override
    public void start() {
        System.out.println("Please wait for the hook to return...");
    }

    @Override
    public void insert(int amount) {
        System.out.println("Please wait for the hook to return...");
    }

    @Override
    public void refund() {
        if (grabber.getFunds() > 0) {
            System.out.println("Refunding " + grabber.getFunds() + " funds...");
            grabber.setFunds(0);
        } else {
            System.out.println("No funds available...");
        }
    }

    @Override
    public void grab() {
        System.out.println("Please wait for the hook to return...");
    }

    @Override
    public void release() {
        Random random = new Random();
        if (random.nextInt(3) == 1) {
            System.out.println("You win!");
            grabber.setPrices(grabber.getPrices() - 1);
            if (grabber.getPrices() == 0) {
                refund();
                grabber.setState(grabber.getOutOfServiceState());
                return;
            }
        } else {
            System.out.println("Too bad");
        }
        if (grabber.getFunds() > 0) {
            System.out.println(grabber.getFunds() + " funds left");
            grabber.setState(grabber.getHasFundsState());
        } else {
            System.out.println("Out of funds...");
            grabber.setState(grabber.getIdleState());
        }
    }

    @Override
    public void refill(int amount) {
        System.out.println("Cannot refill while grabbing");
    }
}
