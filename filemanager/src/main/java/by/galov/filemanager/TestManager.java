package by.galov.filemanager;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestManager {
    
    public static File currentDir = new File(System.getProperty("user.dir"));
    
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
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String command;
        
        do{
            System.out.print(currentDir.toString()+" > ");
            command = sc.nextLine();
            
            Command cmd = parseCommand(command);
            if(cmd != null){
                if(cmd.argument.get("arg1")!=null && cmd.argument.get("arg1").equals("help")){
                    cmd.help();
                }else{
                    if (cmd.isCorrect())
                    cmd.execute();

                }
            }
               
            
        }while(!command.equals("exit"));
        
        sc.close();

    }

}