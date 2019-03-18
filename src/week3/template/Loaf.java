package week3.template;

public abstract class Loaf {

    final void prepareLoaf() {
        makeDough();
        heatDough();
        if (customerWantsSeeds()) {
            addSeeds();
        }
        packLoaf();
    }

    abstract void makeDough();

    abstract void addSeeds();

    void heatDough() {
        System.out.println("Heating dough");
    }

    void packLoaf() {
        System.out.println("Packing loaf");
    }

    boolean customerWantsSeeds() {
        return false;
    }

}
