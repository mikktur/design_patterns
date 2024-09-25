package decorator;

//Abstrakti decorator-luokka. Käytetään konkreettisten decoratoreiden pohjana.
public abstract class PrinterDecorator implements Printer {
    Printer printer;
    public PrinterDecorator(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String text) {
        printer.print(text);
    }

}
