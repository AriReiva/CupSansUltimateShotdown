import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class explosion extends Entity
{
    private GreenfootImage[] images;
    private int imageIndex;
    private int actCount;

    public explosion()
    {
        images = new GreenfootImage[6];
        for (int i = 0; i < images.length; i++)
        {
            images[i] = new GreenfootImage("explosion" + (i + 1) + ".png");
        }
        setImage(images[0]);
        imageIndex = 0;
        actCount = 0;
    }

    public void act()
    {
        actCount++;
        if (actCount % 5 == 0)
        {
            imageIndex++;
            if (imageIndex >= images.length)
            {
                getWorld().removeObject(this);
            }
            else
            {
                setImage(images[imageIndex]);
            }
        }
    }
}
