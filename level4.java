import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class level4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class level4 extends Stage1
{

    /**
     * Constructor for objects of class level4.
     * 
     */
    public level4(int lh)
    {
        this.loseHealth = lh;
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void prepare()
    {
        addObject(new plat(), 50, 700);
        for(int i = 0; i < 10; i++)
        {
            addObject(new plat(), 50 + i*100, 550);
        }
        super.prepare(30,630,4);
    }
}
