package state;

public class MasterState extends State {

    public MasterState(Character character) {
        super(character);

    }

    @Override
    public String getLevelName() {
        return "Master";
    }

    @Override
    public void action() {
        System.out.println("You are a master. The game is over. There is nothing else to learn.");
    }

    @Override
    public void levelUp() {
        //never used
    }

}
