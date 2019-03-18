package week3.states;

public class HasCardState implements State {
    private ATM atm;

    public HasCardState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Card already inserted");
    }

    @Override
    public void ejectCard() {
        System.out.println("Ejecting card");
        atm.setState(atm.getIdleState());
    }

    @Override
    public void enterPin() {
        // Check whether the pin is correct
        if (true) {
            System.out.println("Correct pin");
            atm.setState(atm.getHasCorrectPinState());
        } else {
            System.out.println("Incorrect pin");
        }
    }

    @Override
    public void requestAmount(int amount) {
        System.out.println("Please enter a pin first");
    }

    @Override
    public void withdraw(int amount) {
        System.out.println("Please enter a pin first");
    }
}
