package by.galov.filemanager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

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
        try {
            Stream<String> streamFromFile = Files.lines(file.toPath());
            int count = 0;
            count = (int) streamFromFile
                    .map((s) -> s.split(" "))
                    .mapToInt((array) -> array.length)
                    .sum();
            
            System.out.println("number of strings: "+ count);
            
            String[] sa;
            Stream<String> streamFromFile1 = Files.lines(file.toPath());
            sa = streamFromFile1.map(String::toUpperCase).toArray(String[]::new);
           
            System.out.println("number of strings: "+ sa.length);
            for(String s:sa){
                System.out.println(s);
            }
            streamFromFile.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        /*
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
        }*/
        
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
