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
    }

    @Override
    public void help() {
        System.out.println("pwd - show current dir");

    }

    public boolean isCorrect() {
        // TODO Auto-generated method stub
        if (argument.get("arg1")==null){
            return true;
        }else
        return false;
    }
}
