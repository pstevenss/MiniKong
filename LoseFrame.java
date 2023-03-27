import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoseFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoseFrame extends World
{

    /**
     * Constructor for objects of class LoseFrame.
     * 
     */
    public LoseFrame()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 540, 1); 
        addObject(new PlayAgainButton(), 275,370); 

    }
}
