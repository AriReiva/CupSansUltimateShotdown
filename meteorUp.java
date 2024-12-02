import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Back here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class meteorUp extends Entity
{
    /**
     * Act - do whatever the Back wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int animationDelay = 4;
    private int animationTimer = 0;
    private int frameIndex = 0;

    public void act() 
    {
        touchPlayer(meteorUp.class);
        setLocation(getX(), getY() - 7);
        if(getY() == 0) 
        {
            getWorld().removeObject(this);
            return;
        }
        animate();
    }

    private void animate() 
    {
        if (animationTimer >= animationDelay) 
        {
            frameIndex = (frameIndex + 1) % 6;
            setImage("meteorUp" + (frameIndex + 1) + ".png");
            animationTimer = 0;
        } 
        else 
        {
            animationTimer++;
        }
    }
}
