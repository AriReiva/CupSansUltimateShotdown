import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DamageText extends Actor
{
    private int timer = 30; 
    
    public DamageText(int damage)
    {
        GreenfootImage textImage = new GreenfootImage("-" + damage, 30, Color.RED, new Color(0, 0, 0, 0));
        setImage(textImage);
    }
    
    public void act()
    {
        if (timer > 0) {
            timer--;
            setLocation(getX(), getY() - 1); 
        } else {
            getWorld().removeObject(this);
        }
    }
}
