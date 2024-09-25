package state;

public class ExpertState extends State {
    public ExpertState(Character character) {
        super(character,EXPERT_THRESHOLD);

    }


    @Override
    public void action() {

        switch (this.getCharacter().readUserChoice()) {
            case TRAIN:
                this.getCharacter().train();
                break;
            case FIGHT:
                this.getCharacter().fight();
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
            System.out.println("Leveling up to Master!");
            getCharacter().setState(new MasterState(getCharacter()));
            this.getCharacter().setWin(true);
        }
    }

    @Override
    public String getLevelName() {
        return "Expert";
    }
}


