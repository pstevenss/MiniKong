import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MazeLoseScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeLoseScreen extends World
{
    private BackGround prevWorld;
    
    public MazeLoseScreen (BackGround previousWorld)
    {
        this();
        prevWorld= previousWorld;
    }
    
    public void restart(){
        Greenfoot.setWorld(new MazeGame(prevWorld));
    }
    
    public BackGround getPrevWorld(){
        return prevWorld;
    }
    /**
     * Constructor for objects of class MazeLoseScreen.
     * 
     */
    public MazeLoseScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        setBackground("Slide4.jpg");
        
        addObject(new LoseScreen(), 550, 650);
    }
}
