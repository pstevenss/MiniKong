import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MazeRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeRunner extends Movers
{
    /**
     * Act - do whatever the MazeRunner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       super.act();
    }
    
    public MazeRunner(){
        setImage("MazeCircle.png");
        GreenfootImage image =getImage();
        image.scale(image.getWidth()/14, image.getHeight()/14);
    }
}
