import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class level1 extends Stage1
{    
    /**
     * Constructor for objects of class level1.
     * 
     */
    public level1(int lh)
    {
        PlayAgain.setCurrentLevel(1);
        this.loseHealth = lh;
        prepare();
        
        Music._init();
        Music.sound.playLoop();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public void prepare()
    {
        for(int i = 0; i < 3; i++)
        {
            addObject(new plank(), 100 + i*400, 600);
        }
        super.prepare(0,0,1);
    }
    
}
