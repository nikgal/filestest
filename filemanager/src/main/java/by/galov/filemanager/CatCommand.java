package by.galov.filemanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class CatCommand extends Command {
  private File file;
    
    public CatCommand(Map<String, String> args) {
        super(args);
        this.file = new File(args.get("arg1"));
    }
    
    @Override
    public void execute() {
        String s;
        StringBuilder sb = new StringBuilder();
        try {
            if(file.exists()){
                BufferedReader in = new BufferedReader(new FileReader(file));
                System.out.println("Openning "+file.getAbsolutePath()+"...");
                while((s=in.readLine()) != null){
                    sb.append(s);
                    sb.append("\n");
                }
                System.out.println(sb.toString());
                in.close();
                logCmd.finest("file was read");
            }else{
                logCmd.warning("File does not exists");
            }
        } catch (IOException e) {
            System.out.println("Can not read the file! ");
        }
        
    }

    @Override
    public void help() {
        System.out.println("cat file_path - output file content ");

    }
    public boolean isCorrect() {
        if (argument.get("arg1")!=null && argument.get("arg2")==null){
            logCmd.fine("arguments were defined");
            return true;
        } else{
            logCmd.warning("arguments weren't defined correctly");
            return false;
          }
    }

}
