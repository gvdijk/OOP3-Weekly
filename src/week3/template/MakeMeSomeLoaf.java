package week3.template;

public class MakeMeSomeLoaf {

    public static void main (String[] args) {
        Loaf loaf1 = new WheatLoaf();
        Loaf loaf2 = new WholeGrainLoaf();

        loaf1.prepareLoaf();
        loaf2.prepareLoaf();
    }
}
