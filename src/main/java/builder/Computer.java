package builder;

public class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String gpu;
    private String os;

    public Computer() {

    }

    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    public String getGpu() {
        return gpu;
    }

    public String getOs() {
        return os;
    }


    public void setCpu(String s) {
        this.cpu = s;
    }

    public void setRam(String s) {
        this.ram = s;
    }

    public void setStorage(String s) {
        this.storage = s;
    }

    public void setGpu(String s) {
        this.gpu = s;
    }

    public void setOs(String s) {
        this.os = s;
    }


    public String toString() {
        return "CPU: " + cpu + "\nRAM: " + ram + "\nStorage: " + storage + "\nGPU: " + gpu + "\nOS: " + os;
    }
}
