package week3.Assignment_8;

public class Gpu {
    private String brand;
    private int clockSpeed;

    public Gpu(String brand, int clockSpeed) {
        this.brand = brand;
        this.clockSpeed = clockSpeed;
    }

    public void displayProgram(String program){
        System.out.println("Displaying " + program + " on screen...");
    }

    public void printSpecs(){
        System.out.println("GPU: " + brand + " " + clockSpeed + "MHz");
    }
}
