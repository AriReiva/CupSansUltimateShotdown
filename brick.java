import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class brick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class brick extends Actor
{
    /**
     * Act - do whatever the brick wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public double rightH, leftH, upH, downH;
    
    public void act()
    {
        setCollision();
        touchBrick();
    }
    
    public void setCollision()
    {
        rightH = getX() + getImage().getWidth()/2;
        leftH = getX() - getImage().getWidth()/2;
        upH = getY() - getImage().getHeight()/2;
        downH = getY() + getImage().getHeight()/2;
    }
    
    public void touchBrick() 
    {
        player p = (player) getOneIntersectingObject(player.class);
        if (p != null && p.isTouchingWithHitbox(brick.class))
        {
            brick b = (brick) p.getObject(brick.class);

            b.setCollision();

            if(b.upH <= p.getY() + p.hitboxHeight/2 && p.getY() + p.hitboxHeight/2 <= b.downH)
            {
                p.ground = true;
                p.velocity = 0;
            }
            else if(b.downH >= p.getY() - p.hitboxHeight/2 && p.getY() - p.hitboxHeight/2 >= b.getY())
            {
                p.setLocation(p.getX(), (int) (b.downH + p.hitboxHeight/2));
                p.velocity = 5;
            }

            p.walkOnBrick_up = false;
            p.walkOnBrick_down = false;
            if (p.getY() + p.hitboxHeight/2 - 5 >= b.upH) 
                p.walkOnBrick_up = true;
            if (p.getY() + p.hitboxHeight/2 + 10 <= b.downH) 
                p.walkOnBrick_down = true;
        }
    }
}
