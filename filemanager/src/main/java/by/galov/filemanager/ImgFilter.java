package by.galov.filemanager;

import java.io.File;
import java.util.Map;

public class ImgFilter extends Command implements  Runnable {
    public ImgFilter(Map<String, String> args) {
        super(args);
        // TODO Auto-generated constructor stub
    }

    public void run() {
        execute();
    }

@Override
public void execute() {
    // TODO Auto-generated method stub
    ImgCommand ic = new ImgCommand(argument);
    ImgCommand ic2 = new ImgCommand(argument);
    ThreadRunner tr = new ThreadRunner();
    
    tr.run();
    ic2.run();
    
    ic.run();
    
   
    
}

@Override
public void help() {
    // TODO Auto-generated method stub
    
}

@Override
public boolean isCorrect() {
    // TODO Auto-generated method stub
    return true;
}
}
