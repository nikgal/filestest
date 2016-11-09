package by.galov.general.directories;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class MakeDirectories {
    
    private static void usage() {
        System.err.println(""
                + "Usage:MakeDirectories path1 ...\n"
                + "Creates each path\n"
                + "Usage:MakeDirectories -d path1 ..."
                + "Deletes each.path\n"
                + "Usage:MakeDirectories -r path1 path2\n"
                + "Renames from path1 to path2");
        System.exit(1);
    }
    private static void fileData(File f){
        System.out.println(""
                + "Absolute path:"+ f.getAbsolutePath()+""
                        + "\n Can read:"+ f.canRead()
                        +"\n getName "+f.getName()
                        +"\n getParent "+f.getParent()
                        +"\n getPath "+ f.getPath()
                        +"\n length: "+ f.length()
                        +"\n lastModified "+f.lastModified());
        if(f.isFile())
            System.out.println("It is a file");
        else if(f.isDirectory())
            System.out.println("It is a dir");
    }
    
    public static void main(String[] args) throws IOException{
       if(args.length<1) usage();
       if(args[0].equals("-r")){
           if(args.length != 3) usage();
           File 
           old = new File(args[1]),
           rname = new File(args[2]);
           old.renameTo(rname);
           return;
       }
       if(args[0].equals("-d")){
           if(args.length != 2) usage();
           File f = new File(args[1]);
           f.delete();
           return;
       }
       
       if(args[0].equals("-c")){
           if(args.length != 2) usage();
           File f = new File(args[1]);
           try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
           return;
       }
       if(args[0].equals("-c")){
           if(args.length != 2) usage();
           File f = new File(args[1]);
           try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
           return;
       }
       if(args[0].equals("-read")){
           if(args.length != 2) usage();
           File f = new File(args[1]);
           
          BufferedReader in = new BufferedReader(new FileReader(f));
          
           
          String s;
          StringBuilder sb = new StringBuilder();
          while((s = in.readLine()) != null){
              sb.append(s+"\n");
          }
          System.out.println(sb.toString());
          in.close();
           return;
       }
       if(args[0].equals("-write")){
           if(args.length != 3) usage();
           File f = new File(args[1]);
           
          BufferedReader in = new BufferedReader(new FileReader(f));
          PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
          
          String s = args[2];
          out.println(s);
          out.close();
           return;
       }
    }
    
    
}
