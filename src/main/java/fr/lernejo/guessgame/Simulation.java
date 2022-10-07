package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    /*
    ------------Faux-----------------
    SecureRandom random = new SecureRandom();
    long randomNumber = random.nextLong(23,100); // génère un nombre entre Long.MIN_VALUE et Long.MAX_VALUE
    numberToGuess = randomNumber;
    */
    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me

        long nbDemand = player.askNextGuess();

        if (this.numberToGuess == nbDemand) {
            logger.log("Bravo t'as trouvé");
            return true;
        }

        player.respond(this.numberToGuess < nbDemand);

      return false;
    }

    public void loopUntilPlayerSucceed() {
        //TODO implement me
        while(nextRound() == false){
            nextRound();
        }
    }
}
