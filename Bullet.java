/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.catsgame;

import java.awt.Graphics;
//import java.awt.Color;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet extends GameObject{
        
        private Handler handler;
        BufferedImage image;
        int size=20;
        
        public Bullet(float x, float y , ID id , Handler handler)
        {
                super(x,y,id);
                this.handler=handler;
                image=BufferedImageLoader.loadImage("src\\res\\Images\\egg.png");
        }

        @Override
        public void tick() {
                x+=velX;
                y+=velY;
                if(x<-2000 || x>2500 || y<HUD.playerY-500 || y>HUD.playerY+2000)
                {
                        handler.removeObject(this);
                }
        }

        @Override
        public void render(Graphics g)
        {
                
                //g.setColor(Color.yellow);
                //g.fillOval((int)x,(int)y,8,8);
                g.drawImage(image,(int)x,(int)y,size,size, null);
                
        }
        
        public Rectangle getBounds()
        {
                return new Rectangle ((int)x,(int)y,size,size);
        }
        
}
