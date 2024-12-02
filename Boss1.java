import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Boss1 extends Boss
{
    private GreenfootImage[] BossImages;
    private GreenfootImage[] BossImagesR;

    private int imageIndex = 0;
    private int animationDelay = 4;
    private int animationTimer = 0;

    int health = 500;
    int maxHealth = 500;

    private int velocityX = 5;

    public Boss1()
    {
        BossImages = new GreenfootImage[10];
        BossImagesR = new GreenfootImage[10];

        for (int i = 0; i < 10; i++)
        {
            BossImages[i] = new GreenfootImage("Sans" + (i + 1) + ".png");
        }
    }

    public void act()
    {
        touchPlayer(Boss1.class);
        if(isTouching(bone.class) && health <= 500)
        {
            removeTouching(bone.class);
            int damage = 0;
            if(Greenfoot.getRandomNumber(50) < 10) damage = 50;
            else damage = 20;

            health -= damage;

            showDamageText(damage);
        }
        showHealth();
        if(health <= 0) 
        {
            health = 0;
            showHealth();
            Greenfoot.setWorld(new gameover(true));
            getWorld().removeObject(this);
        }
        animate();
    }

    public void showHealth()
    {
        boss1P world = (boss1P) getWorld();
        HealthBar healthBar = world.getHealthBar();
        healthBar.updateHealth(health);
    }

    public void showDamageText(int damage)
    {
        DamageText damageText = new DamageText(damage);
        getWorld().addObject(damageText, getX(), getY() - 50);
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

    public int getHealth()
    {
        return health;
    }

    public void animate()
    {
        imageIndex = (imageIndex + 1) % 10;
        setImage(BossImages[imageIndex]);
    }
}
