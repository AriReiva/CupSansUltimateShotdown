import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class level9 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class level10 extends Stage1
{
    protected boolean level12;
    
    /**
     * Constructor for objects of class level9.
     * 
     */
    public level10(int lh, boolean lvl12)
    {
        this.loseHealth = lh;
        level12 = lvl12;
        prepare();
    }

    private void prepare()
    {
        brick brick = new brick();

        if (!level12)
        {
            for(int i = 0; i < getWidth()/brick.getImage().getWidth()+1; i++)
            {
                addObject(new brick(), brick.getImage().getWidth()/2 + i*brick.getImage().getWidth(), 638);
            }

            for(int i = 0; i < 8; i++)
            {
                addObject(new brick(), brick.getImage().getWidth()/2 + i*brick.getImage().getWidth(), 425);
            }

            for(int i = 0; i < 3; i++)
            {
                addObject(new fire(2, 2), 125 + i*350, 514);
                addObject(new fire(1, 4), (300-125)/2 + 125 + i*350, 560);
            }

            super.prepare(0, 570, 10);
        }
        else
        {
            for(int i = 0; i < getWidth()/brick.getImage().getWidth()+1; i++)
            {
                addObject(new brick(), brick.getImage().getWidth()/2 + i*brick.getImage().getWidth(), 638);
            }

            for(int i = 0; i < 8; i++)
            {
                if (i == 5);
                else addObject(new brick(), brick.getImage().getWidth()/2 + i*brick.getImage().getWidth(), 425);
            }

            for(int i = 0; i < 3; i++)
            {
                addObject(new fire(2, 2), 125 + i*350, 514);
                addObject(new fire(1, 4), (300-125)/2 + 125 + i*350, 560);
            }

            super.prepare(999, 570, 11);
        }
    }
    
    public void act()
    {
        if (!level12 && p.getX() >= getWidth() - p.hitboxWidth/2)
        {
            p.nextLevel();
        }
        if (level12 && p.getX() >= getWidth() - p.hitboxWidth/2 && p.getY() <= 393)
        {
            p.nextLevel();
        }
    }
}
