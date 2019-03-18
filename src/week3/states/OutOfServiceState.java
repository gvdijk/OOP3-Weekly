package week3.states;

public class OutOfServiceState implements State {
    private ATM atm;

    public OutOfServiceState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Machine out of service");
    }

    @Override
    public void ejectCard() {
        System.out.println("Machine out of service");
    }

    @Override
    public void enterPin() {
        System.out.println("Machine out of service");
    }

    @Override
    public void requestAmount(int amount) {
        System.out.println("Machine out of service");
    }

    @Override
    public void withdraw(int amount) {
        System.out.println("Machine out of service");
    }
}
