package by.galov.filemanager;

import java.io.File;
import java.util.Map;



public class DirCommand extends Command {

    public DirCommand(File currentDirectory, Map<String, String> args){
        super(args);
    
    }
    @Override
    public void execute() {
        File[] files = TestManager.currentDir.listFiles();
        for(File file: files){
            System.out.println(file.getName());
        }
        logCmd.fine("dir done");

    }

    @Override
    public void help() {
        System.out.println("dir - show current directory list");
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
