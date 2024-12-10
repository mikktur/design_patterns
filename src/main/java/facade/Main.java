package facade;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Facade facade = new Facade();
        try{
            System.out.println(facade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value"));
            System.out.println(facade.getAttributeValueFromJson("https://api.fxratesapi.com/latest", "EUR"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
