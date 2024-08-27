package factory_method;
import java.util.Random;
public class Game {

    public static void main(String[] args) {
        Random random = new Random();
        Map map = createMap(random.nextInt(1,2), 10, 10);
        map.display();
    }

    public static Map createMap(int type, int width, int height) {
        switch (type) {
            case 1:
                return new CityMap(width, height);
            case 2:
                return new WildernessMap(width, height);
            default:
                throw new IllegalArgumentException("I dunno what map you want");
        }
    }
}