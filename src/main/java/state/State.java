package state;

public abstract class State {
    private final Character character;
    private boolean canMeditate = false;
    private boolean canFight = false;
    private final int levelThreshold;
    public State(Character character,int levelThreshold, boolean canMeditate,boolean canFight) {
        this.character = character;
        this.canMeditate = canMeditate;
        this.canFight = canFight;
        this.levelThreshold = levelThreshold;

    }

    public Character getCharacter() {
        return character;
    }

    /*tuntu typerältä toistaa sama koodi joka luokassa niin aattelin et ois ehkä fiksumpi kattoa booleanilla että
     voiko tietty state käyttää kyseistä metodia*/
    public void train() {
        System.out.println("You trained hard!");
        character.increaseExperience(10);
    }

    public void meditate() {
        if (canMeditate) {
            System.out.println("Meditating made you calmer, you gained 5 health points.");
            character.increaseHealth(5);
        } else {
            System.out.println("You cannot meditate at this level.");
        }
    }

    public void fight() {
        if (canFight) {
            if (character.getHealth() < 20) {
                System.out.println("You don't have enough health to fight.");
                return;
            }
            System.out.println("You fought a monster and lost 20 health points.");
            character.increaseExperience(20);
            character.decreaseHealth(20);
        } else {
            System.out.println("You cannot fight at this level.");
        }
    }

    //sais varmaan kaikki jotenkin samaan metodiin mutta en viittinyt käyttää enempää aikaa
    public void displayActions() {
        System.out.println("Available actions: (1)Train");
    }
    public int getLevelThreshold() {
        return levelThreshold;
    }
    //jokaisessa statessa on eri metodi joka vaihtaa staten.
    abstract void levelUp();

    abstract String getLevelName();


}
