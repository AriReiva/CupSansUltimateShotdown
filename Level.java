import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends World
{

    private GreenfootSound lobbyMusic;
    /**
     * Constructor for objects of class Level.
     * 
     */
    public Level()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 750, 1);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        button_level_2 button_level_2 = new button_level_2();
        addObject(button_level_2,768,208);
        button_level_1 button_level_1 = new button_level_1();
        addObject(button_level_1,257,210);
        button_level_3 button_level_3 = new button_level_3();
        addObject(button_level_3,256,608);
        select_level select_level = new select_level();
        addObject(select_level,513,62);
        button_level_4 button_level_4 = new button_level_4();
        addObject(button_level_4,769,605);
        demo demo = new demo();
        addObject(demo,257,539);
        demo demo2 = new demo();
        addObject(demo2,769,537);
        demo demo3 = new demo();
        addObject(demo3,768,140);
    }
}
