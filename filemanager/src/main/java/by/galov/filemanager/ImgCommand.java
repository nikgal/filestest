package by.galov.filemanager;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImgCommand extends Command implements Runnable {
    public void run() {
        System.out.println("run2");
    }

    private File file;
    private  BufferedImage image;
    public ImgCommand(Map<String, String> args) {
        super(args);
        file = new File(args.get("arg1"));
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void toNoire(BufferedImage img, File f) {
        
        for(int width=0; width < img.getWidth(); width++)
        {
            for(int height=0; height < img.getHeight(); height++)
            { 
                 Color temp = new Color(img.getRGB(width, height));
                 int aver = (int) ((temp.getBlue() + temp.getGreen() + temp.getRed())/3.0);
                 Color target = new Color(aver, aver, aver);
                 img.setRGB(width, height, target.getRGB());
                
            }
        }
        
        try {
            ImageIO.write(img, "jpg", f);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public void execute() {
        switch(argument.get("arg2")){
            case "noire":
                File f = new File(argument.get("arg3"));
                long startTime = System.nanoTime();
                toNoire(image,f);
                long endTime = System.nanoTime();
                System.out.println(toString(endTime - startTime));
                break;
            
            case "blur":
                File fb = new File(argument.get("arg3"));
                startTime = System.nanoTime();
                blur(image, fb);
               
                endTime = System.nanoTime();
           
            System.out.println(toString(endTime - startTime));
            break;
            
            
            
            default: System.err.println("unknown command");
          }
    }
    
    private void blur(BufferedImage img, File f) {

        
        float[] matrix = {
                0.111f, 0.111f, 0.111f, 
                0.111f, 0.111f, 0.111f, 
                0.111f, 0.111f, 0.111f, 
                };
        BufferedImage blur = null;
        BufferedImageOp op = new ConvolveOp( new Kernel(3, 3, matrix) );

                blur = op.filter(img, blur);
            
        try {
            ImageIO.write(blur, "jpg", f );
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        
        } 
        
    }
    
    static String toString(long nanoSecs) {
        int minutes    = (int) (nanoSecs / 60000000000.0);
        int seconds    = (int) (nanoSecs / 1000000000.0)  - (minutes * 60);
        int millisecs  = (int) ( ((nanoSecs / 1000000000.0) - (seconds + minutes * 60)) * 1000);


        if (minutes == 0 && seconds == 0)
           return millisecs + "ms";
        else if (minutes == 0 && millisecs == 0)
           return seconds + "s";
        else if (seconds == 0 && millisecs == 0)
           return minutes + "min";
        else if (minutes == 0)
           return seconds + "s " + millisecs + "ms";
        else if (seconds == 0)
           return minutes + "min " + millisecs + "ms";
        else if (millisecs == 0)
           return minutes + "min " + seconds + "s";

        return minutes + "min " + seconds + "s " + millisecs + "ms";
     }
    @Override
    public void help() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isCorrect() {
        if ((argument.get("arg1"))!=null && argument.get("arg2")!=null){
            logCmd.fine("arguments were defined");
            return true;
        }else
            logCmd.warning("arguments weren't defined correctly");
        return false;
    }

}
