package state;

public class NoviceState extends State {

    public NoviceState(Character character) {
        super(character,20,false,false);
    }


    @Override
    public String getLevelName() {
        return "Novice";
    }

    @Override
    public void levelUp() {
        super.getCharacter().setState(new IntermediateState(super.getCharacter()));
        System.out.println("Congratulations! You have reached the Intermediate level! Meditate action is now available.");
    }

}
