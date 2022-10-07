package fr.lernejo.logger;

public class LoggerFactory {



    public static Logger getLogger(String name){
        ConsoleLogger log = new ConsoleLogger();
        return log;
    }

}
