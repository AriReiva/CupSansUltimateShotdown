import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * PlayAgain button functionality.
 * 
 */
public class PlayAgain extends Actor
{
    private static int currentLevel = 0;

    /**
     * Act - do whatever the PlayAgain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mousePressed(this))
        {
            getImage().scale((int)Math.round(getImage().getWidth()*0.9),
            (int)Math.round(getImage().getHeight()*0.9));
        }
        if(Greenfoot.mousePressed(this))
        {
            Greenfoot.delay(5);
            restartLevel();
        }
    }

    /**
     * Set the current level where the player is.
     */
    public static void setCurrentLevel(int level)
    {
        currentLevel = level;
    }

    /**
     * Restart the level based on where the player died.
     */
    private void restartLevel()
    {
        switch (currentLevel)
        {
            case 1:
                Greenfoot.setWorld(new level1(0));
                break;
            case 2:
                Greenfoot.setWorld(new boss2P(0));
                break;
            case 3:
                Greenfoot.setWorld(new boss3P(0));
                break;
            case 4:
                Greenfoot.setWorld(new boss4P(0));
                break;
            default:
                Greenfoot.setWorld(new level1(0));
                break;
        }
    }
}
