package com.mycompany.catsgame;
import java.awt.event.*;

public class KeyInput extends KeyAdapter
{
        public boolean keys[] = new boolean[7];
        public void keyPressed(KeyEvent e)
        {
                int key=e.getKeyCode();
                
                if (key == KeyEvent.VK_D)keys[0]=true;
                if (key == KeyEvent.VK_A)keys[1]=true;
                if (key == KeyEvent.VK_W)keys[2]=true;
                if (key == KeyEvent.VK_S)keys[3]=true;
                if (key == KeyEvent.VK_X)keys[4]=true;
                if (key == KeyEvent.VK_SPACE)keys[5]=true;
                if (key == KeyEvent.VK_H)keys[6]=true;
                
        }
        
        public void keyReleased(KeyEvent e)
        {
                int key=e.getKeyCode();
                
                if (key == KeyEvent.VK_D)keys[0]=false;
                if (key == KeyEvent.VK_A)keys[1]=false;
                if (key == KeyEvent.VK_W)keys[2]=false;
                if (key == KeyEvent.VK_S)keys[3]=false;
                if (key == KeyEvent.VK_X)keys[4]=false;
                if (key == KeyEvent.VK_SPACE)keys[5]=false;
                if (key == KeyEvent.VK_H)keys[6]=false;
        }
}
