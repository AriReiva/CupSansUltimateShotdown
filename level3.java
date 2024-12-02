import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class level3 extends Stage1
{

    /**
     * Constructor for objects of class level3.
     * 
     */
    public level3(int lh)
    {
        this.loseHealth = lh;
        prepare();
    }

    public void prepare()
    {
        for(int i = 0; i < 3; i++)
        {
            addObject(new plank(), 50, 600 - i*183);
        }
        addObject(new plat(), 50, 40);
        super.prepare(0,0,3);
    }

    public void act()
    {
        if (p.getX() <= 120 && p.getX() >= 0 && p.getY() == 0) 
        {
            p.nextLevel();
        }
    }
}
