import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player_2  extends Actor
{
    boolean followMouse = true;
    
    public void act() 
    {
        if(followMouse == true && Greenfoot.getMouseInfo() != null) 
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            this.setLocation(mouse.getX(), mouse.getY());
        }
        
        if(Greenfoot.mouseClicked(this) && followMouse == true) {
            followMouse = false;
            int x = this.getX();
            ((ConnectBoard) getWorld()).add(x, this);
        }
    }     
}
