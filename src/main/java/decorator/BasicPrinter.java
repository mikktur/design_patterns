package decorator;

//luokkka joka määrittää perusprintterin toiminnallisuuden
public class BasicPrinter implements Printer {
    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
