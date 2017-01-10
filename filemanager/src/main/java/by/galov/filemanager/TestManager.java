package by.galov.filemanager;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;



public class TestManager {
    
    public static File currentDir = new File(System.getProperty("user.dir"));
    
    static Logger log = Logger.getLogger(TestManager.class.getName());
    
    private static Command parseCommand(String commandString){
        String[] args = commandString.split(" ");
        switch (args[0]) {
            case "dir":
                return new DirCommand(currentDir, parseArguments(args));
            case "cd": 
                return new CdCommand(currentDir, parseArguments(args));
            case "pwd":
                return new PwdCommand(currentDir, parseArguments(args));
            case "cp":
                return new CpCommand(parseArguments(args));
            case "mv":
                return new MwCommand(parseArguments(args));
            case "cat": 
                return new CatCommand(parseArguments(args));
            case "date": 
                return new DateCommand(parseArguments(args));
            case "find": 
                return new FindCommand(parseArguments(args));
            case "mkdir":
                return new MkdirCommand(parseArguments(args));
            case "touch": 
                return new TouchCommand(parseArguments(args));
            case "img": 
                return new ImgCommand(parseArguments(args));
            case "thread": 
                return new ImgFilter(parseArguments(args));
            case "wc": 
                return new WcCommand(parseArguments(args));
            default:
            return null;
        }
    }
    public static Map<String, String> parseArguments(String[] args){
        Map<String, String> arguments = new HashMap<String, String>();
        for(int i =1; i<args.length;i++) {
            arguments.put("arg"+i, args[i]);
        }
        return arguments;
    }
    public static void main(String[] args) throws IOException {
        
        try{
            LogManager.getLogManager().readConfiguration(TestManager
                    .class.getResourceAsStream("/logging.properties"));
        } catch (IOException ex) {
            log.severe("couldn't setup logger configuration!");
        } catch (SecurityException e){
            log.severe("couldn't setup security configuration!");
        } catch (NullPointerException e){
            log.severe("Null");
        }
      
        log.fine("start program in current dir: "+ currentDir.toString());
        Scanner sc = new Scanner(System.in);
        String command;
            
        
        
        do{
            
            System.out.print(currentDir.toString()+" > ");
            command = sc.nextLine();
            
            Command cmd = parseCommand(command);
            if(cmd != null){
                
                if(cmd.argument.get("arg1")!=null && cmd.argument.get("arg1").equals("help")){
                    cmd.help();
                    log.info("help called for "+ cmd.toString());
                }else{
                    if (cmd.isCorrect())
                    cmd.execute();
                    

                }
            }
               
            
        }while(!command.equals("exit"));
        
        sc.close();
        log.fine("exit program");
    }

}