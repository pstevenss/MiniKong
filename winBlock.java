import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class winBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class winBlock extends Actor
{
    /**
     * Act - do whatever the winBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(MazeRunner.class)){
            Greenfoot.setWorld(new MazeWinScreen(prevWorld));
        }
    }
    
    public winBlock(BackGround previousWorld){
        setImage("greengem copy.png");
        prevWorld=previousWorld;
    }
    
    private BackGround prevWorld;
}
