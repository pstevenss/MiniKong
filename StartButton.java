import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends BattleShipGamePiece
{
    public static boolean gameStart = false;
    
    public StartButton(){
        gameStart = false;
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/2, image.getHeight()/2);
    }
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            gameStart = true;
            getWorld().addObject(new Targeter(),19,6);
            getWorld().removeObject(this);
        }
    }
}
