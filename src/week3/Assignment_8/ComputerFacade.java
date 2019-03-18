package week3.Assignment_8;

public class ComputerFacade {
    private Hdd hdd;
    private Ram ram;
    private Cpu cpu;
    private Gpu gpu;

    public ComputerFacade(Hdd hdd, Ram ram, Cpu cpu, Gpu gpu) {
        this.hdd = hdd;
        this.ram = ram;
        this.cpu = cpu;
        this.gpu = gpu;
    }

    public void printSpecs(){
        System.out.println("---------Computer Specs---------");
        cpu.printSpecs();
        gpu.printSpecs();
        ram.printSpecs();
        hdd.printSpecs();
        System.out.println("\n");
    }

    public void turnPcOn(){
        System.out.println("---------Booting Pc---------");
        String program = "Operating System";
        cpu.resume();
        hdd.read(program);
        ram.loadIntoMemory(program);
        cpu.executeProgram(program);
        gpu.displayProgram(program);
        System.out.println("\n");
    }

    public void turnPcOff(){
        System.out.println("---------Turning off Pc---------");
        cpu.pause();
        hdd.write("Operating System");
        ram.unloadFromMemory("Operating System");
    }

    public void playTetris(){
        System.out.println("---------Playing Tetris---------");
        String program = "Tetris";
        hdd.read(program);
        ram.loadIntoMemory(program);
        cpu.executeProgram(program);
        gpu.displayProgram(program);
        System.out.println("\n");
    }
}
