package by.galov.filemanager;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class TouchCommand extends Command {
  private File file;
    
    public TouchCommand(Map<String, String> args) {
        super(args);
        this.file = new File(args.get("arg1"));
    }

    @Override
    public void execute() {
        try {
            if(file.createNewFile()){
                System.out.println("File was created");
                logCmd.finest("file was created");
            }else{
                System.out.println("file wasn't created");
            }
        } catch (IOException e) {
           System.err.println("Couldn't create the file ");
        }

    }

    @Override
    public void help() {
        System.out.println("touch path - create empty file in path");

    }
    public boolean isCorrect() {
        if (argument.get("arg1")!=null && argument.get("arg2")==null){
            logCmd.fine("arguments were defined");
            return true;
        }else
            logCmd.warning("arguments weren't defined correctly");
        return false;
    }

}
