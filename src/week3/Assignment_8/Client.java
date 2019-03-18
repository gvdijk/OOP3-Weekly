package week3.Assignment_8;

public class Client {

    public static void main(String[] args){
        //Install all pc components
        Ram ram = new Ram(16384, "Crucial SODIMM", "DDR4");
        Cpu cpu = new Cpu("Intel Core i7 8700 Coffee Lake", 3.7, 12);
        Gpu gpu = new Gpu("MSI GeForce GTX 1080", 1607);
        Hdd hdd = new Hdd("Seagate Ironwolf", 4000);

        //Create a computer facade
        ComputerFacade computer = new ComputerFacade(hdd, ram, cpu, gpu);

        //Use the computer facade to play Tetris
        computer.turnPcOn();
        computer.printSpecs();
        computer.playTetris();
        computer.turnPcOff();
    }
}
