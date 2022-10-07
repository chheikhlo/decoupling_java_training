package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {
        HumanPlayer joueur = new HumanPlayer();
        Simulation jouer = new Simulation(joueur);

        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextLong(23,100); // génère un nombre entre Long.MIN_VALUE et Long.MAX_VALUE
        jouer.initialize(randomNumber);

        jouer.loopUntilPlayerSucceed();
    }
}
