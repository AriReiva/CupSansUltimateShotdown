import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.reflect.Constructor;

public class player extends Actor
{
    private GreenfootImage[] walkingRightImages;
    private GreenfootImage[] walkingLeftImages;
    private GreenfootImage[] standbyRImages;
    private GreenfootImage[] standbyLImages;
    private GreenfootImage[] jumpImages;
    private GreenfootImage[] jumpLImages;
    private GreenfootImage dashImage;
    private GreenfootImage dashLImage;

    private int imageIndex = 0;
    private int animationDelay = 4;
    private int animationTimer = 0;
    private boolean facingRight = true;
    private boolean isMoving = false;

    private bone bone;
    private int cooldownTimer = 0;
    private final int cooldownTime = 90;
    protected double velocity = 0, acceleration = 0.4;
    protected boolean ground = false;

    protected int hitboxWidth = 80;
    protected int hitboxHeight = 110;

    private int health = 3;
    protected boolean isImmune = false;
    private int immuneTimer = 0;
    private final int immuneDuration = 75;

    private heart heart;
    private int loseHealth = 0;

    protected boolean walkOnBrick_up = false;
    protected boolean walkOnBrick_down = false;

    private levelNormal lvl;
    private int level;

    private boolean one = true;

    boolean b1 = false;
    boolean b2 = false;

    private int lowerBound = 0;
    private int upperBound = 0;

    private boolean attack;

    private GreenfootSound music;

    private boolean isDashing = false;
    private int dashCooldownTimer = 0;
    private final int dashCooldownTime = 150;
    private final int dashDuration = 15;
    private final int dashSpeed = 10; 
    private int dashTimer = 0;

    public player(int level, int loseHealth)
    {
        walkingRightImages = new GreenfootImage[16];
        walkingLeftImages = new GreenfootImage[16];
        standbyRImages = new GreenfootImage[7];
        standbyLImages = new GreenfootImage[7];
        jumpImages = new GreenfootImage[3];
        jumpLImages = new GreenfootImage[3];
        dashImage = new GreenfootImage("dash.png");
        dashLImage = new GreenfootImage("dash.png");
        dashLImage.mirrorHorizontally();

        if (level != 0) this.level = level;

        this.loseHealth = loseHealth;

        for (int i = 0; i < 16; i++) {
            walkingRightImages[i] = new GreenfootImage("walk" + (i + 1) + ".png");
            walkingRightImages[i].scale(220, 220);
            walkingLeftImages[i] = new GreenfootImage("walkL" + (i + 1) + ".png");
            walkingLeftImages[i].scale(220, 220);
        }

        for (int i = 0; i < 7; i++) {
            standbyRImages[i] = new GreenfootImage("standbyR" + (i + 1) + ".png");
            standbyRImages[i].scale(220, 220);
            standbyLImages[i] = new GreenfootImage("standbyL" + (i + 1) + ".png");
            standbyLImages[i].scale(220, 220);
        }

        for (int i = 0; i < 3; i++) {
            jumpImages[i] = new GreenfootImage("loncat" + (i + 1) + ".png");
            jumpImages[i].scale(220, 220);
            jumpLImages[i] = new GreenfootImage("loncatL" + (i + 1) + ".png");
            jumpLImages[i].scale(220, 220);
        }

        setImage(walkingRightImages[0]);
    }

    protected void addedToWorld(World world) {
        heart = new heart(health);
        getWorld().addObject(heart, 150, 40);
    }

    protected int getHealth()
    {
        return health;
    }

    private void level()
    {
        if (level < 1 || level > 12) return;

        if(getY() == getWorld().getHeight() - 1)
        {
            kurangNyawa();
            if (!isInWorld()) return;
            velocity = 0;
            setLocation(30,530);
        }

        if (level == 1 || level == 2 || level == 4 || level == 6 || level == 9)
        {
            if (getX() >= getWorld().getWidth()-hitboxWidth/2) 
            {
                nextLevel();
            }
        }
        if (level == 12)
        {
            if (getX() >= getWorld().getWidth()-hitboxWidth/2) 
            {
                Greenfoot.setWorld(new boss1P(loseHealth));
                Music.sound.stop();
            }
        }
    }

    public void act()
    {
        level();
        if (!isInWorld()) return;

        fall();

        updateDash();

        gerak();

        lompatJatuh();

        bone = new bone();

        spike sp = (spike) getObject(spike.class);
        if (sp != null) sp.touchSpike(this);
        if (!isInWorld()) return;

        animate();
        updateCooldown();
        immune();

        int a = loseHealth;
        if(one)
        {
            loseHealth = 0;
            one = false;
            for (int i = 0; i < a; i++)
            {
                kurangNyawa();
            }
        }
    }

    public void gerak()
    {
        isMoving = false;
        int lowerBound = 1000;
        int upperBound = 0;

        if (getWorld() instanceof boss1P) 
        {
            attack = true;
            lowerBound = 596;
            upperBound = 651;
        } 
        else if (getWorld() instanceof boss2P) 
        {
            attack = true;
            lowerBound = 340;
            upperBound = 480;
        }
        else if (getWorld() instanceof boss3P)
        {
            attack = true;
            lowerBound = 553;
            upperBound = 613;
        }
        else if (getWorld() instanceof boss4P)
        {
            attack = true;
            lowerBound = 615;
            upperBound = 685;
        }

        if (Greenfoot.isKeyDown("space") && ground) 
        {
            ground = false;
            velocity = -11;
            isMoving = true;
        }

        if (Greenfoot.isKeyDown("shift") && dashCooldownTimer <= 0 && !isDashing) {
            isDashing = true;
            dashTimer = dashDuration;
        }

        if (Greenfoot.isKeyDown("w") && (walkOnBrick_up || getY() > lowerBound)) { setLocation(getX(), getY() - 5); isMoving = true; }
        if (Greenfoot.isKeyDown("s") && (walkOnBrick_down || getY() < upperBound)) { setLocation(getX(), getY() + 5); isMoving = true; } 

        if (Greenfoot.isKeyDown("a")) { setLocation(getX() - 5, getY()); isMoving = true; facingRight = false; }
        if (Greenfoot.isKeyDown("d")) { setLocation(getX() + 5, getY()); isMoving = true; facingRight = true; }

        if (attack)
            if (Greenfoot.isKeyDown("q")) serang();
    }

