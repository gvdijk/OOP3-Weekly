package week4.statesexample.states;

import week4.statesexample.Grabber;

public class OutOfServiceState implements State {
    Grabber grabber;

    public OutOfServiceState(Grabber grabber) {
        this.grabber = grabber;
    }

    @Override
    public void start() {
        System.out.println("Grabber is out of service");
    }

    @Override
    public void insert(int amount) {
        System.out.println("Grabber is out of service");
    }

    @Override
    public void refund() {
        System.out.println("Grabber is out of service");
    }

    @Override
    public void release() {
        System.out.println("Grabber is out of service");
    }

    @Override
    public void grab() {
        System.out.println("Grabber is out of service");
    }

    @Override
    public void refill(int amount) {
        if (amount > 0) {
            System.out.println("Adding " + amount + " prices");
            grabber.setPrices(amount);
            grabber.setState(grabber.getIdleState());
        }
    }
}
