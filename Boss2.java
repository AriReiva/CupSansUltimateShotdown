import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Back here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss2 extends Boss
{
    private GreenfootImage[] BossImages;
    
    private int imageIndex = 0;
    private int animationDelay = 4;
    private int animationTimer = 0;
    
    int health = 650;
    int maxHealth = 650;

    public Boss2()
    {
        BossImages = new GreenfootImage[6];
        
        for (int i = 0; i < 6; i++)
        {
            BossImages[i] = new GreenfootImage("newboss" + (i + 1) + ".png");
        }
    }
    
    /**
     * Act - do whatever the Back wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        touchPlayer(Boss2.class);
        if(isTouching(bone.class) && health <= 650)
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
        boss2P world = (boss2P) getWorld();
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
        if(animationTimer >= animationDelay)
        {
            animationTimer = 0;
            imageIndex = (imageIndex + 1) % 6;
            setImage(BossImages[imageIndex]);
        }
        else
        {
            animationTimer++;
        }
    }
}
