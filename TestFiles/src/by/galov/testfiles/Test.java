package by.galov.testfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        File file = new File("input.txt");
        System.out.println(file.exists());
        
        try {
            FileOutputStream fs = new FileOutputStream(file);
            fs.write(120);
        } catch (FileNotFoundException e) {
           System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }

}
