package by.galov.filemanager;

import java.util.Map;

public abstract class Command {
    protected Map<String, String> argument;
    public Command(Map<String, String> args) {
        // TODO Auto-generated constructor stub
        this.argument = args;
    }
    
    public abstract void execute();
    public abstract void help();
    public abstract boolean isCorrect();
}
