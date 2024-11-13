package builder;

import java.util.Scanner;

public class ComputerDirector {

    private ComputerBuilder computerBuilder;

    public ComputerDirector(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public void constructComputer() {

        computerBuilder.buildCpu();
        computerBuilder.buildRam();
        computerBuilder.buildStorage();
        computerBuilder.buildGpu();
        computerBuilder.buildOs();
    }

    public Computer getComputer() {
        return computerBuilder.getComputer();
    }
}
