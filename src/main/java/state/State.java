package state;

public abstract class State {
    private final Character character;

    //eri statejen level thresholdit
    protected static final int NOVICE_THRESHOLD = 20;
    protected static final int INTERMEDIATE_THRESHOLD = 60;
    protected static final int EXPERT_THRESHOLD = 100;

    private final Integer levelThreshold;
    public State(Character character,int levelThreshold) {
        this.character = character;
        this.levelThreshold = levelThreshold;
    }
    //constructori master statelle koska sillä ei ole thresholdia.
    public State(Character character) {
        this.character = character;
        this.levelThreshold = null;
    }
    public Character getCharacter() {
        return character;

    }
    public int getLevelThreshold() {
        return levelThreshold;
    }
    //käytetään statuksen printtaamisessa.
    public abstract String getLevelName();

    public abstract void action();
    //tarkistetaan onko pelaaja saavuttanut seuraavan tason ja vaihdetaan statea sen mukaan.
    public abstract void levelUp();
}
