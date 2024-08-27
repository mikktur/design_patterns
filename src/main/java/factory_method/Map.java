package factory_method;

public abstract class Map {
    protected Tile[][] mapGrid;
    protected int width;
    protected int height;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.mapGrid = new Tile[width][height];
        generateMap();
    }

    protected abstract void generateMap();

    protected abstract Tile createTile();

    public void display() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(mapGrid[x][y].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}