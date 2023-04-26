import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MazeBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeBlock extends Actor
{
    public MazeBlock(){
        GreenfootImage image = new GreenfootImage("MazeWall2.png");
        setImage(image);
    }
    /**
     * Act - do whatever the MazeBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void moveAndTurn()
    {
        String key = Greenfoot.getKey();
        if(key != null && key.equals("right"))
        {
            setRotation(0);
            move(1);
        } else if(key != null &&  key.equals("left"))
        {
            setRotation(180);
            move(1);
        } else if(key != null && key.equals("up"))
        {
            setRotation(270);
            move(1);
        } else if(key != null && key.equals("down"))
        {
            setRotation(90);
            move(1);
        }
    }
    
}
