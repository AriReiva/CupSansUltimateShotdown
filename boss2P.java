import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class level_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class boss2P extends bossPlace
{

    /**
     * Constructor for objects of class level_2.
     * 
     */

    private HealthBar healthBar;

    public boss2P(int lh)
    {    
        PlayAgain.setCurrentLevel(2);
        this.loseHealth = lh;
        Music.newMusic("boss2Song1.mp3");
        Music.boss.playLoop();
        prepare();
    }

    public void act()
    {
        if (Greenfoot.getRandomNumber(300) < 3) 
        {
            addObject(new meteor(), Greenfoot.getRandomNumber(getWidth()), -50);
        }
        if (Greenfoot.getRandomNumber(300) < 3)
        {
            addObject(new meteorUp(), Greenfoot.getRandomNumber(getWidth()), getHeight() + 50);
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        player player = new player(0, loseHealth);
        addObject(player,39,426);
        boss2 = new Boss2();
        addObject(boss2,858,358);

        int healthBarWidth = 500; 
        int healthBarHeight = 20;
        healthBar = new HealthBar(boss2.getMaxHealth(), boss2.getHealth(), healthBarWidth, healthBarHeight);
        int centerX = getWidth() / 2;
        int centerY = healthBarHeight / 2 + 10;
        addObject(healthBar, centerX, centerY);
    }

    public HealthBar getHealthBar()
    {
        return healthBar;
    }
}
