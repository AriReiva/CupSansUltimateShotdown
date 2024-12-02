import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss4 here.
 * 
 * @version (a version number or a date)
 */
public class Boss4 extends Boss
{
    private GreenfootImage[] BossImages;
    private GreenfootImage[] AttackImages;

    private int imageIndex = 0;
    private int animationDelay = 5;
    private int animationTimer = 0;
    private int attackAnimationTimer = 0;
    private boolean isAttacking = false;
    private int attackDelay = 10;

    int health = 550;
    int maxHealth = 550;

    plat plat;

    public Boss4()
    {
        BossImages = new GreenfootImage[8];
        AttackImages = new GreenfootImage[8];

        for (int i = 0; i < 8; i++)
        {
            BossImages[i] = new GreenfootImage("venom" + (i + 1) + ".png");
            AttackImages[i] = new GreenfootImage("venom_attack" + (i + 1) + ".png");
        }
        
        plat = new plat();
    }

    public void act()
    {
        touchPlayer(Boss4.class);
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

        if(!isAttacking)
        {
            animate();
            checkForAttack();
        }
        else
        {
            attack();
        }
    }

    public void showHealth()
    {
        boss4P world = (boss4P) getWorld();
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
            imageIndex = (imageIndex + 1) % 8;
            setImage(BossImages[imageIndex]);
        }
        else
        {
            animationTimer++;
        }
    }

    public void checkForAttack()
    {
        if(Greenfoot.getRandomNumber(attackDelay) == 0)
        {
            isAttacking = true;
            attackAnimationTimer = 0;
            imageIndex = 0;
        }
    }

    public void attack()
    {
        if(attackAnimationTimer >= animationDelay)
        {
            attackAnimationTimer = 0;
            animationDelay = 5;
            if(imageIndex >= AttackImages.length)
            {
                isAttacking = false;
                imageIndex = 0;
                setImage(BossImages[0]);
            }
            else
            {
                setImage(AttackImages[imageIndex]);
                if (imageIndex == 0) 
                {
                    getWorld().addObject(plat, 100, 532);
                    animationDelay = 60;
                }
                if (imageIndex == 6)
                {
                    getWorld().removeObject(plat);
                }
            }
            imageIndex++;
        }
        else
        {
            attackAnimationTimer++;
        }
    }
}
