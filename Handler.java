
package com.mycompany.catsgame;
import java.util.LinkedList;
import java.awt.*;

public class Handler
{
        public LinkedList<GameObject> object = new LinkedList<GameObject>();
        
        public void tick()
        {
                for(int i=0 ; i<object.size(); i++)
                {
                        object.get(i).tick();
                }
        }
        public void render(Graphics g)
        {
                for(int i=object.size()-1 ; i>=0; i--)
                {
                        object.get(i).render(g);
                }
        }
        
        public GameObject addObject(GameObject temp)
        {
                object.add(temp);
                return temp;
        }
        
        public GameObject removeObject(GameObject temp)
        {
                object.remove(temp);
                return temp;
        }
        
        public void clearEnemies()
        {
                for(int i=0 ; i < object.size() ; i++)
                {
                        if(object.get(i).getId() == ID.Cat)
                        {
                                removeObject(object.get(i));
                        }
                }
        }
        
        public void clearBullets()
        {
                for(int i=0 ; i < object.size() ; i++)
                {
                        if(object.get(i).getId() == ID.Bullet)
                        {
                                removeObject(object.get(i));
                        }
                }
        }
}
