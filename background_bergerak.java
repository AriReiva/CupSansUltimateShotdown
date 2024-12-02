import greenfoot.*;

public class background_bergerak extends Actor
{
    private GreenfootImage image;
    private int scrollSpeed;

    public background_bergerak(String imageFile, int scrollSpeed)
    {
        this.scrollSpeed = scrollSpeed;
        image = new GreenfootImage(imageFile);
        setImage(image);
    }

    public void act()
    {
        scroll();
    }

    private void scroll()
    {
        setLocation(getX() - scrollSpeed, getY());
        // if (getX() <= -getImage().getWidth() / 2) {
            // setLocation(getX() + getImage().getWidth(), getY());
        // }
        if (getX() == 0)
        {
            scrollSpeed *= -1;
        }
        
        if (getX() == getWorld().getWidth() - 1)
        {
            scrollSpeed *= -1;
        }
    }
}
