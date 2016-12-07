package by.galov.filemanager;

import java.io.File;
import java.util.Map;


public class CdCommand extends Command {


    public CdCommand(File currentDirectory, Map<String, String> args){
        super(args);
        
    }
    
    public void execute() {
        String newDir = argument.get("arg1");
        if (newDir == null){
            System.err.println("Select dir!");
        } else{
            File file = new File(newDir);
            if (!file.isDirectory()){
                System.err.println("Wrong dir! ");
            } else{
                
                TestManager.currentDir = file.getAbsoluteFile();
                logCmd.finest("cd success");
            }
        }

    }

    @Override
    public void help() {
        System.out.println("cd direct - change directory");

    }
    public boolean isCorrect() {
        if (argument.get("arg1") != null && argument.get("arg2") == null){
            logCmd.fine("arguments were defined");
            return true;
        }else
            logCmd.warning("arguments weren't defined correctly");
        return false;
    }


}
