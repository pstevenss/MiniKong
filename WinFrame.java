import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinFrame extends World
{

    /**
     * Constructor for objects of class WinFrame.
     * 
     */
    public WinFrame()
    {    
        // Create a new world with 960,540 cells with a cell size of 1x1 pixels.
        super(960,540, 1);
        addObject(new playAgainContinueButton(), 750, 350);
    }
}
