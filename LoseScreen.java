import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoseScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoseScreen extends Actor
{
    public LoseScreen(){
        setImage("Try Again.png");
        GreenfootImage image =getImage();
        image.scale(image.getWidth()*4, image.getHeight()*4);
    }
    
    /**
     * Act - do whatever the LoseScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            World myWorld =getWorld();
            MazeLoseScreen currentWorld=(MazeLoseScreen)myWorld;
            currentWorld.restart();
        }
    }
}
