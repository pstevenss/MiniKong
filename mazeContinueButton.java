import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class continueButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mazeContinueButton extends Actor
{
    public mazeContinueButton(){
        setImage("Continue Button 1.png");
    }
    
    /**
     * Act - do whatever the continueButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            World myWorld =getWorld();
            MazeWinScreen currentWorld=(MazeWinScreen)myWorld;
            currentWorld.switchWorld();
        }
    }
}
