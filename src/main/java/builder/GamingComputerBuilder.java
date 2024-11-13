package builder;

import java.util.Scanner;

public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;
    private Scanner scanner;
    public GamingComputerBuilder() {
        computer = new Computer();
        scanner = new Scanner(System.in);
    }

    @Override
    public void buildCpu() {
        System.out.println("Select Processor:");
        System.out.println("1. Amd Ryzen 5600x");
        System.out.println("2. Amd Ryzen 5800x3D");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            computer.setCpu("Amd Ryzen 5600x");
        } else if (choice == 2) {
            computer.setCpu("Amd Ryzen 5800x3D");
        } else {
            computer.setCpu("Amd Ryzen 5600");
        }
    }

    @Override
    public void buildRam() {
        System.out.println("Select RAM size:");
        System.out.println("1. 16 GB");
        System.out.println("2. 32 GB");
        System.out.println("3. 64 GB");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                computer.setRam("16 GB");
                break;
            case 2:
                computer.setRam("32 GB");
                break;
            case 3:
                computer.setRam("64 GB");
                break;
            default:
                computer.setRam("32 GB");
                break;
        }
    }

    @Override
    public void buildStorage() {
        System.out.println("Select Hard Drive:");
        System.out.println("1. 1 TB NVMe SSD");
        System.out.println("2. 2 TB NVMe SSD");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            computer.setStorage("1 TB NVMe SSD");
        } else if (choice == 2) {
            computer.setStorage("2 TB NVMe SSD");
        } else {
            computer.setStorage("1 TB NVMe SSD");
        }
    }

    @Override
    public void buildGpu() {
        System.out.println("Select Graphics Card:");
        System.out.println("1. NVIDIA GeForce RTX 3080");
        System.out.println("2. NVIDIA GeForce RTX 3090");
        System.out.println("3. AMD Radeon RX 6800 XT");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                computer.setGpu("NVIDIA GeForce RTX 3080");
                break;
            case 2:
                computer.setGpu("NVIDIA GeForce RTX 3090");
                break;
            case 3:
                computer.setGpu("AMD Radeon RX 6800 XT");
                break;
            default:
                computer.setGpu("NVIDIA GeForce RTX 3080");
                break;
        }
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

