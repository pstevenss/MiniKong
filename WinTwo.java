import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinTwo  extends Actor
{
    private ConnectBoard prevWorld;
    
    public WinTwo (World previousWorld) {
    prevWorld = (ConnectBoard) previousWorld;
    }
    /**
     * Act - do whatever the WinTwo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if(Greenfoot.mouseClicked(this)) 
       {
           Greenfoot.setWorld(prevWorld.getPreviousWorld());
       }
    }    
}
