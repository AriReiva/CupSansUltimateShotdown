import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss3 here.
 * 
 * @version (a version number or a date)
 */
public class Boss3 extends Boss
{
    private GreenfootImage[] BossImages;
    private GreenfootImage[] BossImagesR;

    private int imageIndex = 0;
    private int animationDelay = 4;
    private int animationTimer = 0;

    int health = 1000;
    int maxHealth = 1000;

    private int velocityX = 5;

    private int bombTimer = 0;
    private int bombDelay = 60;

    public Boss3()
    {
        BossImages = new GreenfootImage[6];
        BossImagesR = new GreenfootImage[6];

        for (int i = 0; i < 6; i++)
        {
            BossImages[i] = new GreenfootImage("robotnik" + (i + 1) + ".png");
        }
        for (int i = 0; i < 6; i++)
        {
            BossImagesR[i] = new GreenfootImage("robotnik" + (i + 1) + ".png");
            BossImagesR[i].mirrorHorizontally();
        }
    }

    public void act()
    {
        touchPlayer(Boss3.class);
        if(isTouching(bone.class) && health <= 1000)
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
            return;
        }
        move(-velocityX);
        if (getX() <= 100 || getX() >= 900)
        {
            velocityX = -velocityX;
        }

        if (velocityX == -5) animate(false);
        if (velocityX == 5) animate(true);

        handleBombAttack();
    }

    public void showHealth()
    {
        boss3P world = (boss3P) getWorld();
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

    public void animate(boolean left)
    {
        if(animationTimer >= animationDelay)
        {
            animationTimer = 0;
            imageIndex = (imageIndex + 1) % 6;
            if (left)
            {
                setImage(BossImages[imageIndex]);
            }
            else
            {
                setImage(BossImagesR[imageIndex]);
            }
        }
        else
        {
            animationTimer++;
        }
    }

    private void handleBombAttack()
    {
        if (bombTimer >= bombDelay)
        {
            bombTimer = 0;
            dropBomb();
            bombDelay = Greenfoot.getRandomNumber(150) + 30;
        }
        else
        {
            bombTimer++;
        }
    }

    private void dropBomb()
    {
        int bombX = getX() + (velocityX > 0 ? -83 : 83);
        int bombY = getY() + 120;
        bom bomb = new bom();
        getWorld().addObject(bomb, bombX, bombY);
    }
}
