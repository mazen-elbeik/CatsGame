
package com.mycompany.catsgame;
import java.awt.*;
/*import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;*/


public class Player extends GameObject 
{   
        int WIDTH;
        int shadowSizeX = 10 , shadowSizeY=10;
        private float _acc=1f;
        private float _dcc=0.5f;
        private KeyInput input;
        Handler handler;
        //ImageIcon i;
        //Image image;
        Game game;
        //BufferedImage image;
        int size=90;
        
        
        public Player(float x , float y , ID id , KeyInput input,Handler handler , int WIDTH , Game game)
        {
                super(x,y,id);
                this.input = input;
                this.handler = handler;
                this.WIDTH=WIDTH;
                this.game=game;
                //this.image=BufferedImageLoader.loadImage("src\\res\\Images\\c.Png");
                
        }
        
        public Rectangle getBounds()
        {
                return new Rectangle ((int)x,(int)y,size,size);
        }
        
        @Override
        public void tick()
        {
                x += velX;
                y += velY;
                HUD.playerY=y;
                HUD.playerX=x;
                //Horizontal movement
                if(input.keys[0])
                {
                        //velX += _acc;
                        velX=6;
                        if(x >= WIDTH-24)
                        {
                                velX=0;
                        }
                }
                if(input.keys[1])
                {
                        //velX -= _acc;
                        velX = -6;
                        if(x <= 0)
                        {
                                velX=0;
                        }
                }
                else if(!input.keys[0] && !input.keys[1])
                {
                        if(velX > 0)velX -= _dcc;
                        if(velX < 0)velX += _dcc;
                }
                
                //velX = clamp(velX,8,-8);
                
                //Vertical movement
                if(input.keys[2]) velY -= _acc;
                if(input.keys[3]) velY += _acc;
                else if(!input.keys[3] && !input.keys[2])
                {
                        //if(velY > 0)velY -= _dcc;
                        //if(velY < 0)velY += _dcc;
                        velY=3;
                }
                velY = clamp(velY,5,1);
                
                if(input.keys[4]) handler.clearEnemies();
                if(input.keys[5])game.gameState=Game.STATE.Options;
                if(input.keys[6]) HUD.HEALTH=100;
                
                collision();
                
                handler.addObject(new Trail( (int)x+40 , (int)y+50 , ID.Trail ,Color.white,shadowSizeX,shadowSizeY,0.03f,handler));
        }
        
        
        private float clamp(float val,float max,float min )
        {
                if(val>max)return max;
                if(val<min)return min;
                return val;
        }
        
        @Override
        public void render(Graphics g)
        {
                //g.setColor(Color.black);
                //g.fillRect((int)x , (int)y , 20 , 20); 
                if(game.player1){
                        g.drawImage(game.image1,(int) x,(int) y,size,size, null);
                }
                if(game.player2){
                        g.drawImage(game.image2,(int) x,(int) y,size,size, null);
                }
        }
        
        private void collision()
        {
                for(int i=0 ; i<handler.object.size();i++)
                {
                        GameObject tempObject = handler.object.get(i);
                        if(tempObject.getId() == ID.Cat)
                        {
                                if(getBounds().intersects(tempObject.getBounds()))
                                {
                                        //collision code
                                        HUD.HEALTH-=1;
                                        //if(HUD.greenValue>150)
                                        //{
                                               // HUD.greenValue-=10;
                                                //HUD.redValue+=20;
                                       // }
                                       // else if(HUD.redValue<225)
                                       // {
                                                //HUD.redValue+=20;
                                               // HUD.greenValue-=7;
                                        //}
                                       // else{HUD.redValue=255; HUD.greenValue=0;}
                                       //HUD.greenValue-=10;
                                      // HUD.redValue+=20;
                                       //HUD.greenValue = (int) clamp(HUD.greenValue,200,0);
                                      // HUD.redValue =(int) clamp(HUD.redValue,200,0);
                                }
                        }
                }
        }
        
}
