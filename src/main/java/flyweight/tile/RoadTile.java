package flyweight.tile;

import flyweight.TileType;

public class RoadTile extends Tile {

    @Override
    public TileType getType() {
        return TileType.ROAD;
    }


}
