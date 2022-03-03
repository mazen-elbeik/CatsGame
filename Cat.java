/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.catsgame;

//import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
//import javax.swing.ImageIcon;


public class Cat extends GameObject{
        private int size=(int) (80+(Math.random() * 80));/*,shadowSizeX=30,shadowSizeY=30,collisionSizeX=30,collisionSizeY=30;*/
        //private float _acc=1f;
        //private float _dcc=0.5f;
        //private KeyInput input;
        Handler handler;
        public int hits = 1;
        Game game;
        BufferedImage image1,image2;
        int timer=0;
        //ImageIcon i=new ImageIcon(this.getClass().getResource("cat.png"));
        //Image image=i.getImage();
        
        
        public Cat(int x , int y , ID id , Handler handler, Game game )
        {
                super(x,y,id);
                this.handler=handler;
                this.game=game;
                //image=BufferedImageLoader.loadImage("src\\res\\cat.gif");
                image1=BufferedImageLoader.loadImage("src\\res\\Images\\catPos1.png");
                image2=BufferedImageLoader.loadImage("src\\res\\Images\\catPos2.png");
        }

        @Override
        public void tick() 
        {
                y-=velY;
                
                //Vertical movement
               /* if(input.keys[2]) velY -= _acc;
                if(input.keys[3]) velY += _acc;
                else if(!input.keys[3] && !input.keys[2])
                {
                        velY=2;
                }
                
                velY = clamp(velY,3,1);*/
                velY=3*(game.Difficulty-1);
                collision();
                if(y<HUD.playerY-200)
                {
                        y+=1000;
                }
               // handler.addObject(new Trail( (int)x+25 , (int)y , ID.Trail ,Color.red,shadowSizeX,shadowSizeY,0.03f,handler));
                //handler.addObject(new Trail( (int)x-25 , (int)y , ID.Trail ,Color.red,shadowSizeX,shadowSizeY,0.03f,handler));
        }

        @Override
        public void render(Graphics g) 
        {
               //this part draws a dot that symbols to enemy
                //g.setColor(Color.black);
                //g.fillOval((int)x,(int)y,size,size);
                //g.fillOval((int)x+size/2,(int)y-size/2,size-10,size-10);
                //g.fillOval((int)x-size/2+5,(int)y-size/2,size-10,size-10);
                timer++;
                if(timer<50)
                {
                        g.drawImage(image1,(int) x,(int) y,size,size, null);
                }else if(timer>100){timer=0;}
                else
                {g.drawImage(image2,(int) x,(int) y,size,size, null);}
                
        }
        
        private float clamp(float vel,float max,float min )
        {
                if(vel>max)return max;
                if(vel<min)return min;
                return vel;
        }
        
        public Rectangle getBounds()
        {
                return new Rectangle ((int)x+30,(int)y+30,size-60,size-30);
        }
        
        private void collision()
        {
                for(int i=0 ; i<handler.object.size();i++)
                {
                        GameObject tempObject = handler.object.get(i);
                        if(tempObject.getId() == ID.Bullet)
                        {
                                if(getBounds().intersects(tempObject.getBounds()))
                                {
                                        //collision code
                                        HUD.Score+=(size)/8;
                                        if(hits==0)
                                        {
                                                handler.removeObject(this);
                                        }else hits--;
                                        handler.removeObject(tempObject);
                                }
                        }
                }
        }
}
