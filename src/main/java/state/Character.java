package state;

import java.lang.invoke.SwitchPoint;
import java.util.Objects;
import java.util.Scanner;

public class Character {
    private String name;
    private int health;
    private int experience;
    private State state;
    private final Scanner scanner = new Scanner(System.in);
    private boolean win = false;

    public Character(String name) {
        this.name = name;
        this.health = 100;
        this.experience = 0;
        this.state = new NoviceState(this);
    }

    public void start() {
        while (!win) {
            operate();
        }
        System.out.println("Congratulations! You have finished the game!");
    }

    public void increaseExperience(int experience) {
        this.experience += experience;
        System.out.println("You gained " + experience + " experience points");
        while (this.experience >= state.getLevelThreshold()) {
            state.levelUp();
        }
    }

    public void decreaseHealth(int health) {
        this.health -= health;
    }


    public void operate() {

        displayStatus();

        state.displayActions();

        System.out.print("Enter action: ");
        String actionInput = scanner.nextLine().toLowerCase();
        Action action = Action.fromCode(actionInput);

        switch (action) {
            case TRAIN:
                state.train();
                break;
            case MEDITATE:
                state.meditate();
                break;
            case FIGHT:
                state.fight();
                break;
            default:
                System.out.println("Invalid action. Try again.");
        }
        System.out.println("Press enter to continue.");
        checkWin();
        scanner.nextLine();


    }

    public void increaseHealth(int health) {
        this.health += health;
    }

    public int getHealth() {
        return health;
    }

    public int getExperience() {
        return experience;
    }

    public State getState() {
        return state;
    }
    //pyysin AIta tekeen borderin statukselle :D
    public void displayStatus() {
        String nameLine = "Name: " + name;
        String healthLine = "Health: " + health;
        String experienceLine = "Experience: " + experience;
        String levelLine = "Level: " + state.getLevelName();
        String experienceNeeded = "Experience needed to reach next level: " + (state.getLevelThreshold() - experience);

        int maxLength = Math.max(nameLine.length(), Math.max(healthLine.length(),
                Math.max(experienceLine.length(), Math.max(levelLine.length(), experienceNeeded.length()))));

        String border = "+" + "-".repeat(maxLength + 2) + "+";


        System.out.println(border);
        System.out.println("| " + nameLine + " ".repeat(maxLength - nameLine.length()) + " |");
        System.out.println("| " + healthLine + " ".repeat(maxLength - healthLine.length()) + " |");
        System.out.println("| " + experienceLine + " ".repeat(maxLength - experienceLine.length()) + " |");
        System.out.println("| " + levelLine + " ".repeat(maxLength - levelLine.length()) + " |");
        System.out.println("| " + experienceNeeded + " ".repeat(maxLength - experienceNeeded.length()) + " |");
        System.out.println(border);
    }

    public void setState(State state) {
        this.state = state;
    }

    public void checkWin() {
        if (state.getLevelName().equals("Master")) {
            win = true;
        }
    }

}
