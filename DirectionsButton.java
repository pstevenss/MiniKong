import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DirectionsButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DirectionsButton extends Actor
{

    public DirectionsButton(){
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/2, image.getHeight()/2);
    }

    /**
     * Act - do whatever the DirectionsButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            World myCurrentWorld = getWorld();
            Greenfoot.setWorld(new DirectionsFrame(myCurrentWorld));
        }
    }
}
