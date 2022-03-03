/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.catsgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.mycompany.catsgame.Game.STATE;
//import static com.mycompany.catsgame.Game.WIDTH;
import java.awt.Toolkit;
//import java.awt.image.BufferedImage;
//import static java.lang.Thread.sleep;
//import java.util.logging.Level;
//import java.util.logging.Logger;
/**
 *
 * @author mazen
 */
public class Menu extends MouseAdapter{
        
        Game game;
        private Handler handler;
        private KeyInput input;
        
        public Menu(Game game , Handler handler , KeyInput input)
        {
                this.game=game;
                this.handler=handler;
                this.input=input;
                
        }
        
        public void mousePressed(MouseEvent e)
        {
                int mx=e.getX();
                int my=e.getY();
                
                //Play
                if (mouseOver(mx , my ,280 ,150 ,200 ,64 ) && game.gameState==STATE.Menu)
                {
                        game.gameState= STATE.Difficulty;
                        handler.clearBullets();
                        handler.clearEnemies();
                        //createEnemies();
                        HUD.HEALTH=100;
                }
                //Help
                if (mouseOver(mx , my ,280,250,200,64) &&  game.gameState==STATE.Menu)
                {
                        game.gameState= STATE.Help;
                }
                
                //Player
                if (mouseOver(mx , my ,280,350,200,64) &&  game.gameState==STATE.Menu)
                {
                        
                        game.gameState= STATE.ChoosePlayer;
                }
                
                //Player1
                if (mouseOver(mx , my ,280, 200, 200, 200) &&  game.gameState==STATE.ChoosePlayer)
                {
                        //game.gameState= STATE.ChoosePlayer;
                        game.player2=false;
                        game.player1=true;
                }
                
                //Player2
                if (mouseOver(mx , my ,500, 200, 200, 200) &&  game.gameState==STATE.ChoosePlayer)
                {
                        //game.gameState= STATE.ChoosePlayer;
                        game.player1=false;
                        game.player2=true;
                }
                
                if (mouseOver(mx , my ,380,450,200,64) &&  game.gameState==STATE.ChoosePlayer)
                {
                        game.gameState= STATE.Menu;
                }
                
                
                //Next level
                if (mouseOver(mx , my ,280,350,200,64) &&  game.gameState==STATE.Level)
                {
                        HUD.Level+=1;
                        game.gameState= STATE.Game;
                        handler.clearBullets();
                        handler.clearEnemies();
                        HUD.HEALTH=100;
                        createEnemies();
                        if(HUD.Level>HUD.HighestLevel){HUD.HighestLevel=HUD.Level;}
                }
                
                //Easy
                if (mouseOver(mx , my ,280 ,250 ,200 ,64 ) && game.gameState==STATE.Difficulty)
                {
                        game.gameState= STATE.Game;
                        game.Difficulty=1;
                        handler.clearBullets();
                        handler.clearEnemies();
                        createEnemies();
                        //HUD.HEALTH=100;
                        
                }
                //Medium
                if (mouseOver(mx , my ,280,350,200,64) &&  game.gameState==STATE.Difficulty)
                {
                        game.gameState= STATE.Game;
                        game.Difficulty=2;
                        handler.clearBullets();
                        handler.clearEnemies();
                        createEnemies();
                        //HUD.HEALTH=100;
                }
                //Hard
                if (mouseOver(mx , my ,280,450,200,64) &&  game.gameState==STATE.Difficulty)
                {
                        game.gameState= STATE.Game;
                        game.Difficulty=3;
                        handler.clearBullets();
                        handler.clearEnemies();
                        createEnemies();
                        //HUD.HEALTH=100;
                }
                
                
                //Back
                if (mouseOver(mx , my ,280,350,200,64) && game.gameState==STATE.Help)
                {
                        game.gameState= STATE.Menu;
                }
                //Try again
                if (mouseOver(mx , my ,280,350,200,64) && game.gameState==STATE.End)
                {
                        
                        HUD.Score=0;
                        HUD.Level=1;
                        HUD.HEALTH=100;
                        handler.clearEnemies();
                        handler.clearBullets();
                        game.gameState= STATE.Game;
                        createEnemies();
                        
                }
                /*if (mouseOver(mx,my,(int)HUD.playerX+350,(int)HUD.playerY-175,30,30) && game.gameState==STATE.Game)
                {
                        game.gameState= STATE.Menu;
                }*/
                
                //Main Menu
                if (mouseOver(mx , my ,280 ,250 ,200 ,64 ) && game.gameState==STATE.Options)
                {
                        game.gameState= STATE.Menu;
                        handler.clearBullets();
                        handler.clearEnemies();
                        HUD.Level=1;
                        //HUD.HEALTH=100;
                        
                }
                //difficulty
                if (mouseOver(mx , my ,280,350,200,64) &&  game.gameState==STATE.Options)
                {
                        game.gameState= STATE.Difficulty;
                        handler.clearBullets();
                        handler.clearEnemies();
                        
                        //HUD.HEALTH=100;
                }
                //Continue
                if (mouseOver(mx , my ,280,450,200,64) &&  game.gameState==STATE.Options)
                {
                        game.gameState= STATE.Game;
                        //HUD.HEALTH=100;
                }
                
        }
        
        public void mouseReleased(MouseEvent e)
        {
                
        }
       
        private Boolean mouseOver(int mx , int my , int x , int y , int width , int height)
        {
                if(mx>x && mx<x+width)
                {
                        if(my>y && my<y+height)
                         {
                                return true ;
                         }
                }
                return false;
        }
        
       public void tick()       
       {
               
       }
       
