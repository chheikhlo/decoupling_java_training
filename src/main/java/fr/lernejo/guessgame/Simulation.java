package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            logger.log("found");
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


    public void loopUntilPlayerSucceed(int maxIterBoucle) throws InterruptedException {
        //TODO implement me
        long start = System.currentTimeMillis();

        Date date1 = new Date(start);
        String result1 = new SimpleDateFormat("mm:ss.SSS").format(date1.getTime());
        //logger.log("Début Jeu à: "+result1);

        long stop = System.currentTimeMillis();

        Date date2 = new Date(stop);
        String result = new SimpleDateFormat("mm:ss.SSS").format(date2.getTime());


        int time = (date2.getSeconds() - date1.getSeconds());
        String result3 = new SimpleDateFormat("mm:ss.SSS").format(time);

        while(maxIterBoucle !=0) {
           Boolean jouer = nextRound();
           if(jouer){
               logger.log("Fin Jeu à: "+ result);
               logger.log("Temps de jeu est: "+ result3);
               break;
           }
           maxIterBoucle--;
        }

        if(maxIterBoucle != 0){
            logger.log("WAAW En plus tu a trouvé avant la limite d'itération ");
        }else {
            logger.log("Fin Jeu à: "+ result);
            logger.log("Temps de jeu est: "+ result3);
            logger.log("Oh non limite d'itération atteinte");
        }

       /* int cpt = 8;
        while(nextRound() == false && cpt !=0) {
            nextRound();
            cpt--;
            if(cpt==0)
                logger.log(result);
        }
        if(cpt != 0){
            logger.log("En plus tu a trouvé avant la limite d'itération ");
        }else
            logger.log("Oh non limite d'itération atteinte");*/




    }
}
