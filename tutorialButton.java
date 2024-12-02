import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class tutorialButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tutorialButton extends Actor
{
    private GreenfootSound lobbyMusic;
    
    public tutorialButton(GreenfootSound music)
    {
        lobbyMusic = music;
    }
    
    /**
     * Act - do whatever the tutorialButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mousePressed(this))
        {
            getImage().scale((int)Math.round(getImage().getWidth()*0.9),
            (int)Math.round(getImage().getHeight()*0.9));
        }
        if(Greenfoot.mousePressed(this))
        {
            Greenfoot.delay(5);
            lobbyMusic.stop();
            Greenfoot.setWorld(new tutorial1());
        }
    }
}
