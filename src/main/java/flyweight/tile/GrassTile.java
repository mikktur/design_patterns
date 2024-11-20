package flyweight.tile;

import flyweight.TileType;

public class GrassTile extends Tile {

    @Override
    public TileType getType() {
        return TileType.GRASS;
    }
}
