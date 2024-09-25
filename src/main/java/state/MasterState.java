package state;

public class MasterState extends State {

    public MasterState(Character character) {
        super(character,99999,true,true);

    }

    @Override
    public String getLevelName() {
        return "Master";
    }

    @Override
    public void levelUp() {
        //never used
    }

}
