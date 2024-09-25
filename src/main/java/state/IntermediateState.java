package state;

public class IntermediateState extends State {


    public IntermediateState(Character character) {
        super(character,60,true,false);
    }


    @Override
    public void levelUp() {
        super.getCharacter().setState(new ExpertState(super.getCharacter()));
        System.out.println("Congratulations! You have reached the Expert level! Fight action is now available.");
    }


    @Override
    public String getLevelName() {
        return "Intermediate";
    }



}
