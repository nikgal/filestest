package by.galov.filemanager;

import java.io.File;
import java.util.Map;

public class PwdCommand extends Command {
    private File file;
    public PwdCommand(File currentDir, Map<String, String> args) {
        super(args);
        this.file = currentDir;
    }

    @Override
    public void execute() {
        System.out.println(file.toString());
        logCmd.fine("pwd done");
    }

    @Override
    public void help() {
        System.out.println("pwd - show current dir");

    }

    public boolean isCorrect() {
        
        if (argument.get("arg1")==null){
            logCmd.fine("arguments were defined");
            return true;
        }else
            logCmd.warning("arguments weren't defined correctly");
        return false;
    }
}
