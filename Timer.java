import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Calendar;

/**
 * Write a description of class StopWatch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    private GreenfootImage timerImage;
    private int countdown = 200;

    public Timer()
    {
        Font font = new Font(true,false,24);
        timerImage = new GreenfootImage(250,50);
        timerImage.setColor(Color.RED);
        timerImage.setFont(font);
        //timerImage.drawString("" + countdown, 13, 25);
        //timerImage.scale(timerImage.getWidth()*2, timerImage.getHeight()*2);
        setImage(timerImage);
    }

    public void displayTime(){
        World myWorld = getWorld();
        Mini_Battleship_World currentWorld = (Mini_Battleship_World)myWorld;
        currentWorld.showText("" + countdown, 13, 8);
    }
    
    /**
     * Act - do whatever the StopWatch wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Targeter.playerTurn && StartButton.gameStart){
            displayTime();
            countdown--;
            if (countdown <= 0){
                Targeter.playerTurn = false;
                Mini_Battleship_World.enemyTurn = true;
                countdown = 200;
            }
        } 
    }
}
