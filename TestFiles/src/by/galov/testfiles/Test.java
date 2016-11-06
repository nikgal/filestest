package by.galov.testfiles;

import java.io.File;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        File path = new File(".");
        String [] list;
        if (args.length == 0)
            list = path.list();
        else 
            list = path.list(new DirFilter(args[0]));
            Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
            for(String dirItem : list)
                System.out.println(dirItem);
            
    

    }

}
