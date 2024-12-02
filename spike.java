import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class spike here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class spike extends Actor
{
    public double rightH, leftH, upH, downH;
    protected int hitboxWidth = 100;
    protected int hitboxHeight = 100;

    public void act()
    {
        setCollision();
        // checkHitbox();
    }

    public void setCollision()
    {
        rightH = getX() + hitboxWidth/2;
        leftH = getX() - hitboxWidth/2;
        upH = getY() - hitboxHeight/2;
        downH = getY() + hitboxHeight/2;
    }
    
    public void touchSpike(player p) {
        if (p.isTouchingWithHitbox(spike.class) && !p.isImmune)
        {
            p.kurangNyawa();
        }
    }
}
