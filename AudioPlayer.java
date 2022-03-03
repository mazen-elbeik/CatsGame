/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.catsgame;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//import org.newdawn.slick.Music;

/**
 *
 * @author mazen
 */
public class AudioPlayer {
        
        private static Clip clip;
        
        public static void playMusic(String path)
        {
                File musicPath=new File(path);
                System.out.println("here");
                try{  
      

                        if(musicPath.exists())
                        {
                                clip =AudioSystem.getClip();
                                AudioInputStream audioinput=AudioSystem.getAudioInputStream(musicPath);
                                clip.open(audioinput);
                                clip.start();
                                clip.loop(Clip.LOOP_CONTINUOUSLY);
                                
                        }
   
                }catch(Exception e){System.out.println("Audio not found");}
        }
        
}
