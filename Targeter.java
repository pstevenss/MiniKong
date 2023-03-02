import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Targeter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Targeter extends BattleShipGamePiece
{
    public static boolean playerTurn = true;
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
    }
    
    public void mouseClick()
    {
        if(Greenfoot.mouseClicked(this))
        {   
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(ship())
            {
                if(guessed() == false)
                {
                   getWorld().addObject(new Hit(), mouse.getX(), mouse.getY());
                   playerTurn = false;
                }
                if(guessed() == true)
                {
                }
            }
            else
            {
                if(guessed() == false){
                    getWorld().addObject(new Miss(), mouse.getX(), mouse.getY());
                    playerTurn = false;
                }
                if(guessed() == true)
                {      
        
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
            if(x > 16 && x < 27 && y > 5 && y < 16)
            {
                setLocation(x,y);
            }
        }
    }
    public boolean ship()
    {
        Actor actor = getOneObjectAtOffset(0,0,Ships.class);
        return actor != null;
    }
    public boolean guessed()
    {
        Actor actor = getOneObjectAtOffset(0,0,Miss_Or_Hit.class);
        return actor != null;
    }
    }
