/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.catsgame;

import java.awt.image.BufferedImage;
import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;

/**
 *
 * @author mazen
 */
public class BufferedImageLoader {
        //BufferedImage image=null;
        //ImageIcon icon;
        
        public static BufferedImage loadImage(String path)
        {
                try
                {
                        //image=ImageIO.read(getClass().getResource(path));
                        //image = ImageIO.read(new FileInputStream(path));
                        return ImageIO.read(new File(path));
                }catch(IOException e)
                {
                        e.printStackTrace();
                        return null;
                        
                }
                //return image;
        }
}
