package flyweight;

import java.util.EnumMap;
import java.util.Map;
public class TileGraphicsFactory {
    private static final Map<TileType, TileImage> images = new EnumMap<>(TileType.class);

    public static TileImage getTileImage(TileType type) {
        TileImage image = images.get(type);
        if (image == null) {
            switch (type) {
                case ROCK:
                    System.out.println("Creating a new rock tile image"); //souts to test if the flyweight pattern is working
                    image = new TileImage("rock.png");
                    break;
                case WATER:
                    System.out.println("Creating a new water tile image");
                    image = new TileImage("water.png");
                    break;
                case GRASS:
                    System.out.println("Creating a new grass tile image");
                    image = new TileImage("grass.png");
                    break;
            }
            images.put(type, image);
        }
        return image;
    }
}
