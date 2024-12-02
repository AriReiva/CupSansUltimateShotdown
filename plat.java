import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class plat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class plat extends Actor
{
    /**
     * Act - do whatever the plat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public double rightH, leftH, upH, downH;

    public void act()
    {
        setCollision();
        touchPlank();
    }

    public void setCollision()
    {
        rightH = getX() + getImage().getWidth()/2;
        leftH = getX() - getImage().getWidth()/2;
        upH = getY() - getImage().getHeight()/2;
        downH = getY() + getImage().getHeight()/2;
    }

    public void touchPlank() 
    {
        player p = (player) getOneIntersectingObject(player.class);
        if (p != null && p.isTouchingWithHitbox(plat.class))
        {
            plat pt = (plat) p.getObject(plat.class);

            pt.setCollision();

            if(pt.upH <= p.getY() + p.hitboxHeight/2 && p.getY() + p.hitboxHeight/2 <= pt.downH)
            {
                p.setLocation(p.getX(), (int) (pt.upH - p.hitboxHeight/2));
                p.ground = true;
                p.velocity = 0;
            }
        }
    }
}
