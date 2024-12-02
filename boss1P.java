import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class boss1P extends bossPlace
{
    private HealthBar healthBar;

    public boss1P(int lh)
    {    
        // Create a new world with 1000x750 cells with a cell size of 1x1 pixels.
        PlayAgain.setCurrentLevel(1);
        this.loseHealth = lh;
        Music.newMusic("boss1Song1.mp3");
        Music.boss.playLoop();
        prepare();
    }

    public void act()
    {
        if(Greenfoot.getRandomNumber(300) < 3)
            addObject(new kurcaci1(), 842, Greenfoot.getRandomNumber(110) + 525);
    }

    private void prepare()
    {
        brick brick = new brick();
        for(int i = 0; i < getWidth()/brick.getImage().getWidth()+1; i++)
        {
            addObject(new brick(), brick.getImage().getWidth()/2 + i*brick.getImage().getWidth(), 691);
        }
        
        boss1 = new Boss1();
        addObject(boss1, 841, 534);
        player player = new player(0, loseHealth);
        addObject(new player(0, loseHealth), 73, 610);
        boss1.setLocation(900, 582);

        int healthBarWidth = 400;
        int healthBarHeight = 20;
        healthBar = new HealthBar(boss1.getMaxHealth(), boss1.getHealth(), healthBarWidth, healthBarHeight);
        int centerX = getWidth() / 2;
        int centerY = healthBarHeight / 2 + 10;
        addObject(healthBar, centerX, centerY);
    }

    public HealthBar getHealthBar()
    {
        return healthBar;
    }
}
