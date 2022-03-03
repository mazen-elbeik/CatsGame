/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.catsgame;

import com.mycompany.catsgame.Game.STATE;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import java.util.Random;

public class HUD extends MouseAdapter{
        public static double HEALTH=100;
        //public static int greenValue=200;
       // public static int redValue=0;
        public static double Score=0;
        public static int Level=1;
        public static int HighestLevel=1;
        public static float playerY, playerX;
        private int timer= 0 ;
        private Handler handler;
        private Game game;
        Random r=new Random();
        
        public HUD(Handler handler, Game game)
        {
                this.handler=handler;
                this.game=game;
        }
       
        
        public void tick()
        {
                timer++;
                if(HEALTH<100)
                {
                        HEALTH+=0.01;
                        timer=1;      
                } 
                
                Score+=0.015;
                //Score+=2;
                if(Score>= 300*Level)
                {
                        Score=0;
                        game.gameState=STATE.Level;
                        //createEnemies();
                        handler.clearEnemies();
                        handler.clearBullets();
                }
                
                HEALTH=clamp(HEALTH,100,0);
                //greenValue=(int)clamp(greenValue,200,0);
                //redValue=(int)clamp(redValue,200,0);
                
                for(int i=0 ; i<handler.object.size(); i++)
                {
                        if(handler.object.get(i).getId() == ID.Cat)
                        {
                                break;
                        }
                        else if(i == handler.object.size()-1)
                        {
                                for(int j = 0 ; j < 3 ;j++)
                                {
                                        handler.addObject(new Cat((int)(Math.random() * Toolkit.getDefaultToolkit().getScreenSize().width) , (int) (HUD.playerY+Toolkit.getDefaultToolkit().getScreenSize().height+(Math.random() * 100)), ID.Cat , handler, game ));
                                }
                        }
                }
                
                
                if(timer%50==0)
                {
                        //for(int i=0 ; i<2 ; i++)
                        //{
                                handler.addObject(new Cloud((-1)*r.nextInt(300)-500,r.nextInt(),ID.Cloud,handler));
                        //}
                }
                
        }
        
        public void render(Graphics g)
        {
                
                g.setColor(Color.gray);
                if(HEALTH>80)
                {
                        //g.setColor(new Color(redValue , greenValue,0));
                        g.setColor(new Color(0 , 200,0));
                }else if(HEALTH<=80 && HEALTH>60)
                {
                       // g.setColor(new Color(200 , 200,50));
                        g.setColor(new Color(230 , 230,0));
                }else if(HEALTH<=60 && HEALTH>40)
                {
                        //g.setColor(new Color(230 , 230,0));
                        g.setColor(new Color(255 , 240,0));
                }else if(HEALTH<=40 && HEALTH>20)
                {
                        //g.setColor(new Color(255 , 240,0));
                        g.setColor(new Color(255 , 140,0));
                }else
                {
                        g.setColor(new Color(250 , 0,0));
                }
                
                
                
                g.fillRect(game.cam.x+10,(int)playerY-175,(int)HEALTH*2,32);
                g.setColor(Color.white);
                g.drawRect(game.cam.x+10,(int)playerY-175,200,32);
                g.setColor(Color.DARK_GRAY);
                Font font= new Font("arial",1,10);
                g.setFont(font);
                g.drawString("Score: " + (int)Score, game.cam.x+10,(int)playerY -130);
                g.drawString("Level: " + Level, game.cam.x+10,(int) playerY -110);
                //g.fillRect((int)playerX-390,(int)playerY-175,200,32);
                g.setColor(Color.black);
               // g.fillRect((int)playerX+350,(int)playerY-175,30,30);
                g.setColor(Color.white);
                //g.drawRect((int)playerX+350,(int)playerY-175,30,30);
                //g.fillRect((int)playerX+355, (int)playerY-168, 20, 3);
                //g.fillRect((int)playerX+355, (int)playerY-161, 20, 4);
                //g.fillRect((int)playerX+355, (int)playerY-153, 20, 4);
        }
        
        /*public int getScore()
        {
                return (int) Score;
        }*/
        
        private double clamp(double val,double max,double min )
        {
                if(val>max)return max;
                if(val<min)return min;
                return val;
        }
        
        /*public void createEnemies()
        {
                        for(int i =0 ; i<Level*10 ; i++)
                        {
                                        handler.addObject(new Cat((int)(Math.random() * 800) , (int) (HUD.playerY+Toolkit.getDefaultToolkit().getScreenSize().height+(Math.random() * 1000)), ID.Cat , handler ));
  
                        }
        }*/
}
