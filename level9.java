import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class level9 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class level9 extends Stage1
{

    /**
     * Constructor for objects of class level9.
     * 
     */
    public level9(int lh)
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
            addObject(new fire(2, 7), 125 + i*175, 514);
            // addObject(new fire(1), (300-125)/2 + 125 + i*175, 560);
        }
        
        super.prepare(0, 570, 9);
    }
}
