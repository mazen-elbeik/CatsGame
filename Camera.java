/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.catsgame;

import static com.mycompany.catsgame.Window.frame;
//import java.awt.Toolkit;

/**
 *
 * @author mazen
 */
public class Camera {
        
        public int x,y;
        private Handler handler;
        private GameObject tempPlayer=null;
        
        public Camera(int x , int y , Handler handler)
        {
                this.x = x;
                this.y=y;
                this.handler = handler;
                
                findPlayer();
        }
        
        public void findPlayer()
        {
                for(int i=0 ; i<handler.object.size(); i++)
                {
                        if(handler.object.get(i).getId() == ID.Player)
                        {
                                tempPlayer = handler.object.get(i);
                                break;
                        }
                }
        }
        
        public void tick()
        {
                if(tempPlayer!=null)
                {
                        if(tempPlayer.x>x+frame.getBounds().width-100){x+=6;}
                        if(tempPlayer.x<x){x-=6;}
                        // x=(int) (tempPlayer.x-Game.WIDTH/2);
                        // y=(int) (tempPlayer.y-Game.HEIGHT/2);
                        y=(int)tempPlayer.y-200;
                        //if(y<(int)tempPlayer.y-150){y+=6;}
                        //if(y>(int)tempPlayer.y-250){y-=6;}
                }else findPlayer();
        }
        
        public void setX(int x)
        {
                this.x = x;
        }
        
        public void setY(int y)
        {
                this.y = y;
        }
        
        public int getX()
        {
                return x;
        }
        
        public int getY()
        {
                return y;
        }
}
