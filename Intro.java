/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.catsgame;

import static com.mycompany.catsgame.Window.frame;
import java.awt.Color;
//import java.awt.Font;
import java.awt.Graphics;
//import java.awt.Toolkit;
import java.awt.image.BufferedImage;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author mazen
 */


public class Intro
{
        static int timer=0; 
        static BufferedImage image=BufferedImageLoader.loadImage("src\\res\\Images\\LOGO3.png");
        static int width=image.getWidth(),height=image.getHeight();
        public static void render(Graphics g,Game game)
        {
                //Font font=new Font("algerian",1,100);
                g.setColor(Color.black);
                g.fillRect(0,0,frame.getBounds().width,frame.getBounds().height);
                g.drawImage(image,(frame.getBounds().width-width)/2 , (frame.getBounds().height-height)/2, null);
                //g.setColor(Color.white);
               //g.setFont(font);
                //g.drawString("MZMZ GAMES", (Toolkit.getDefaultToolkit().getScreenSize().width-width)/2 , (Toolkit.getDefaultToolkit().getScreenSize().height-height)/2);
                /*try {
                        Thread.sleep(1000);
                } catch (InterruptedException ex) {
                        Logger.getLogger(Intro.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                if(timer==500)
                {
                        game.gameState= Game.STATE.Menu;
                }else timer++;
        }
}
