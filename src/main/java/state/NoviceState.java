package state;

public class NoviceState extends State {

    public NoviceState(Character character) {
        super(character,NOVICE_THRESHOLD);

    }


    @Override
    public void action() {
        this.getCharacter().displayStatus();
        switch (this.getCharacter().readUserChoice()) {
            case TRAIN:
                this.getCharacter().train();
                break;
            case FIGHT:
                System.out.println("You are not ready to fight yet. Train first.");
                break;
            case MEDITATE:
                System.out.println("You are not ready to meditate yet. Train first.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        levelUp();
    }
    @Override
    public void levelUp() {
        if (getCharacter().getExperience() >= getLevelThreshold()) {
            System.out.println("Leveling up to Intermediate!");
            getCharacter().setState(new IntermediateState(getCharacter()));
        }
    }

    @Override
    public String getLevelName() {
        return "Novice";
    }

}




