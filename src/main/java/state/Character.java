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
            displayStatus();
            state.action();
            waitForEnter();
        }
        //last actions before finishing the game could be removed.....
        displayStatus();
        state.action();
        System.out.println("Congratulations! You have finished the game!");
    }

    public void increaseExperience(int experience) {
        this.experience += experience;
        System.out.println("You gained " + experience + " experience points");
    }
    public void checkWin() {
        if (experience >= 200) {
            win = true;
        }
    }
    public Action readUserChoice() {
        System.out.println("Choose an action:");
        System.out.println("1. Train");
        System.out.println("2. Meditate");
        System.out.println("3. Fight");
        String userInput = scanner.nextLine();
        return Action.fromCode(userInput);
    }

    public void decreaseHealth(int health) {
        this.health -= health;
    }


    public void increaseHealth(int health) {
        this.health += health;
    }


    public int getExperience() {
        return experience;
    }


    //pyysin AIta tekeen borderin statukselle :D
    public void displayStatus() {
        String nameLine = "Name: " + name;
        String healthLine = "Health: " + health;
        String experienceLine = "Experience: " + experience;
        String levelLine = "Level: " + state.getLevelName();
        String experienceNeeded = win ? "Masters dont need experience":"Experience needed to reach next level: " + (state.getLevelThreshold() - experience);

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

    public void train() {
        System.out.println("You trained hard!");
        increaseExperience(10);
    }
    public void setWin(boolean win) {
        this.win = win;
    }
    public void meditate() {

        System.out.println("Meditating made you calmer, you gained 5 health points.");
        increaseHealth(5);


    }

    public void fight() {
        if (health < 20) {
            System.out.println("You don't have enough health to fight.");
            return;
        }
        System.out.println("You fought a monster and lost 20 health points.");
        increaseExperience(20);
        decreaseHealth(20);
    }
    public void levelUp() {
        state.levelUp();
    }

    public void waitForEnter() {
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }
}


