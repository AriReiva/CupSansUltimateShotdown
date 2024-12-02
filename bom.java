import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bom here.
 * 
 * @version (a version number or a date)
 */
public class bom extends Entity
{
    /**
     * Act - do whatever the bom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        touchPlayer(bom.class);
        setLocation(getX(), getY() + 6);
        if(getY() >= 586) 
        {
            getWorld().addObject(new explosion(), getX(), getY());
            getWorld().removeObject(this);
            return;
        }
    }
}
