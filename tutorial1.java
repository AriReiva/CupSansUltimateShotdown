import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class tutorial1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tutorial1 extends tutorial
{
    arrowRight arrowRight;
    
    /**
     * Constructor for objects of class tutorial1.
     * 
     */
    public tutorial1()
    {
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Back back = new Back();
        addObject(back,79,39);
        arrowRight = new arrowRight();
        addObject(arrowRight,941,700);
    }

    public void act() 
    {
        if(Greenfoot.mousePressed(arrowRight))
        {
            arrowRight.getImage().scale((int)Math.round(arrowRight.getImage().getWidth()*0.9),
            (int)Math.round(arrowRight.getImage().getHeight()*0.9));
        }
        if(Greenfoot.mousePressed(arrowRight))
        {
            Greenfoot.delay(5);
            Greenfoot.setWorld(new tutorial2());
        }
    }
}
