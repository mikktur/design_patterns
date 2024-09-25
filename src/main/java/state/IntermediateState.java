package state;

public class IntermediateState extends State {


    public IntermediateState(Character character) {
        super(character, INTERMEDIATE_THRESHOLD);

    }


    @Override
    public String getLevelName() {
        return "Intermediate";
    }

    @Override
    public void action() {
        switch (this.getCharacter().readUserChoice()) {
            case TRAIN:
                this.getCharacter().train();
                break;
            case FIGHT:
                System.out.println("Only experts can fight!.");
                break;
            case MEDITATE:
                this.getCharacter().meditate();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        levelUp();
    }

    @Override
    public void levelUp() {
        if (getCharacter().getExperience() >= getLevelThreshold()) {
            System.out.println("Leveling up to Expert, You can now Fight!");
            getCharacter().setState(new ExpertState(getCharacter()));
        }
    }
}



