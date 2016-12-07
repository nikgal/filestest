package by.galov.filemanager;

import java.util.Date;
import java.util.Map;

public class DateCommand extends Command {

    public DateCommand(Map<String, String> args) {
        super(args);
        
    }

    public DateCommand() {
        super(null);
     
    }

    @Override
    public void execute() {
        Date now = new Date();
        System.out.println(now.toString());
        logCmd.fine("done");
    }

    @Override
    public void help() {
        
        System.out.println("date - current date");
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
