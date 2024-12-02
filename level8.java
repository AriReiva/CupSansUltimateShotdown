import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class level8 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class level8 extends Stage1
{

    /**
     * Constructor for objects of class level8.
     * 
     */
    public level8(int lh)
    {
        this.loseHealth = lh;
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        brick brick = new brick();
        for(int i = 0; i < getWidth()/brick.getImage().getWidth()+1; i++)
        {
            addObject(new brick(), brick.getImage().getWidth()/2 + i*brick.getImage().getWidth(), 632);
        }
        q = new KeyQ();
        super.prepare(0,551,8);
    }
    
    public void act()
    {
        if (p.getX() >= getWidth() - p.hitboxWidth/2 && p.getY() <= 600) 
            {
                Greenfoot.delay(5);
                Greenfoot.setWorld(new level6(loseHealth));
            } 
            
            if (p.getX() >= 300 && p.getX() <= 420)
            {
                if (!p.b1) addObject(q, 300, 300);

                if (Greenfoot.isKeyDown("q")) {
                    if (!p.b1) {
                        p.b1 = true;
                        q.getImage().scale((int)Math.round(q.getImage().getWidth() * 0.8),
                            (int)Math.round(q.getImage().getHeight() * 0.8));

                        p.nextLevel();
                    }
                }
                else
                {
                    List<KeyQ> q = getObjects(KeyQ.class);

                    for (KeyQ kq : q)
                    {
                        kq.resetImage();
                    }
                }
            }
            else
            {
                List<KeyQ> q = getObjects(KeyQ.class);

                for (KeyQ kq : q)
                {
                    kq.resetImage();
                    removeObject(kq);
                }
            }
    }
}
