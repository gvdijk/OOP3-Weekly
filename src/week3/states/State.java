package week3.states;

public interface State {

    void insertCard();
    void ejectCard();
    void enterPin();
    void requestAmount(int amount);
    void withdraw(int amount);
}
