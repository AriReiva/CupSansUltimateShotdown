import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class level5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class level5 extends Stage1
{

    /**
     * Constructor for objects of class level5.
     * 
     */
    public level5(int lh)
    {
        this.loseHealth = lh;
        prepare();
    }

    private void prepare()
    {
        for(int i = 0; i < 8; i++)
        {
            addObject(new plat(), 50 + i*100, 400);
        }
        super.prepare(0,340,5);
    }

    public void act()
    {
        if (p.getX() >= 750)
        {
            p.nextLevel();
        }
    }
}
