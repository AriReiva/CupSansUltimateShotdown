import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class level2 extends Stage1
{

    /**
     * Constructor for objects of class level2.
     * 
     */
    public level2(int lh)
    {
        this.loseHealth = lh;
        prepare();
    }
    
    public void prepare()
    {
        for(int i = 0; i < 3; i++)
        {
            addObject(new plank(), 100 + i*500, 600);
        }
        super.prepare(0,0,2);
    }
}
