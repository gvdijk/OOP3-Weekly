package week4.statesexample.states;

import week4.statesexample.Grabber;

public class PlayingState implements State {
    Grabber grabber;

    public PlayingState(Grabber grabber) {
        this.grabber = grabber;
    }

    @Override
    public void start() {
        System.out.println("Already playing...");
    }

    @Override
    public void insert(int amount) {
        System.out.println("Adding " + amount + " extra funds!");
        grabber.setFunds(grabber.getFunds() + amount);
    }

    @Override
    public void refund() {
        System.out.println("Grabber is out of service");
    }

    @Override
    public void grab() {
        System.out.println("Grabbing...");
        grabber.release();
        grabber.setState(grabber.getGrabbingState());
    }

    @Override
    public void release() {
        System.out.println("Cannot release now...");
    }

    @Override
    public void refill(int amount) {
        System.out.println("Cannot refill while playing...");
    }
}
