package week3.states;

public class HasCorrectPinState implements State {
    private ATM atm;

    public HasCorrectPinState(ATM atm) {
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
        System.out.println("Pin already confirmed");
    }

    @Override
    public void requestAmount(int amount) {
        // Check whether the amount is available
        if (amount > atm.getAmount()) {
            System.out.println("Not sufficient funds available, please decrease the amount to a maximum of " + atm.getAmount());
        } else {
            System.out.println("Funds are available");
            atm.setState(atm.getHasAmountState());
        }
    }

    @Override
    public void withdraw(int amount) {
        System.out.println("No amount withdrawn");
    }
}
