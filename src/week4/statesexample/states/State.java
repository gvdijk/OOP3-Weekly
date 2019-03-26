package week4.statesexample.states;

public interface State {
    void start();
    void insert(int amount);
    void refund();
    void release();
    void grab();
    void refill(int amount);
}
