package by.galov.filemanager;

import java.util.Map;
import java.util.logging.Logger;

public abstract class Command {
    public static Map<String, String> argument;
    Logger logCmd = Logger.getLogger(TestManager.class.getName());
    public Command(Map<String, String> args) {
        // TODO Auto-generated constructor stub
        this.argument = args;
    }
    
    public abstract void execute();
    public abstract void help();
    public abstract boolean isCorrect();
}
