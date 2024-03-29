import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Targeter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Targeter extends Actor
{
    public static boolean playerTurn = true; //Determines if it's the player's turn or not
    public Targeter()
    {
        setImage("targeter.png");
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/95, image.getHeight()/95);
    }
    
    /**
     * Act - do whatever the Targeter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(playerTurn){
            mouseMove();
            mouseClick();
        }
        List<Ships> shipList = getObjectsAtOffset(0,0,Ships.class);

        //System.out.println(shipList.isEmpty());
    }
    
    public void mouseClick()
    {
        if(Greenfoot.mouseClicked(this))
        {   
            MouseInfo mouse = Greenfoot.getMouseInfo();
            List<Ships> shipList = getObjectsAtOffset(0,0,Ships.class);
            if(!(shipList.isEmpty()))
            {
                if(!(isAlreadyGuessed()))
                {
                   getWorld().addObject(new Hit(), mouse.getX(), mouse.getY());
                   Greenfoot.playSound("Studio_Project (1).mp3");
                   Greenfoot.delay(20);
                   for(Ships ship: shipList){
                       ship.hit();
                    }
                   playerTurn = false;
                }
            }
            else if (shipList.isEmpty())
            {
                if(!(isAlreadyGuessed())){
                    getWorld().addObject(new Miss(), mouse.getX(), mouse.getY());
                    Greenfoot.playSound("Mario Oh No!.mp3");
                    Greenfoot.delay(20);
                    playerTurn = false;
                }
            }
        }
    }
    
    public void mouseMove()
    {
        if(Greenfoot.mouseMoved(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            int x = mouse.getX();
            int y = mouse.getY();
            if(x > 18 && x < 25 && y > 5 && y < 12)
            {
                setLocation(x,y);
            }
        }
    }
    
    public boolean isShip()
    {
        Actor actor = getOneObjectAtOffset(0,0,Ships.class);
        return actor != null;
    }
    public boolean isAlreadyGuessed()
    {
        Actor actor = getOneObjectAtOffset(0,0,Miss_Or_Hit.class);
        return actor != null;
    }
    }
