package by.galov.filemanager;

import java.io.File;

public class ThreadRunner extends Thread {
    public void run(){
        ImgCommand ic3 = new ImgCommand(Command.argument);
        ic3.blur(ic3.getImage(), new File(Command.argument.get("arg4")));
    }
}
