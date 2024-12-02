import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    player p;
    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

    }

    public void touchPlayer(Class<?> cls)
    {
        p = (player) getOneIntersectingObject(player.class);
        if (p != null && !p.isImmune)
        {
            if (cls != null && p.isTouchingWithHitbox(cls))
                p.kurangNyawa();
            // if (Boss1.class != null && p.isTouchingWithHitbox(Boss1.class))
                // p.kurangNyawa();
            // else if (Boss2.class != null && p.isTouchingWithHitbox(Boss2.class))
                // p.kurangNyawa();
            // else if (Boss3.class != null && p.isTouchingWithHitbox(Boss3.class))
                // p.kurangNyawa();
            // else if (Boss4.class != null && p.isTouchingWithHitbox(Boss4.class))
                // p.kurangNyawa();
                
            // if (kurcaci1.class != null && p.isTouchingWithHitbox(kurcaci1.class))
                // p.kurangNyawa();
            // if (meteor.class != null && p.isTouchingWithHitbox(meteor.class))
                // p.kurangNyawa();
            // if (meteorUp.class != null && p.isTouchingWithHitbox(meteorUp.class))
                // p.kurangNyawa();
        }
    }
}
