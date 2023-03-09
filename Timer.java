import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    World myWorld = getWorld();
    public int timerStartingNum = 100;
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        timerStartingNum--;
        myWorld.showText((""+timerStartingNum), 10, 10);

        if (timerStartingNum <= 0){
            //skip turn
            Greenfoot.stop();
        }
    }
}
