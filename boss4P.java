import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class level_4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class boss4P extends bossPlace
{

    /**
     * Constructor for objects of class level_4.
     * 
     */
    private HealthBar healthBar;
    
    public boss4P(int lh)
    {
        PlayAgain.setCurrentLevel(4);
        this.loseHealth = lh;
        Music.newMusic("boss4Song1.mp3");
        Music.boss.playLoop();
        prepare();
    }
    
    public void prepare()
    {
        player player = new player(0, loseHealth);
        addObject(player,102,640);
        boss4 = new Boss4();
        addObject(boss4,815,582);

        int healthBarWidth = 500; 
        int healthBarHeight = 20;
        healthBar = new HealthBar(boss4.getMaxHealth(), boss4.getHealth(), healthBarWidth, healthBarHeight);
        int centerX = getWidth() / 2;
        int centerY = healthBarHeight / 2 + 10;
        addObject(healthBar, centerX, centerY);
        boss4.setLocation(787,590);
    }
    
    public HealthBar getHealthBar()
    {
        return healthBar;
    }
}
