package week3.template;

public class WholeGrainLoaf extends Loaf {

    @Override
    void makeDough() {
        System.out.println("Composing wheat dough");
    }

    @Override
    void addSeeds() {
        System.out.println("Adding sunflower seeds");
    }

    @Override
    boolean customerWantsSeeds() {
        return false;
    }
}
