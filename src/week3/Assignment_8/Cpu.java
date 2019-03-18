package week3.Assignment_8;

public class Cpu {
    private String brand;
    private double speed;
    private int cores;

    public Cpu(String brand, double speed, int cores) {
        this.brand = brand;
        this.speed = speed;
        this.cores = cores;
    }

    public void executeProgram(String program){
        System.out.println("Executing " + program);
    }

    public void pause(){
        System.out.println("Pausing CPU operations");
    }

    public void resume(){
        System.out.println("Resuming CPU operations");
    }

    public void printSpecs(){
        System.out.println("CPU: " + brand + " " + speed + "GHz, " + cores + " cores");
    }
}