    public void fall()
    {
        if (getWorld() instanceof boss1P) 
        {
            attack = true;
            lowerBound = 591;
            upperBound = 656;
        } 
        else if (getWorld() instanceof boss2P) 
        {
            attack = true;
            lowerBound = 335;
            upperBound = 485;
        }
        else if (getWorld() instanceof boss3P)
        {
            attack = true;
            lowerBound = 548;
            upperBound = 618;
        }
        else if (getWorld() instanceof boss4P) 
        {
            attack = true;
            lowerBound = 610;
            upperBound = 690;
        }

        if (getY() >= lowerBound && getY() <= upperBound)
        {
            ground = true;
            velocity = 0;
        }
        else if (isTouchingWithHitbox(plank.class) || isTouchingWithHitbox(brick.class) || isTouchingWithHitbox(plat.class));
        else
        {
            attack = false;
            ground = false;
        }
    }

    public void lompatJatuh()
    {
        setLocation(getX(), (int)(getY() + velocity));
        velocity += acceleration;
    }

    public void kurangNyawa()
    {
        health--;
        heart.shakeHeart(health);
        heart.updateHeart(health);
        loseHealth++;        
        cekMati();
    }

    public void cekMati()
    {
        if (health <= 0) 
        {
            World go = new gameover(false);
            Greenfoot.setWorld(go);
            getWorld().removeObject(this);
        } 
        else 
        {
            isImmune = true;
            immuneTimer = immuneDuration;
        }
    }

    public void serang()
    {
        if (cooldownTimer <= 0) {
            cooldownTimer = cooldownTime;
            getWorld().addObject(bone, getX(), getY());
        }
    }

    public void updateCooldown()
    {
        if (cooldownTimer > 0) {
            cooldownTimer--;
        }
    }

    public boolean isTouchingWithHitbox(Class<?> cls)
    {
        for (int x = -hitboxWidth / 2; x <= hitboxWidth / 2; x++) {
            for (int y = -hitboxHeight / 2; y <= hitboxHeight / 2; y++) {
                if (getOneObjectAtOffset(x, y, cls) != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public Actor getObject(Class<?> cls)
    {
        for (int x = -hitboxWidth / 2; x <= hitboxWidth / 2; x++) {
            for (int y = -hitboxHeight / 2; y <= hitboxHeight / 2; y++) {
                Actor actor = getOneObjectAtOffset(x, y, cls);
                if (actor != null) {
                    return actor;
                }
            }
        }
        return null;
    }

    public void animate()
    {
        if (animationTimer >= animationDelay) {
            animationTimer = 0;
            if (!ground) {
                imageIndex = (imageIndex + 1) % 3;
                if (facingRight) {
                    setImage(jumpImages[imageIndex]);
                } else {
                    setImage(jumpLImages[imageIndex]);
                }
            } else if (isMoving) {
                imageIndex = (imageIndex + 1) % 16;
                if (facingRight) {
                    setImage(walkingRightImages[imageIndex]);
                } else {
                    setImage(walkingLeftImages[imageIndex]);
                }
            } else {
                imageIndex = (imageIndex + 1) % 7;
                if (facingRight) {
                    setImage(standbyRImages[imageIndex]);
                } else {
                    setImage(standbyLImages[imageIndex]);
                }
            }
        } else {
            animationTimer++;
        }
    }

    private void immune() {
        if (isImmune) {
            immuneTimer--;
            if (immuneTimer % 10 < 5) {
                getImage().setTransparency(100); 
            } else {
                getImage().setTransparency(255); 
            }

            if (immuneTimer <= 0) {
                isImmune = false;
                getImage().setTransparency(255);
            }
        } else {
            getImage().setTransparency(255);
        }
    }

    protected void nextLevel()
    {
        Greenfoot.delay(5);
        try
        {
            String className = "level" + (level + 1);

            Class<?> worldClass = Class.forName(className);
            World nextWorld;

            if (level == 9) {
                Constructor<?> constructor = worldClass.getConstructor(int.class, boolean.class);
                nextWorld = (World) constructor.newInstance(loseHealth, false);
            }
            else
            {
                Constructor<?> constructor = worldClass.getConstructor(int.class);
                nextWorld = (World) constructor.newInstance(loseHealth);
            }

            Greenfoot.setWorld(nextWorld);
        }
        catch (Exception e)
        {
            // Handle exception if necessary
        }
    }

    private boolean isInWorld() {
        return getWorld() != null;
    }

    private void updateDash()
    {
        if (isDashing) {
            if (dashTimer > 0) {
                performDash();
                if(facingRight)
                setImage(dashImage);
                else setImage(dashLImage);
                dashTimer--;
            } else {
                endDash();
            }
        } else {
            if (dashCooldownTimer > 0) {
                dashCooldownTimer--;
            }
        }
    }

    private void performDash()
    {
        if (facingRight) {
            setLocation(getX() + dashSpeed, getY());
        } else {
            setLocation(getX() - dashSpeed, getY());
        }
    }

    private void endDash()
    {
        isDashing = false;
        dashCooldownTimer = dashCooldownTime;
        // if (!facingRight) {
            // getImage().mirrorHorizontally();
        // }
    }
}
