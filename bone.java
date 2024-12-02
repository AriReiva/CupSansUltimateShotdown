import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bone extends Actor
{
    /**
     * Act - do whatever the bone wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean test = false;
    
    public void act()
    {
        // Add your action code here.
        turn(30);
        
        if (getWorld() instanceof boss3P) setLocation(getX(), getY() - 10);
        else setLocation(getX() + 10, getY());
        
        if(getX() == getWorld().getWidth() - 1 || getY() == 0) 
        {
            getWorld().removeObject(this);
            return;
        }
        bunuhMati();
    }
    public void bunuhMati()
    {
        if(isTouching(kurcaci1.class) || isTouching(meteor.class) ||
        isTouching(meteorUp.class) || isTouching(bom.class)) test = true;
        if(test)
        {
            if(isTouching(bom.class)) 
            {
                bom b = (bom) getOneIntersectingObject(bom.class);
                getWorld().addObject(new explosion(), getX(), getY());
                getWorld().removeObject(b);
            }
            removeTouching(kurcaci1.class);
            getWorld().removeObject(this);
        }
        return;
    }
}
