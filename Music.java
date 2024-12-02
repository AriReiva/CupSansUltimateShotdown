import greenfoot.*;

/**
 * Write a description of class Music here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Music  
{
    public static GreenfootSound sound;
    public static GreenfootSound boss;

    public static void _init()
    {
        if(boss != null) boss.stop();
        if (Music.sound == null)
        {
            sound = new GreenfootSound("play.mp3");
        }
    }

    public static void newMusic(String music)
    {
        if(boss != null) boss.stop();
        if(sound != null) sound.stop();
        boss = new GreenfootSound(music);
    }

}
