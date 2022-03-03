/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.catsgame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class MouseInput extends MouseAdapter {
        
        private Handler handler;
        private Camera cam;
        private GameObject tempPlayer=null;
        Game game;
        
        public MouseInput(Handler handler, Camera cam,Game game)
        {
                this.handler=handler;
                this.cam=cam;
                this.game=game;
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
        
        
        public void mousePressed(MouseEvent e)
        {
                int mx= e.getX();
                int my = e.getY();
                if(tempPlayer!=null)
                {
                        if(game.gameState==Game.STATE.Game)
                        {
                                GameObject tempBullet =handler.addObject(new Bullet(tempPlayer.x+40,tempPlayer.y+25, ID.Bullet , handler));
                        
                                float angle = (float) Math.atan2(my -tempPlayer.y-25+cam.getY(),mx-tempPlayer.x+cam.getX()-40);
                                int bulletVel=15;
                        
                                tempBullet.velX = (float) ((bulletVel)*Math.cos(angle));
                                tempBullet.velY = (float) ((bulletVel)*Math.sin(angle));
                        }
                }else findPlayer();
        }
}
