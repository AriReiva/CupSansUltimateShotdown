import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class fire here.
 * 
 */
public class fire extends Actor
{
    private static final GreenfootImage[] fireAnimate = new GreenfootImage[8];
    private static final GreenfootImage[] fireAnimateD = new GreenfootImage[8];

    private int imageIndex = 0;
    private int animationDelay = 10;
    private int animationTimer = 0;
    
    private int s;

    static {
        for(int i = 0; i < fireAnimate.length; i++)
        {
            fireAnimate[i] = new GreenfootImage("fire" + (i+1) + ".png");
            fireAnimateD[i] = new GreenfootImage("fire" + (i+1) + ".png");
            fireAnimateD[i].mirrorVertically();
        }
    }

    public fire(int s, int idx)
    {
        this.s = s;
        this.imageIndex = idx;
        setImage(side(s, imageIndex));
    }

    /**
     * Act - do whatever the fire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        animate();
        touchFire();
    }

    private void animate()
    {
        if (animationTimer >= animationDelay) {
            animationDelay = 10;
            animationTimer = 0;
            imageIndex = (imageIndex + 1) % 8;
            if(imageIndex == 3 || imageIndex == 7) animationDelay = 75;
            setImage(side(s, imageIndex));
        } else {
            animationTimer++;
        }        
    }
    
    public void touchFire()
    {
        player p = (player) getOneIntersectingObject(player.class);
        
        if (p != null && p.isTouchingWithHitbox(fire.class) && !p.isImmune && imageIndex != 3 && imageIndex != 7) {
            p.kurangNyawa();
        }
    }
    
    private GreenfootImage side(int s, int idx)
    {
        switch(s)
        {
            case 1:
                return fireAnimate[idx];
            case 2:
                return fireAnimateD[idx];
            default:
                return fireAnimate[idx];
        }
    }
}
