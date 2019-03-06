package week2.packagefactory;

import java.util.ArrayList;

public abstract class Package {
    String name;
    String size;
    String color;
    ArrayList<String> stamps = new ArrayList<>();

    void prepare() {
        System.out.println("Lege verpakking halen");
        for (String s : stamps) {
            System.out.println("Stempel toegevoegd: " + s);
        }
    }

    void pack() {
        System.out.println("Product in de verpakking plaatsen");
    }

    void fill() {
        System.out.println("Verpakking opvullen met beschermend materiaal");
    }

    void seal() {
        System.out.println("Verpakking sluiten");
    }

    public String getName() {
        return name;
    }
}
