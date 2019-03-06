package week2.packagefactory;

class GroningenSmallPackage extends Package {

    public GroningenSmallPackage() {
        name = "Groningen Stijl Klein Pakketje";
        size = "Klein";
        color = "Groen";

        stamps.add("Briefpost");
    }
}

class GroningenMediumPackage extends Package {

    public GroningenMediumPackage() {
        name = "Groningen Stijl Pakketje";
        size = "Middel";
        color = "Blauw";
    }
}

class GroningenLargePackage extends Package {

    public GroningenLargePackage() {
        name = "Groningen Stijl Groot Pakketje";
        size = "Groot";
        color = "Paars";

        stamps.add("This side up");
    }

    // In Groningen beschermen we grote pakketjes extra goed
    @Override
    void fill() {
        System.out.println("Verpakking opvullen met premium beschermingsmateriaal");
    }
}

class GroningenGigaPackage extends Package {

    public GroningenGigaPackage() {
        name = "Groningen Stijl Giga Pakketje";
        size = "Gigantisch";
        color = "Roze";

        stamps.add("This side up");
        stamps.add("Voorzichtig");
    }

    // In Groningen beschermen we giga pakketjes extra goed
    @Override
    void fill() {
        System.out.println("Verpakking opvullen met premium beschermingsmateriaal");
    }
}

