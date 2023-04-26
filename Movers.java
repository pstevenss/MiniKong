import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Movers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Movers extends Actor
{
    /**
     * Act - do whatever the Movers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
         slideAround();
    }
    public void slideAround()
    {
        int x= getX();
        int y= getY();
        if(Greenfoot.isKeyDown("right"))
        { 
            moveTo(x+1, y);
        } 
        else if(Greenfoot.isKeyDown("left"))
        {
            moveTo(x-1, y);
        } 
        else if(Greenfoot.isKeyDown("up"))
        {
            moveTo(x, y-1);
        } 
        else if(Greenfoot.isKeyDown("down"))
        {
           moveTo(x, y+1);
        }
        
    }
    
    public boolean hitWalls(int x, int y)
    {
        int dx = x - getX();
        int dy = y - getY();
        return getOneObjectAtOffset(dx, dy, MazeBlock.class) != null;
    }
    
    public void moveTo(int x, int y){
        if (! hitWalls(x, y))
        {
            setLocation(x, y);
        }
    }
}