import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KeyQ here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeyQ extends Actor
{
    private int originalWidth;
    private int originalHeight;
    /**
     * Act - do whatever the KeyQ wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

    }

    public KeyQ() {
        // Simpan ukuran asli gambar
        GreenfootImage img = getImage();
        originalWidth = img.getWidth();
        originalHeight = img.getHeight();
    }

    public void resetImage() {
        GreenfootImage img = getImage();
        img.scale(originalWidth, originalHeight);
    }
}
