package builder;

public class Main {
    public static void main(String[] args) {
        ComputerBuilder computerBuilder = new GamingComputerBuilder();
        ComputerDirector computerDirector = new ComputerDirector(computerBuilder);
        computerDirector.constructComputer();
        Computer computer = computerDirector.getComputer();
        System.out.println("Gaming Computer:");
        System.out.println(computer);
        System.out.println();
        computerBuilder = new OfficeComputerBuilder();
        computerDirector = new ComputerDirector(computerBuilder);
        computerDirector.constructComputer();
        computer = computerDirector.getComputer();

        System.out.println("Office Computer:");
        System.out.println(computer);

    }
}
