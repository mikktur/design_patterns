package flyweight.tile;

import flyweight.TileType;

public class WaterTile extends Tile {

    @Override
    public TileType getType() {
        return TileType.WATER;
    }
}
