import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    private int maxHealth;
    private int health;
    private int barWidth;
    private int barHeight;
    private GreenfootImage background;
    private GreenfootImage healthBar;
    private String bossHealthText;

    public HealthBar(int maxHealth, int health, int barWidth, int barHeight)
    {
        this.maxHealth = maxHealth;
        this.health = health;
        this.barWidth = barWidth;
        this.barHeight = barHeight;
        this.background = new GreenfootImage(barWidth, barHeight);
        this.healthBar = new GreenfootImage(barWidth, barHeight);
        this.bossHealthText = "Boss Health: " + health;
        draw();
    }

    public void updateHealth(int health)
    {
        this.health = health;
        this.bossHealthText = "Boss Health: " + health;
        draw();
    }

    private void draw()
    {
        healthBar.clear();
        healthBar.setColor(Color.RED);
        int healthWidth = (int) ((double) health / maxHealth * (barWidth - 4)); // Adjusted to leave space for the border
        healthBar.fillRect(2, 2, healthWidth, barHeight - 4);

        background.clear();
        background.setColor(Color.BLACK);
        background.drawRect(0, 0, barWidth - 1, barHeight - 1);
        background.drawRect(1, 1, barWidth - 3, barHeight - 3);

        GreenfootImage textImage = new GreenfootImage(bossHealthText, 20, Color.WHITE, new Color(0, 0, 0, 0));
        int textX = (barWidth - textImage.getWidth()) / 2;
        int textY = (barHeight - textImage.getHeight()) / 2;
        background.drawImage(healthBar, 0, 0);
        background.drawImage(textImage, textX, textY);

        setImage(background);
    }
}
