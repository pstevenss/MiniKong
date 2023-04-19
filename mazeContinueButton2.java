import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class continueButton2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mazeContinueButton2 extends Actor
{
    public mazeContinueButton2(BackGround previousWorld){
        setImage("Continue Button 2.png");
        prevWorld=previousWorld;
    }
    /**
     * Act - do whatever the continueButton2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            World myWorld=getWorld();
            
            Greenfoot.setWorld(new MazeGame(prevWorld));
        }
    }
    
    private BackGround prevWorld;
}
