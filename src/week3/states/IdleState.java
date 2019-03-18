package week3.states;

public class IdleState implements State {
    private ATM atm;

    public IdleState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("Inserting card...");
        atm.setState(atm.getHasCardState());
    }

    @Override
    public void ejectCard() {
        System.out.println("No card present to eject");
    }

    @Override
    public void enterPin() {
        System.out.println("Please enter a card first");
    }

    @Override
    public void requestAmount(int amount) {
        System.out.println("Please enter a card first");
    }

    @Override
    public void withdraw(int amount) {
        System.out.println("Please enter a card first");
    }
}
