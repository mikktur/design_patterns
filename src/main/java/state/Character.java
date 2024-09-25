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
        System.out.println("-----------------------------------------------------------------------");
        displayStatus();
        state.displayActions();

        System.out.print("Enter action: ");
        String action = scanner.nextLine().toLowerCase();
        switch (action) {
            case "1":
                state.train();
                break;
            case "2":
                state.meditate();
                break;
            case "3":
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
    public void displayStatus() {
        System.out.println("Health: " + health + " Experience: " + experience + " Level: " + state.getLevelName());
        System.out.println("Experience needed to reach next level: " + (state.getLevelThreshold() - experience));
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
