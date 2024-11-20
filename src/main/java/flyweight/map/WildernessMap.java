package flyweight.map;

import flyweight.tile.*;
import javafx.scene.canvas.Canvas;

import java.util.Random;

public class WildernessMap extends Map {

    private static final Random random = new Random();

    public WildernessMap(int width, int height, Canvas canvas) {
        super(width, height, canvas);
    }


    @Override
    protected Tile createTile() {
        int randomValue = random.nextInt(10);

        if (randomValue == 0) {

            return new RockTile();
        }
        if (randomValue >7) {

            return new WaterTile();
        }
        else {

            return new GrassTile();
        }
    }
}