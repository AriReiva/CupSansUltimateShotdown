import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class level_3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class boss3P extends bossPlace
{

    /**
     * Constructor for objects of class level_3.
     * 
     */
    private HealthBar healthBar;

    public boss3P(int lh)
    {
        PlayAgain.setCurrentLevel(3);
        this.loseHealth = lh;
        Music.newMusic("boss3Song1.mp3");
        Music.boss.playLoop();
        prepare();
    }

    public void prepare()
    {
        boss3 = new Boss3();
        addObject(boss3, 820,200);
        player player = new player(0, loseHealth);
        addObject(player,281,592);

        int healthBarWidth = 500; 
        int healthBarHeight = 20;
        healthBar = new HealthBar(boss3.getMaxHealth(), boss3.getHealth(), healthBarWidth, healthBarHeight);
        int centerX = getWidth() / 2;
        int centerY = healthBarHeight / 2 + 10;
        addObject(healthBar, centerX, centerY);
    }

    public HealthBar getHealthBar()
    {
        return healthBar;
    }
}
