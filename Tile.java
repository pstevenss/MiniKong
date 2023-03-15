import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tile extends Actor
{
    public boolean guess = false;
    public boolean ship = false;
    public Tile(){
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/3, image.getHeight()/3);
    }
    /**
     * Act - do whatever the Tile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(guessed())
        {
            guess = true;
        }
        if(shipSpace())
        {
            ship = true;
        }
    }
    public boolean guessed()
    {
        Actor actor = getOneObjectAtOffset(0, 0, Miss_Or_Hit.class);
        return actor != null;
    }
    public boolean shipSpace()
    {
        Actor actor = getOneObjectAtOffset(0, 0, Ships.class);
        return actor != null;
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
