import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tile extends Actor
{
    public Tile(){
        setImage("Wall.jpg");
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/3, image.getHeight()/3);
    }
    /**
     * Act - do whatever the Tile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
    
    /**
     * Checks the adyacent blocks (no diagonals) of previous missed attacks.
     * <p>
     * To be used by the AI for better spots while attacking.
     * <p>
     * Implemented using the protected functionality of getNeighbours.
     * 
     * @return number of missed attacks, maximum 4, minimum 0.
     */
    public int getMissedAttacks(){
        return getNeighbours(1, false, Miss_Or_Hit.class).size();
    }
}
