import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoseFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoseFrame extends World
{
    private BackGround prevWorld;
    
    public LoseFrame(BackGround previousWorld)
    {
        this();
        prevWorld = previousWorld;
    }
    
    public void restart(){
        Greenfoot.setWorld(new Mini_Battleship_World(prevWorld));
    }
    
    public World getPrevWorld(){
        return prevWorld;
    }
    
    /**
     * Constructor for objects of class LoseFrame.
     * 
     */
    public LoseFrame()
    {    
        // Create a new world with 960x540 cells with a cell size of 1x1 pixels.
        super(960, 540, 1); 
        setBackground("Winmario (1).png");
        addObject(new PlayAgainButton(), 270, 350);
    }
}
