import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MazeWinScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeWinScreen extends World
{

    /**
     * Constructor for objects of class MazeWinScreen.
     * 
     */
    public MazeWinScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1220, 800, 1);
        setBackground("Slide1.jpg");
        addObject (new mazeContinueButton(), 750, 650);
    }
    
    private BackGround prevWorld;
    
    public MazeWinScreen(BackGround previousWorld2)
    {
        this();
        prevWorld = previousWorld2;
    }
    
    public World getPreviousWorld(){
        return prevWorld;
    }
    
    
}
