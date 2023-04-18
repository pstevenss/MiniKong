import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MazeGameDirections here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeGameDirections extends World
{
    private World prevWorld;
    /**
     * Constructor for objects of class MazeGameDirections.
     * 
     */
    public MazeGameDirections(BackGround previousWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        setBackground("Slide3.jpg");
        addObject (new mazeContinueButton2(previousWorld), 650, 550);
        setPreviousWorld(previousWorld);
        
    }
    
    public World getPreviousWorld(){
        return prevWorld;
    }
    
    public void setPreviousWorld(World world){
        prevWorld= world;
    }
    
    
}
