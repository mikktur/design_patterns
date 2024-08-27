package factory_method;

public class SwampTile extends Tile{
    @Override
    public char getCharacter() {
        return 'S';
    }
    @Override
    public String getType() {
        return "Swamp";
    }

    @Override
    public void action() {

    }
}
