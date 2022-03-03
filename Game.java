package com.mycompany.catsgame;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
import java.util.Random;
//import java.util.logging.Level;
//import java.util.logging.Logger;


public class Game extends Canvas implements Runnable {
        public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width , HEIGHT =Toolkit.getDefaultToolkit().getScreenSize().height;
        String title = "THE FALLING CHICKEN";
        public Thread thread;
        boolean isRunning=false;
        private Handler handler;
        private KeyInput input;
        private MouseInput minput;
        public Camera cam;
        private HUD hud;
        //private int distance=20;
        //private int timer=0;
        public BufferedImage image,image1,image2;
        private Menu menu;
        public int Difficulty = 1;
        public boolean player1=true;
        public boolean player2=false;
        public enum STATE 
        {
                Menu,
                Help,
                Game,
                Difficulty,
                Level,
                Options,
                ChoosePlayer,
                Intro,
                End;
        }
        public STATE gameState = STATE.Intro;
        
        public Game()
        {
                AudioPlayer.playMusic("src\\res\\Audio\\crazyCats.wav");
                new Window(WIDTH,HEIGHT,title,this);
                start();
                init();
        }
        
        private void init()
        {
                handler = new Handler();
                input = new KeyInput();
                cam= new Camera(0,0,handler);
                minput=new MouseInput(handler , cam, this);
                hud=new HUD(handler,this);
                //spawn = new Spawn(handler , hud , this);
                menu=new Menu(this , handler , input);
                image=BufferedImageLoader.loadImage("src\\res\\Images\\bestBk.jpg");
                image1=BufferedImageLoader.loadImage("src\\res\\Images\\c.Png");
                image2=BufferedImageLoader.loadImage("src\\res\\Images\\chicken0.gif");
                
                
                
                this.addKeyListener(input);
                this.addMouseListener(minput);
                this.addMouseListener(menu);
                Random r = new Random();
                
                handler.addObject(new Player(600 , 100 , ID.Player , input , handler , WIDTH , this));
                
                
                
                minput.findPlayer();
        }
        
        private synchronized void start()
        {
                if(isRunning) return;
                
                thread = new Thread(this);
                thread.start();
                isRunning=true;
        }
        
        public synchronized void stop()
        {
                if(!isRunning) return;
                
                try{thread.join();} 
                catch (InterruptedException e){e.printStackTrace();}
                isRunning= false;
                
        }
        
        public void run()
        {
                this.requestFocus();
                long lastTime = System.nanoTime();
                double amountOfTicks = 60.0;
                double ns = 1000000000 / amountOfTicks;
                double delta = 0;
                long timer = System.currentTimeMillis();
                int updates = 0;
                int frames = 0;
                while(isRunning)
                {
                        long now = System.nanoTime();
                        delta += (now - lastTime) / ns;
                        lastTime = now;
                        while(delta >= 1)
                        {
                                tick();
                                updates++;
                                delta--;
                        }
                        render();
	                frames++;
			
                        if(System.currentTimeMillis() - timer > 1000)
                        {
                                timer += 1000;
                                System.out.println("FPS: " + frames + " TICKS: " + updates);
                                frames = 0;
                                updates = 0;
                        }
                }
        }
        
        private void tick()
        {
                
                
                if(gameState==STATE.Game)
                {
                        handler.tick();
                        cam.tick();
                        hud.tick();
                        //spawn.tick();
                        if(HUD.HEALTH<=0)
                        {
                                handler.clearEnemies();
                                handler.clearBullets();
                                gameState=STATE.End;
                        }
                }else if(gameState==STATE.Menu || gameState==STATE.End || gameState==STATE.Difficulty || gameState==STATE.Level)
                {
                        menu.tick();
                        //distance=20;
                }
        }
        
        private void render()
        {
                BufferStrategy bs = this.getBufferStrategy();
                if(bs==null)
                {
                        this.createBufferStrategy(3);
                        return;
                }
                Graphics g = bs.getDrawGraphics();
                Graphics2D g2d = (Graphics2D) g;
               
                
                g.drawImage(image,0, 0,(int) WIDTH,(int) HEIGHT,null);
                //g.setColor(new Color(0 , 230 , 0));
                //g.drawImage(image2,0, HEIGHT-distance, WIDTH, HEIGHT,null);
                //timer++;
                //if(timer%10==0 && distance<HEIGHT/2+150)distance++;
                
                if(gameState==STATE.Game)
                {
                        g2d.translate(-cam.getX(), -cam.getY());
                        handler.render(g);
                        hud.render(g);
                        g2d.translate(cam.getX(), cam.getY());
                        menu.render(g);
                }else if(gameState==STATE.Menu || gameState==STATE.Help || gameState==STATE.End || gameState==STATE.Difficulty || gameState==STATE.Level || gameState==STATE.Options || gameState==STATE.ChoosePlayer)
                {
                        menu.render(g);
                }else if(gameState==STATE.Intro)
                {
                        Intro.render(g,this);
                }
                
                
                
                bs.show();
                g.dispose();
        }
        
        public static void main(String[] args)
        {
                
                new Game();
        }
}
