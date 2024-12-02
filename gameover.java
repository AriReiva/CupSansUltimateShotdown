import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gameover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameover extends World
{
    boolean win;
    /**
     * Constructor for objects of class gameover.
     * 
     */
    public gameover(boolean win)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 750, 1);
        this.win = win;
        prepare();
    }

    public void prepare()
    {
        PlayAgain playAgain = new PlayAgain();
        addObject(playAgain,500,400);
        Back back = new Back();
        addObject(back,500,577);
        if (win) {
            win winText = new win();
            addObject(winText, 500, 230);
        }
        else {
            lose loseText = new lose();
            addObject(loseText, 500, 230);
        }
    }

    public void act()
    {
        if(Music.sound != null)
        {
            Music.sound.stop();
        }
        if(Music.boss != null)
        {
            Music.boss.stop();
        }
    }
}
