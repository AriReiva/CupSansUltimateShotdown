import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class heart extends Actor
{
    private GreenfootImage heartFull;
    private GreenfootImage heartEmpty;
    private int maxHealth;
    private int currentHealth;
    private int shakeTimer = 0;
    private boolean shaking = false;

    public heart(int health)
    {
        maxHealth = health;
        currentHealth = health;
        
        heartFull = new GreenfootImage("flat_750x_075_f-pad_750x1000_f8f8f8.u5-removebg-preview (1).png");
        heartEmpty = new GreenfootImage("hati_kosong-removebg-preview (1).png");
        
        updateHeart(health);
    }

    public void updateHeart(int health)
    {
        currentHealth = health;
        GreenfootImage display = new GreenfootImage(maxHealth * 32, 32);
        
        for (int i = 0; i < maxHealth; i++) {
            if (i < currentHealth) {
                display.drawImage(heartFull, i * 32, 0);
            } else {
                display.drawImage(heartEmpty, i * 32, 0);
            }
        }
        setImage(display);
    }

    public void shakeHeart(int health)
    {
        shaking = true;
        shakeTimer = 20;
        updateHeart(health);
    }

    public void act()
    {
        if (shaking) {
            shakeTimer--;
            if (shakeTimer > 0) {
                int offsetX = Greenfoot.getRandomNumber(5) - 2;
                int offsetY = Greenfoot.getRandomNumber(5) - 2;
                setLocation(getX() + offsetX, getY() + offsetY);
            } else {
                shaking = false;
                setLocation(150, 40);
            }
        }
    }
}
