import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinOne  extends Actor
{
    private BackGround prevWorld;
    
    public WinOne(World previousWorld) {
    prevWorld = (BackGround)previousWorld;
    }
    /**
     * Act - do whatever the WinOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            ConnectBoard myWorld = (ConnectBoard)getWorld();  
            Greenfoot.setWorld(prevWorld.getPreviousWorld());
        }
    }    
    public WinOne(){
        setImage("1win.png");
    }
}
