package decorator;

public class EncryptedPrinter extends PrinterDecorator {


    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String text) {
        String encryptedText = encrypt(text);
        // passaa encryptedTextin eteenpäin basicPrinterille
        super.print(encryptedText);
    }

    // shiftaa jokaista characteria +1 (a -> b, b -> c, c -> d, ...)
    private String encrypt(String text) {
        return text.chars()
                .mapToObj(c -> (char) (c + 1))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }


}
