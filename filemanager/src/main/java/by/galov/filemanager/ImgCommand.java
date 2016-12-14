package by.galov.filemanager;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImgCommand extends Command {
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
    

    @Override
    public void execute() {
        switch(argument.get("arg2")){
            case "noire":
                //int[][] result = convertTo2DUsingGetRGB(image);
                long startTime = System.nanoTime();
                for(int width=0; width < image.getWidth(); width++)
                {
                    for(int height=0; height < image.getHeight(); height++)
                    { 
                         Color temp = new Color(image.getRGB(width, height));
                         int aver = (int) ((temp.getBlue() + temp.getGreen() + temp.getRed())/3.0);
                         Color target = new Color(aver, aver, aver);
                         image.setRGB(width, height, target.getRGB());
                        
                    }
                }
                long endTime = System.nanoTime();
            try {
                ImageIO.write(image, "jpg", new File("d:\\111.jpg"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(toString(endTime - startTime));
            break;
            
            case "blur":
               
                startTime = System.nanoTime();
                BufferedImage imageRed = null;
                try {
                    ImageIO.write(image, "jpg", new File("d:\\111.jpg"));
                    imageRed = ImageIO.read(new File("d:\\111.jpg"));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
          
                for(int x = 0; x < Integer.parseInt(argument.get("arg3")); x++)
                {
                    for(int width = 1; width < imageRed.getWidth() - 1; width++)
                    {
                        for(int height = 1; height < imageRed.getHeight() - 1; height+=2)
                        { 
                             Color temp = new Color((int) ((
                                     imageRed.getRGB(width - 1, height) + 
                                     imageRed.getRGB(width + 1, height) +
                                     imageRed.getRGB(width, height - 1) +
                                     imageRed.getRGB(width, height + 1) +
                                     imageRed.getRGB(width, height)) / 5.0));

                             imageRed.setRGB(width, height, temp.getRGB());
                            
                        }
                    }
                    try {
                        ImageIO.write(imageRed, "jpg", new File("d:\\121.jpg"));
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                endTime = System.nanoTime();
           
            System.out.println(toString(endTime - startTime));
            break;
            
            default: System.err.println("unknown command");
          }
    }
    
    private static String toString(long nanoSecs) {
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
