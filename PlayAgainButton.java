import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayAgainButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayAgainButton extends Actor
{
    public PlayAgainButton(){
        setImage("PlayAgainButton.png");
    }
    
    /**
     * Act - do whatever the PlayAgainButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            World myWorld = getWorld();
            LoseFrame currentWorld = (LoseFrame)myWorld;
            currentWorld.restart();
        }
    }
}
