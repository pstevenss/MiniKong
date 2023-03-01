import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinLoseActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinLoseActor extends Actor
{
    
    private GreenfootImage msg[] = new GreenfootImage[2];
    
    public WinLoseActor()
    {
        msg[0] = new GreenfootImage("youwin.png");
        msg[1] = new GreenfootImage("youlose.png");
    }
    
    public void setWin()
    {
        setImage(msg[0]);
    }
    
    public void setLose()
    {
        setImage(msg[1]);
    }
    
    /**
     * Act - do whatever the WinLoseActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
