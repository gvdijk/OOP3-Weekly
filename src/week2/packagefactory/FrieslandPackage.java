package week2.packagefactory;

class FrieslandSmallPackage extends Package {

    public FrieslandSmallPackage() {
        name = "Friesland Stijl Klein Pakketje";
        size = "Klein";
        color = "Geel";
    }

    // We verspillen geen opvulling aan kleine pakketten in Friesland
    @Override
    void fill() {}
}

class FrieslandMediumPackage extends Package {

    public FrieslandMediumPackage() {
        size = "Middel";
        name = "Friesland Stijl Pakketje";
        color = "Oranje";
    }
}

class FrieslandLargePackage extends Package {

    public FrieslandLargePackage() {
        name = "Friesland Stijl Groot Pakketje";
        size = "Groot";
        color = "Rood";

        stamps.add("This side up");
    }
}
