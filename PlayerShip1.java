import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class PlayerShip1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerShip1 extends Ships
{
    public static boolean shipSunk;
    private int x;
    private int y;
    public PlayerShip1(){
        setImage("PlayerHorizon.png");
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/3, image.getHeight()/3);
    }
    /**
     * Act - do whatever the PlayerShip1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(StartButton.gameStart == false)
        {
            place();
        }
        if (isSunk()){
            GreenfootImage img = new GreenfootImage("PlayerHorizonDestroyed.png");
            img.scale(img.getWidth()/3, img.getHeight()/3);
            setImage(img);
            
        }
    }
    
    public void place()
    {
        if(Greenfoot.mouseDragged(this))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }
    }
}
