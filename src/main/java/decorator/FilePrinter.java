package decorator;

import java.io.FileWriter;

public class FilePrinter extends PrinterDecorator {

    public FilePrinter(Printer printer) {
        super(printer);
    }


    @Override
    public void print(String text) {
        System.out.println("Printing to file text: " + text);
        try (FileWriter writer = new FileWriter("output.txt", true)) {
            writer.write(text + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
