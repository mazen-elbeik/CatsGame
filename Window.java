package com.mycompany.catsgame;

import java.awt.*;
import java.awt.image.BufferedImage;
/*import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;*/
import javax.swing.JFrame;


public class Window 
{
        public static JFrame frame ;
        static BufferedImage image=BufferedImageLoader.loadImage("src\\res\\Images\\icon.png");
        public Window(int width, int height , String title , Game game)
        {
                //Image icon = Toolkit.getDefaultToolkit().getImage("cat2.png");    
                frame = new JFrame(title);
                frame.setIconImage(image);
                
                frame.setPreferredSize(new Dimension(width,height));
                frame.setMaximumSize(new Dimension(width , height));
                frame.setMinimumSize(new Dimension(width , height));
                frame.setBackground(Color.green);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(true);
                frame.setLocationRelativeTo(null);
                frame.add(game);
                frame.setVisible(true);
                //playMusic("src\\res\\Audio\\crazyCats.mp3");
        }
        
       /* private void  playMusic(String  path)
        {
                File musicPath=new File(path);

                try{  
      

                        if(musicPath.exists())
                        {
                                clip =AudioSystem.getClip();
                                AudioInputStream audioinput=AudioSystem.getAudioInputStream(musicPath);
                                clip.open(audioinput);
                                clip.start();
                                clip.loop(Clip.LOOP_CONTINUOUSLY);
                        }
   
         }catch(Exception e){}
        }*/
}