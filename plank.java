import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class plank extends Actor
{
    /**
     * Act - do whatever the Plank wants to do. This method is called whenever
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
        if (p != null && p.isTouchingWithHitbox(plank.class))
        {
            plank pl = (plank) p.getObject(plank.class);

            pl.setCollision();

            if(pl.upH <= p.getY() + p.hitboxHeight/2 && p.getY() + p.hitboxHeight/2 <= pl.getY())
            {
                p.setLocation(p.getX(), (int) (pl.upH - p.hitboxHeight/2));
                p.ground = true;
                p.velocity = 0;
            }
            else if(pl.downH >= p.getY() - p.hitboxHeight/2 && p.getY() - p.hitboxHeight/2 >= pl.getY())
            {
                p.setLocation(p.getX(), (int) (pl.downH + p.hitboxHeight/2));
                p.velocity = 5;
            }
            else if(pl.leftH <= p.getX() + p.hitboxWidth/2 && pl.getX() >= p.getX() + p.hitboxWidth/2)
            {
                p.setLocation((int) (pl.leftH - p.hitboxWidth/2), p.getY());
                // p.ground = false;
            }
            else if(pl.rightH >= p.getX() - p.hitboxWidth/2 && pl.getX() <= p.getX() + p.hitboxWidth/2)
            {
                p.setLocation((int) (pl.rightH + p.hitboxWidth/2), p.getY());
                // p.ground = false;
            }
        }
    }
}
