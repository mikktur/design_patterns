package flyweight.map;

import flyweight.TileGraphicsFactory;
import flyweight.TileImage;
import flyweight.tile.Tile;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public abstract class Map {
    protected Tile[][] mapGrid;
    protected int width;
    protected int height;
    protected Canvas canvas;
    protected static final int TILE_SIZE = 16;

    public Map(int width, int height, Canvas canvas) {
        this.width = width;
        this.height = height;
        this.canvas = canvas;
        this.mapGrid = new Tile[width][height];
        generateMap();
        render();
    }

    protected void generateMap() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                mapGrid[x][y] = createTile();
            }
        }
    }

    protected abstract Tile createTile();

    public void render() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Tile tile = mapGrid[x][y];
                if (tile != null) {
                    TileImage tileImage = TileGraphicsFactory.getTileImage(tile.getType());
                    gc.drawImage(tileImage.getImage(), x * TILE_SIZE, y * TILE_SIZE);
                }
            }
        }
    }
}