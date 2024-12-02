import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class level7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class level7 extends Stage1
{

    /**
     * Constructor for objects of class level7.
     * 
     */
    public level7(int lh)
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
            addObject(new brick(), brick.getImage().getWidth()/2 + i*brick.getImage().getWidth(), 643);
        }
        q = new KeyQ();
        super.prepare(0,561,7);
    }

    public void act()
    {
        if (p.b1 && p.b2)
        {
            if (p.getX() >= getWidth() - p.hitboxWidth/2 && p.getY() <= 600) 
            {
                p.nextLevel();
            }
        }
        else
        {
            if (p.getX() >= getWidth() - p.hitboxWidth/2 && p.getY() <= 600) 
            {
                Greenfoot.delay(5);
                Greenfoot.setWorld(new level6(loseHealth));
            }                
        }

        if (p.getX() >= 275 && p.getX() <= 325 && p.getY() <= 400)
        {
            if (!p.b1) addObject(q, 250, 300);

            if (Greenfoot.isKeyDown("q")) {
                if (!p.b1) {
                    p.b1 = true;
                    q.getImage().scale((int)Math.round(q.getImage().getWidth() * 0.8),
                        (int)Math.round(q.getImage().getHeight() * 0.8));
                }
            }
        } else
        if (p.getX() >= 550 && p.getX() <= 600 && p.getY() <= 450)
        {
            if (!p.b2) addObject(q, 520, 300);

            if (Greenfoot.isKeyDown("q")) {
                if (!p.b2) {
                    p.b2 = true;
                    q.getImage().scale((int)Math.round(q.getImage().getWidth() * 0.8),
                        (int)Math.round(q.getImage().getHeight() * 0.8));
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
