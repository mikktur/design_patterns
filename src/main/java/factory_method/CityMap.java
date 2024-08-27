package factory_method;

import java.util.Random;

public class CityMap extends Map {

    private static final Random random = new Random();

    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected void generateMap() {
        System.out.println("City map");
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                mapGrid[x][y] = createTile();
            }
        }
    }

    @Override
    protected Tile createTile() {
        switch (random.nextInt(3)) { // 0, 1, 2
            case 0:
                return new RoadTile();
            case 1:
                return new ForestTile();
            case 2:
                return new BuildingTile();
            default:
                throw new IllegalStateException("Unexpected value");
        }
    }
}