       public void render(Graphics g)
       {
               
                if(game.gameState==STATE.Menu)
                {
                        Font font= new Font("arial",1,70);
                        Font font2= new Font("arial",1,50);
                        g.setColor(Color.DARK_GRAY);
                        g.setFont(font);
                        g.drawString("Level "+ HUD.Level,260, 98);
               
                        g.setFont(font2);
                        g.drawString("Play",325, 198);
                        g.drawRect(280,150,200,64);
                        g.drawString("Help",325, 298);
                        g.drawRect(280,250,200,64);
                        g.drawString("Player",305, 398);
                        g.drawRect(280,350,200,64);
                }else if(game.gameState==STATE.Difficulty)
                {
                        Font font= new Font("arial",1,70);
                        Font font2= new Font("arial",1,50);
                        g.setColor(Color.DARK_GRAY);
                        g.setFont(font);
                        g.drawString("Difficulty",240, 98);
               
                        g.setFont(font2);
                        g.drawString("Easy",325, 298);
                        g.drawRect(280,250,200,64);
                        g.drawString("Medium",285, 398);
                        g.drawRect(280,350,200,64);
                        g.drawString("Hard",325, 498);
                        g.drawRect(280,450,200,64);
                }
                else if(game.gameState==STATE.Help)
                {
                        Font font= new Font("arial",1,50);
                        Font font2= new Font("arial",1,20);
                        g.setFont(font);
                        g.setColor(Color.DARK_GRAY);
                        g.drawString("Back",320, 398);
                        g.drawRect(280,350,200,64);
                        g.setFont(font2);
                        g.drawString("Use A and D buttons to move Horizontally.You can also use W and S to parachute and dive.",120, 198);
                        g.drawString("Use H to heal. Use space Bar to open the Menu.",120, 230);
                }else if(game.gameState==STATE.Level)
                {
                        Font font= new Font("arial",1,50);
                        Font font2= new Font("arial",1,30);
                        g.setFont(font2);
                        g.setColor(Color.DARK_GRAY);
                        g.drawString("NEXT LEVEL",290, 398);
                        g.drawRect(280,350,200,64);
                        g.setFont(font);
                        g.drawString("LEVEL "+HUD.Level+" PASSED",170, 198);
                }
                else if(game.gameState==STATE.End)
                {
                        Font font= new Font("arial",1,40);
                        Font font2= new Font("arial",1,30);
                        g.setFont(font);
                        g.setColor(Color.DARK_GRAY);
                        g.drawString("Try again",290, 390);
                        g.drawRect(280,350,200,64);
                        g.setFont(font2);
                        g.drawString("GAME OVER! You reached level "+HUD.Level,140, 190);
                        g.drawString("Highest Level Reached: "+HUD.HighestLevel,200, 290);
                }else if(game.gameState==STATE.Options)
                {
                        Font font= new Font("arial",1,70);
                        Font font2= new Font("arial",1,30);
                        Font font3= new Font("arial",1,25);
                        g.setColor(Color.DARK_GRAY);
                        g.setFont(font);
                        g.drawString("Options",240, 98);
               
                        g.setFont(font2);
                        g.drawString("Main Menu",300, 290);
                        g.drawRect(280,250,200,64);
                        g.drawString("Continue",315, 490);
                        g.drawRect(280,450,200,64);
                        g.setFont(font3);
                        g.drawString("Change",335, 378);
                        g.drawString("difficulty",330, 405);
                        g.drawRect(280,350,200,64);
                        
                }else if(game.gameState==STATE.ChoosePlayer)
                {
                        Font font= new Font("arial",1,70);
                        Font font2= new Font("arial",1,50);
                        //Font font2= new Font("arial",1,30);
                        //Font font3= new Font("arial",1,25);
                        g.setColor(Color.DARK_GRAY);
                        g.setFont(font);
                        g.drawString("Choose Player",240, 98);
               
                        /*g.setFont(font2);
                        g.drawString("Main Menu",300, 290);
                        g.drawRect(280,250,200,64);
                        g.drawString("Continue",315, 490);
                        g.drawRect(280,450,200,64);
                        g.setFont(font3);
                        g.drawString("Change",335, 378);
                        g.drawString("difficulty",330, 405);
                        g.drawRect(280,350,200,64);*/
                        g.setFont(font2);
                        g.drawString("Back",420, 498);
                        g.drawRect(380,450,200,64);
                        g.drawRect(280, 200, 200, 200);
                        g.drawRect(500, 200, 200, 200);
                        g.setColor(Color.green);
                        if(game.player1){g.fillRect(280, 200, 200, 200);}
                        if(game.player2){g.fillRect(500, 200, 200, 200);}
                        g.drawImage(game.image1,300,220,150,150,null);
                        g.drawImage(game.image2,520,220,150,150,null);
                }/*else if(game.gameState==STATE.Game)
                {
                        g.setColor(Color.black);
                        g.fillRect((int)HUD.playerX+350,(int)HUD.playerY-175,30,30);
                        g.setColor(Color.white);
                        g.drawRect((int)HUD.playerX+350,(int)HUD.playerY-175,30,30);
                        g.fillRect((int)HUD.playerX+355, (int)HUD.playerY-168, 20, 3);
                        g.fillRect((int)HUD.playerX+355, (int)HUD.playerY-161, 20, 4);
                        g.fillRect((int)HUD.playerX+355, (int)HUD.playerY-153, 20, 4);
                }*/
       }
       
       public void createEnemies()
        {
                        for(int i =0 ; i<HUD.Level*10 ; i++)
                        {
                                        handler.addObject(new Cat((int)(Math.random() * Toolkit.getDefaultToolkit().getScreenSize().width) , (int) (HUD.playerY+Toolkit.getDefaultToolkit().getScreenSize().height+(Math.random() * 1000)), ID.Cat , handler, game ));
  
                        }
        }
        
}
