package week3.Assignment_8;

public class Hdd {
    private String brand;
    private int size;

    public Hdd(String brand, int size) {
        this.brand = brand;
        this.size = size;
    }

    public void read(String program){
        System.out.println("Reading " + program + " data from harddrive...");
    }

    public void write(String program){
        System.out.println("Writing " + program + " changes to harddrive");
    }

    public void printSpecs(){
        System.out.println("HDD: " + brand + " " + size + "GB");
    }
}
