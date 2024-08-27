package factory_method;

public class BuildingTile extends Tile{
    @Override
    public char getCharacter() {
        return 'B';
    }
    @Override
    public String getType() {
        return "Building";
    }

    @Override
    public void action() {

    }
}
