import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Targeter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Targeter extends Actor
{
    public static boolean playerTurn = true;
    public Targeter()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/50, image.getHeight()/50);
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
    }
    
    public void mouseClick()
    {
        if(Greenfoot.mouseClicked(this))
        {   
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(isShip())
            {
                if(isAlreadyGuessed() == false)
                {
                   getWorld().addObject(new Hit(), mouse.getX(), mouse.getY());
                   playerTurn = false;
                }
            }
            else
            {
                if(isAlreadyGuessed() == false){
                    getWorld().addObject(new Miss(), mouse.getX(), mouse.getY());
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
