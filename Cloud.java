/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.catsgame;

import static com.mycompany.catsgame.Window.frame;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Cloud extends GameObject{
        
        private Handler handler;
        private Random r=new Random();
        private int rand;
        private BufferedImage image;
        
        public Cloud(float x , float y ,ID id, Handler handler )
        {
                super(x,y,id);
                this.handler=handler;
                velX=(float) 6;
                rand=r.nextInt(200)+30;
                this.image=BufferedImageLoader.loadImage("src\\res\\Images\\cloud.png");
        }

        @Override
        public void tick() {
                x+=velX;
                y=HUD.playerY-rand;
                
                if(x>= frame.getBounds().width+500)
                {
                        handler.removeObject(this);
                }
        }

        @Override
        public void render(Graphics g) {
                //g.setColor(Color.white);
                //g.fillRoundRect((int)x,(int) y, 50, 30, 30, 30);
                g.drawImage(image,(int)x,(int) y,100,50, null);
                
        }

        @Override
        public Rectangle getBounds() {
                return new Rectangle ((int)x,(int)y,8,8);
        }
        
        
}
