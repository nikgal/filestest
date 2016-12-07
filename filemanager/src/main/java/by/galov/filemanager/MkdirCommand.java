package by.galov.filemanager;

import java.io.File;
import java.util.Map;

public class MkdirCommand extends Command {
    private File file;
    public MkdirCommand(Map<String, String> args) {
        super(args);
        try{
        this.file =new File(args.get("arg1"));
        }catch(NullPointerException e){
            System.err.println("Select dir!");
        }
    }

    @Override
    public void execute() {
        if(file.mkdir()){
            System.out.println(file.getAbsolutePath()+" was created !");
            logCmd.finest("mkdir done");
        }else{
            System.err.println("it is not directory");
        }

    }

    @Override
    public void help() {
        System.out.println("mkdir path - create directory in path");

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
