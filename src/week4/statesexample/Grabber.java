package week4.statesexample;

import week4.statesexample.states.*;

import java.util.Timer;
import java.util.TimerTask;

public class Grabber {

    private IdleState idleState;
    private OutOfServiceState outOfServiceState;
    private HasFundsState hasFundsState;
    private GrabbingState grabbingState;
    private PlayingState playingState;
    private State state;

    private int prices = 10;
    private int funds = 0;

    public Grabber() {
        idleState = new IdleState(this);
        outOfServiceState = new OutOfServiceState(this);
        hasFundsState = new HasFundsState(this);
        grabbingState = new GrabbingState(this);
        playingState = new PlayingState(this);

        this.state = idleState;
    }


    public void startIsPressed() {
        state.start();
    }

    public void coinInserted(int amount) {
        state.insert(amount);
    }

    public void refundIsPressed() {
        state.refund();
    }

    public void grabIsPressed() {
        state.grab();
    }

    public void refillGrabber(int amount) {
        state.refill(amount);
    }


    public IdleState getIdleState() {
        return idleState;
    }

    public OutOfServiceState getOutOfServiceState() {
        return outOfServiceState;
    }

    public HasFundsState getHasFundsState() {
        return hasFundsState;
    }

    public GrabbingState getGrabbingState() {
        return grabbingState;
    }

    public PlayingState getPlayingState() {
        return playingState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void startTimer() {
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        state.grab();
                    }
                },10000);
    }

    public void release() {
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        state.release();
                    }
                },5000);
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }

    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }
}
