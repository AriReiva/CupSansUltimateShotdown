import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class level11 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class level11 extends Stage1
{

    /**
     * Constructor for objects of class level11.
     * 
     */
    public level11(int lh)
    {
        this.loseHealth = lh;
        prepare();
    }

    private void prepare()
    {
        brick brick = new brick();
        for(int i = 0; i < getWidth()/brick.getImage().getWidth()+1; i++)
        {
            addObject(new brick(), brick.getImage().getWidth()/2 + i*brick.getImage().getWidth(), 638);
        }

        for(int i = 0; i < 8; i++)
        {
            addObject(new brick(), brick.getImage().getWidth()/2 + i*brick.getImage().getWidth(), 425);
        }

        for(int i = 0; i < 5; i++)
        {
            addObject(new fire(2, 2), 125 + i*175, 514);
            addObject(new fire(1, 4), (300-125)/2 + 125 + i*175, 560);
        }

        super.prepare(10, 570, 11);
    }

    public void act()
    {        
        if (p.getX() >= getWidth() - p.hitboxWidth/2) 
        {
            p.setLocation(0, 570);
        }
        
        if (p.getX() == 0)
        {
            level10 lvl10 = new level10(loseHealth, true);
            Greenfoot.setWorld(lvl10);
        }
    }
}
