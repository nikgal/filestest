package by.galov.filemanager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class MwCommand extends Command {

    private File from, to;
    
    public MwCommand(Map<String, String> args) {
        super(args);
        this.from = new File(args.get("arg1"));
        this.to = new File(args.get("arg2"));
    }

    @Override
    public void execute() {
        System.out.println("Moving from"+from.toString()+" to "+to.toString());
        try {
            Files.move(from.toPath(), to.toPath());
            logCmd.fine("mw done");
        } catch (IOException e) {
            System.err.println("wrong path");
        }
    }

    @Override
    public void help() {
        System.out.println("mw path1 path2 - movw file from path1 to path2");

    }
    public boolean isCorrect() {
        if (argument.get("arg1")!=null && argument.get("arg2")!=null){
            logCmd.fine("arguments were defined");
            return true;
        }else
            logCmd.warning("arguments weren't defined correctly");
        return false;
    }

}
