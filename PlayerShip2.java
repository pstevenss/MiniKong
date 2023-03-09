import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class PlayerShip1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerShip2 extends Ships
{
    public static boolean shipSunk;
    private int x;
    private int y;
    private boolean rotated = false;
    public PlayerShip2(){
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
            sink();
        }
    }
    public void place()
    {
        if(Greenfoot.mouseDragged(this))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }
        if(Greenfoot.mouseClicked(this))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(mouse.getButton() == 3)
            {
                setRotation(getRotation()-90);
            }
        }
        if(getRotation() == 90 || getRotation() == 270){
            rotated = true;
        }
    }
    public void sink()
    {
            if(rotated == false)
            {
            List sink1 = getObjectsAtOffset(-1, 0, Hit.class);
            List sink2 = getObjectsAtOffset(0, 0, Hit.class);
            List sink3 = getObjectsAtOffset(1, 0, Hit.class);
            if(sink1.size() > 0 && sink2.size() > 0 && sink3.size() > 0)
            {
                //setImage();
                shipSunk = true;
            }
        }
        if(rotated == true)
        {
           List sink1 = getObjectsAtOffset(0, -1, Hit.class);
            List sink2 = getObjectsAtOffset(0, 0, Hit.class);
            List sink3 = getObjectsAtOffset(0, +1, Hit.class); 
            if(sink1.size() > 0 && sink2.size() > 0 && sink3.size() > 0)
            {
                //setImage();
                shipSunk = true;
            }

        }
    }
}
