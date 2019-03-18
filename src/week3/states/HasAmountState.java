package week3.states;

public class HasAmountState implements State {
    private ATM atm;

    public HasAmountState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Card already inserted");
    }

    @Override
    public void ejectCard() {
        System.out.println("Already withdrawing, please wait...");
    }

    @Override
    public void enterPin() {
        System.out.println("Pin already confirmed");
    }

    @Override
    public void requestAmount(int amount) {
        System.out.println("Amount already confirmed");
    }

    @Override
    public void withdraw(int amount) {
        System.out.println("Withdrawing money");
        atm.subtractAmount(amount);
        System.out.println("Ejecting Card");
        if (atm.getAmount() > 0) {
            atm.setState(atm.getIdleState());
        } else {
            atm.setState(atm.getOutOfServiceState());
        }
    }
}
