import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playAgainContinueButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playAgainContinueButton extends Actor {
    public playAgainContinueButton() { 
        setImage("continueButton.png");
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            WinFrame myWorld = (WinFrame)getWorld();  
            Greenfoot.setWorld(myWorld.getPreviousWorld());
        } 
    }
}
