import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playAgainContinueButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playAgainContinueButton extends Actor
{
    public playAgainContinueButton(){
        setImage("continueButton.png");
    }
    /**
     * Act - do whatever the playAgainContinueButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            World myWorld = getWorld();
            WinFrame currentWorld = (WinFrame)myWorld;
            currentWorld.switchWorld();
        }
    }
}
