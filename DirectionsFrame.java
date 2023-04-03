import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DirectionsFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DirectionsFrame extends World
{
    private World previousWorld;
    /**
     * Constructor for objects of class DirectionsFrame.
     * 
     */
    public DirectionsFrame(World previousWorld)
    {    
        // Create a new world with 960x540 cells with a cell size of 1x1 pixels.
        super(960, 540, 1);
        addObject(new ContinueButton(),615,155);
        setPreviousWorld(previousWorld);
    }
    
    public World getPreviousWorld(){
        return previousWorld;
    }
    
    public void setPreviousWorld(World world){
        previousWorld = world;
    }
}
