package week2.stock;

public interface ViewSubject {

    public void register(View v);
    public void unregister(View v);
    public void notifyViews();
}
