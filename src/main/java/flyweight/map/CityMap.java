package flyweight.map;

import flyweight.tile.BuildingTile;
import flyweight.tile.ForestTile;
import flyweight.tile.RoadTile;
import flyweight.tile.Tile;
import javafx.scene.canvas.Canvas;

import java.util.Random;
//not used cause im lazy.
public class CityMap extends Map {

    private static final Random random = new Random();

    public CityMap(int width, int height, Canvas canvas) {
        super(width, height,canvas);
    }


    @Override
    protected Tile createTile() {
        switch (random.nextInt(3)) {
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
