package builder;

public interface ComputerBuilder {
    void buildCpu();
    void buildRam();
    void buildStorage();
    void buildGpu();
    void buildOs();
    Computer getComputer();
}
