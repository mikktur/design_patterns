package factory_method;

public class RoadTile extends Tile{
    @Override
    public char getCharacter() {
        return 'R';
    }
    @Override
    public String getType() {
        return "Road";
    }

    @Override
    public void action() {

    }
}
