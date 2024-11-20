package flyweight.tile;

import flyweight.TileType;

public class BuildingTile extends Tile {

    @Override
    public TileType getType() {
        return TileType.BUILDING;
    }


}
