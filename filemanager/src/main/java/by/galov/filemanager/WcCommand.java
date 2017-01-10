package by.galov.filemanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class WcCommand extends Command {
    private File file;
    public WcCommand(Map<String, String> args) {
        super(args);
        this.file = new File(args.get("arg1"));
        // TODO Auto-generated constructor stub
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        try(Scanner sc = new Scanner(new FileInputStream(file))){
            int count = 0;
            while(sc.hasNext()){
                sc.next();
                count++;
            }
            System.out.println("number of words: "+ count);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void help() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isCorrect() {
        if (argument.get("arg1")!=null){
            logCmd.fine("arguments were defined");
            return true;
        }else
            logCmd.warning("arguments weren't defined correctly");
        return false;
    }

}
