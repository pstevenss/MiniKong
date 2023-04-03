import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ContinueButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ContinueButton extends Actor
{
    DirectionsFrame directions;
    LoseFrame loseScreen;
    WinFrame winScreen;

    public ContinueButton(){
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/2, image.getHeight()/2);
    }

    public void act(){
        if (Greenfoot.mouseClicked(this)){
            World myWorld = getWorld();
            if (myWorld instanceof DirectionsFrame){
                DirectionsFrame currentWorld = (DirectionsFrame)myWorld;
                
                Greenfoot.setWorld(currentWorld.getPreviousWorld());
            }
        }
    }
}
