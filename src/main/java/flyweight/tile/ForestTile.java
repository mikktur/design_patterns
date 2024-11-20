package flyweight.tile;

import flyweight.TileType;

public class ForestTile extends Tile {
    @Override
    public TileType getType() {
        return TileType.FOREST;
    }

}
