package week3.states;

public class ATM {
    private State idleState;
    private State hasCardState;
    private State hasCorrectPinState;
    private State hasAmountState;
    private State outOfServiceState;

    private State state;
    private int amount;

    public ATM(int amount) {
        idleState = new IdleState(this);
        hasCardState = new HasCardState(this);
        hasCorrectPinState = new HasCorrectPinState(this);
        hasAmountState = new HasAmountState(this);
        outOfServiceState = new OutOfServiceState(this);

        this.amount = amount;
        if (amount > 0) {
            state = idleState;
        } else {
            state = outOfServiceState;
        }

    }

    public void insertCard() {
        state.insertCard();
    }

    public void ejectCard() {
        state.ejectCard();
    }

    public void enterPin() {
        state.enterPin();
    }

    public void requestAmount(int amount) {
        state.requestAmount(amount);
        state.withdraw(amount);
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getIdleState() {
        return idleState;
    }

    public State getHasCardState() {
        return hasCardState;
    }

    public State getHasCorrectPinState() {
        return hasCorrectPinState;
    }

    public State getHasAmountState() {
        return hasAmountState;
    }

    public State getOutOfServiceState() {
        return outOfServiceState;
    }

    public int getAmount() {
        return amount;
    }

    public void subtractAmount(int amount) {
        this.amount -= amount;
    }
}
