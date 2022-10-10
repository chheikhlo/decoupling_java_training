package fr.lernejo.guessgame;

import java.security.SecureRandom;

import static java.lang.Integer.parseInt;

public class Launcher {

    public static void main(String[] args) throws InterruptedException {

       // int secondArg = (int)args[1];
        if(args[0].equals("-interactive")){
            HumanPlayer joueur = new HumanPlayer();
            Simulation jouer = new Simulation(joueur);

            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextLong(23,100); // génère un nombre entre Long.MIN_VALUE et Long.MAX_VALUE
            jouer.initialize(randomNumber);

            jouer.loopUntilPlayerSucceed(100);
        }else if(args[0].equals("-auto") && parseInt(args[1]) > 0){
            ComputerPlayer robot = new ComputerPlayer();
            Simulation jouer = new Simulation(robot);

            jouer.initialize(parseInt(args[1]));

            jouer.loopUntilPlayerSucceed(1000);

        }else{
            System.out.println("\n-----------------------------INSTRUCTION-------------------------------");
            System.out.println("Merci d'ajouter l'argument '-interactive' pour jouer en tant qu'humain");
            System.out.println("Merci d'ajouter l'argument '-auto' et le nombre à déviner en second argument pour faire jouer le robot");
            System.out.println("-----------------------------------------------------------------------");
        }

    }
}
