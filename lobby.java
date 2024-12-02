import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class lobby extends World
{
    private GreenfootSound lobbyMusic;

    private background_bergerak bg1;
    private background_bergerak bg2;

    creditButton creditButton;
    silang s = new silang();
    creditText ctext = new creditText();

    boolean hasCredit = false;

    public lobby()
    {    
        super(1000, 750, 1); 
        lobbyMusic = new GreenfootSound("lobby.mp3");
        prepare();
    }

    private void prepare()
    {
        bg2 = new background_bergerak("game_bg_20_001-uhd.png", 2);
        addObject(bg2, getWidth() + getWidth() / 2, getHeight() / 2);

        Start start = new Start(lobbyMusic);
        addObject(start,500,530);
        Title title = new Title();
        addObject(title,500,300);
        creditButton = new creditButton();
        addObject(creditButton,911,717);
        tutorialButton tutorialButton = new tutorialButton(lobbyMusic);
        addObject(tutorialButton,500,637);
        s = new silang();
        ctext = new creditText();
    }

    public void act()
    {
        moveBackground();
        if (Greenfoot.mousePressed(creditButton) && !hasCredit) {
            addObject(ctext, 500, 400);
            addObject(s, 840, 250);
            hasCredit = true;
        }
        if (Greenfoot.mousePressed(s) && hasCredit) {
            removeObject(ctext);
            removeObject(s);
            hasCredit = false;
        }
    }

    private void moveBackground()
    {
        bg2.act();
    }

    @Override
    public void started()
    {
        lobbyMusic.playLoop();
    }

    @Override
    public void stopped()
    {
        lobbyMusic.stop();
    }
}
