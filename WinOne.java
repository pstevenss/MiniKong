import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinOne  extends Actor
{
    private ConnectBoard prevWorld;
    
    public WinOne(World previousWorld) {
    prevWorld = (ConnectBoard)previousWorld;
    }
    /**
     * Act - do whatever the WinOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(prevWorld.getPreviousWorld());
        }
    }    
}
