import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class levelNormal extends play
{
    protected player p;
    protected plank plank;
    protected KeyQ q;

    private int level;

    private boolean inLevel1 = true;
    
    protected GreenfootSound lobbyMusic;

    /**
     * Constructor for objects of class level1.
     * 
     */
    public levelNormal()
    {
        // this.level = level;
        // prepare();
        // p = getObjects(player.class).get(0);
    }
    
    @Override
    public void started()
    {
        Music.sound.playLoop();
    }
    
    @Override
    public void stopped()
    {
        Music.sound.stop();
    }

    protected void prepare(int x, int y, int level) 
    {
        p = new player(level, loseHealth);
        if (x == 0 && y == 0) addObject(p, 30, 530);
        else addObject(p, x, y);
        
        // lobbyMusic = new GreenfootSound("play.mp3");
        
        Music._init();
    }
    
    // public static void _init()
    // {
        // if (music != null)
        // {
            // music = new GreenfootSound("play.mp3");
        // }
    // }
    
    // public void toVoid(player p)
    // {
        // if(p.getY() == getHeight()-1)
        // {
            // p.kurangNyawa();
            // p.setLocation(30,530);
        // }
    // }

    // public void nextLevel(player p)
    // {
        // if (p.getX() == getWidth()-1 && p.getY() <= 600) 
        // {
            // Greenfoot.delay(5);
            // int nextLevel = level + 1;
            // try {
                // World nextWorld = (World) Class.forName("level" + nextLevel).getConstructor().newInstance();
                // Greenfoot.setWorld(nextWorld);
            // } catch (Exception e) {
                // System.out.println("No more levels or error loading level: " + e.getMessage());
            // }
        // }
    // }
}
