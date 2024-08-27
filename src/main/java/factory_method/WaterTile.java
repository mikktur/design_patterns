package factory_method;

public class WaterTile extends Tile{
    @Override
    public char getCharacter() {
        return 'W';
    }
    @Override
    public String getType() {
        return "road";
    }

    @Override
    public void action() {

    }

}
