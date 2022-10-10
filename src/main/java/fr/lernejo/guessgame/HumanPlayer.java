package fr.lernejo.guessgame;

import fr.lernejo.logger.ConsoleLogger;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.util.Scanner;

public class HumanPlayer implements Player{

    Logger logger = LoggerFactory.getLogger("Player");

    @Override
    public long askNextGuess() {
        logger.log("Veuillez renseigner une valeur :");
        Scanner sc = new Scanner(System.in);
        long nbDemand = sc.nextLong();
        return nbDemand;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater == true ) {
            logger.log("Oup's la valeur est plus petit");
        }else
            logger.log("Oup's la valeur est plus grand");
    }


}
