package state;

public class ExpertState extends State {
    public ExpertState(Character character) {
        super(character,100,true,true);
    }



    @Override
    public void levelUp() {
        super.getCharacter().setState(new MasterState(super.getCharacter()));
        System.out.println("You have reached the Master Level! Theres no more levels to achieve.");
    }
    @Override
    public String getLevelName() {
        return "Expert";
    }

}

