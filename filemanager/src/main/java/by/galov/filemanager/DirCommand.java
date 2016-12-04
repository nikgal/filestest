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

    }

    @Override
    public void help() {
        System.out.println("dir - show current directory list");
    }
    public boolean isCorrect() {
        // TODO Auto-generated method stub
        if (argument.get("arg1")==null){
            return true;
        }else
        return false;
    }

}
