package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;
import java.util.Scanner;

public class ComputerPlayer implements Player{

    Logger logger = LoggerFactory.getLogger("Player");

    @Override
    public long askNextGuess() {
        logger.log("Veuiller renseigner une valeur svp : ");
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextLong(0,1000);
        logger.log(String.valueOf(randomNumber));
        return randomNumber;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater == true ) {
            logger.log("Oup's la valeur est plus petit");
        }else
            logger.log("Oup's la valeur est plus grand");
    }
}
