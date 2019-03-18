package week3.template;

public class WheatLoaf extends Loaf {

    @Override
    void makeDough() {
        System.out.println("Composing wheat dough");
    }

    @Override
    void addSeeds() {
        System.out.println("Adding sesame seeds");
    }

    @Override
    boolean customerWantsSeeds() {
        return true;
    }
}
