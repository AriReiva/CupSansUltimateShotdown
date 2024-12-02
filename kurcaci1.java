import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class kurcaci1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class kurcaci1 extends Entity
{
    /**
     * Act - do whatever the kurcaci1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        touchPlayer(kurcaci1.class);
        turn(20);
        setLocation(getX()-5,getY());
        if(getX() == 0) getWorld().removeObject(this);
    }
}
