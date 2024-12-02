import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class tutorial2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tutorial2 extends tutorial
{
    arrowLeft arrowLeft;

    /**
     * Constructor for objects of class tutorial2.
     * 
     */
    public tutorial2()
    {
        prepare();
    }
    
    private void prepare()
    {
        Back back = new Back();
        addObject(back,79,39);
        arrowLeft = new arrowLeft();
        addObject(arrowLeft,59,700);
    }
    
    public void act()
    {
        if(Greenfoot.mousePressed(arrowLeft))
        {
            arrowLeft.getImage().scale((int)Math.round(arrowLeft.getImage().getWidth()*0.9),
            (int)Math.round(arrowLeft.getImage().getHeight()*0.9));
        }
        if(Greenfoot.mousePressed(arrowLeft))
        {
            Greenfoot.delay(5);
            Greenfoot.setWorld(new tutorial1());
        }
    }
}
