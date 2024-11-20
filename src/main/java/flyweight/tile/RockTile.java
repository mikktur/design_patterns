package flyweight.tile;

import flyweight.TileType;

public class RockTile extends Tile {
    @Override
    public TileType getType() {
        return TileType.ROCK;
    }
}
