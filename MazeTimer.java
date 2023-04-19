import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Calendar;
/**
 * Write a description of class MazeTimer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeTimer extends Actor
{
    private GreenfootImage stopwatchImage;
    private StopWatch stopWatch;
    private BackGround prevWorld;

    public MazeTimer(World previousWorld)
    {
        stopWatch = new StopWatch();
        Font font = new Font(true,false,24);
        stopwatchImage = new GreenfootImage(250,50);
        stopwatchImage.setColor(Color.WHITE);
        stopwatchImage.setFont(font);
        stopwatchImage.drawString(stopWatch.toString(),0,20);
        setImage(stopwatchImage);
        prevWorld= (BackGround)previousWorld; 
        //stopWatch.startStop();
    }
    /**
     * Act - do whatever the MazeTimer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        stopwatchImage.clear();
        stopWatch.startStop();
        stopwatchImage.drawString(stopWatch.toString(),0,20);
        setImage(stopwatchImage);
        
        if (getElapsedTime()>=25 ){
           Greenfoot.setWorld(new MazeLoseScreen(prevWorld));
        }
    }

    public int getElapsedTime(){
        long elapsed = stopWatch.elapsedTime();
        return (int)(elapsed/1000);
    }
}
