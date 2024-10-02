package template.Jrpg;

import template.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JrpgGame extends Game {
    private List<Character> players;
    private List<Character> enemies;
    private Random random = new Random();

    @Override
    public void initializeGame(int numberOfPlayers) {
        players = new ArrayList<>();
        enemies = new ArrayList<>();

        //demoa varten luodaan pelaajia ja vihollisia.
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Character("Player" + (i + 1), 100));
        }


        int numberOfEnemies = random.nextInt(3) + 2; // Random number of enemies between 2 and 4
        for (int i = 0; i < numberOfEnemies; i++) {
            enemies.add(new Character("Enemy" + (i + 1), 80));
        }

        System.out.println("Combat started" + numberOfPlayers + " players and " + numberOfEnemies + " enemies.");
    }
    //peli loppuu kun joko kaikki pelaajat tai kaikki viholliset ovat kuolleet.
    @Override
    public boolean endOfGame() {
        boolean playersAlive = players.stream().anyMatch(p -> p.getHp() > 0);
        boolean enemiesAlive = enemies.stream().anyMatch(e -> e.getHp() > 0);
        return !(playersAlive && enemiesAlive);
    }

    @Override
    public void playSingleTurn(int playerIndex) {
        Character player = players.get(playerIndex);

        //skippaa kuolleen hahmon vuoron.
        if (player.getHp() <= 0) {

            System.out.println(player.getName() + " is defeated and cannot take a turn.");
            return;
        }


        System.out.println(player.getName() + "'s turn.");

        //tällä hetkellä pelaaja hyökkää satunnaista vihollista vastaan, pitäisi muuttaa, että pelaaja voi valita kohteen.
        List<Character> aliveEnemies = enemies.stream().filter(e -> e.getHp() > 0).toList();
        if (!aliveEnemies.isEmpty()) {
            Character target = aliveEnemies.get(random.nextInt(aliveEnemies.size()));
            int damage = random.nextInt(20) + 5; // Random damage between 5 and 25
            target.takeDamage(damage);
            System.out.println(player.getName() + " attacks " + target.getName() + " for " + damage + " damage.");
        }

        // simuloi vihollisen vuoroa
        if (!endOfGame()) {
            List<Character> alivePlayers = players.stream().filter(p -> p.getHp() > 0).toList();
            if (!alivePlayers.isEmpty()) {
                Character enemy = aliveEnemies.get(random.nextInt(aliveEnemies.size()));
                Character playerTarget = alivePlayers.get(random.nextInt(alivePlayers.size()));
                int damage = random.nextInt(15) + 5; // Random damage between 5 and 20
                playerTarget.takeDamage(damage);
                System.out.println(enemy.getName() + " attacks " + playerTarget.getName() + " for " + damage + " damage.");
            }
        }
    }

    //pelissä ei voita yksittäinen pelaaja, vaan pelaajat voittavat, jos joku pelaajista on elossa "combatin" lopussa.
    @Override
    public void displayWinner() {
        boolean playersAlive = players.stream().anyMatch(p -> p.getHp() > 0);
        if (playersAlive) {
            System.out.println("Players win!");
        } else {
            System.out.println("Game over.");
        }
    }
}
