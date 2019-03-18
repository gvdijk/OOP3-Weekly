package week3.Assignment_8;

public class Ram {
    private int size;
    private String brand;
    private String speed;

    public Ram(int size, String brand, String speed) {
        this.size = size;
        this.brand = brand;
        this.speed = speed;
    }

    public void loadIntoMemory(String program){
        System.out.println("Loading " + program + " intro RAM");
    }

    public void unloadFromMemory(String program){
        System.out.println("Unloading " + program + " from memory");
    }

    public void printSpecs(){
        System.out.println("RAM: " + brand + " " + size + "MB, " + speed);
    }
}
