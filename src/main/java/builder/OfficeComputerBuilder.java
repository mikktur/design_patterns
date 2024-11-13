package builder;

public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        computer = new Computer();
    }
    @Override
    public void buildCpu() {
        computer.setCpu("Amd Ryzen 5 5600G");
    }
    @Override
    public void buildRam() {
        computer.setRam("8GB");
    }
    @Override
    public void buildStorage() {
        computer.setStorage("512 SSD");
    }
    @Override
    public void buildGpu() {
        computer.setGpu("Intel UHD Graphics 630");
    }
    @Override
    public void buildOs() {
        computer.setOs("Windows 11 Home");
    }
    @Override
    public Computer getComputer() {
        return computer;
    }
}
