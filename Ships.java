import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ships here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ships extends Actor
{
    private Ships icon = null; // ship image on botton of the screen    
    protected int size; // number of cells used for display ship
    //private boolean sunk = false; //Keeps track if a ship got completed destroyed.
    private int x; // previous location of ship
    private int y; // previous location of ship
    private int numberOfHits; // tracks how many hits
    private int maxNumberOfHits;
    /**
     * X coordinate of the transparent cell. The value of -1 means not used, no transparent cell.
     * <p>
     * The transparent cell is the last cell of the object, horizontally; top cell of the object, vertically.
     */
    protected int blankX = -1; // transparent cell for even sized ships
    /**
     * Y coordinate of the transparent cell. The value of -1 means not used, no transparent cell.
     * <p>
     * The transparent cell is the last cell of the object, horizontally; top cell of the object, vertically.
     */
    protected int blankY = -1; // transparent cell for even sized ships

    public Ships(){
        x = -1;
        y = -1;
        numberOfHits = 0;
        maxNumberOfHits = 3;
    }

    /**
     * Act - do whatever the Ships wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }

    /**
     * Gets the ship status.
     * 
     * @return true, dead; false, still alive.
     */
    public boolean isSunk() {
        return numberOfHits == maxNumberOfHits;
    }

    /**
     * Changes the image to show a destroyed ship.
     */
    private void changeImage() {
        //setImage("sunkship"+size+".png");
    }

    /**
     * Updates the status of the ship, Dead or alive.
     * <p>
     * Looks for Hit objects on top of the ship. If every cell of the ship
     * (not counting the transparent cell) has a Hit, the ship is sunk. If not, remains alive.
     * <p>
     * When sunk, plays a sound, changes the image, changes the icon image and puts
     * some delay to hear the sound.
     */
    public void sink()
    {
        //if (getIntersectingObjects(Hit.class).size() >= size){
        //    sunk = true;
        //    }

        //Greenfoot.playSound(Need sound for sunk ship);
        //changeImage(need img);
        if (icon != null) {
            icon.changeImage();
        }
        Greenfoot.delay(80);

    }
    public int getNumberOfHits(){
        return numberOfHits;
    }

    public void hit() {
        numberOfHits++;
        if (isSunk()){
            sink();
        }
    }

    public boolean isPlaced(){
        Mini_Battleship_World myWorld = (Mini_Battleship_World)getWorld();
        return false;
    }
    /**
     * Updates the status of the ship, Dead or alive.
     * <p>
     * Looks for Hit objects on top of the ship. If every cell of the ship
     * (not counting the transparent cell) has a Hit, the ship is sunk. If not, remains alive.
     * <p>
     * When sunk, plays a sound, changes the image, changes the icon image and puts
     * some delay to hear the sound.
     */
    /*
    public boolean sinkShip(Ships x)
    {
    if (x.isTouching(Hit.class)){
    return true;
    } else {
    return false;
    }
    }
     */

    /**
     * Update the position maintained by the object to the actual position, and
     * calculates the position of the transparent cell.
     * 
     * @see #blankX
     * @see #blankY
     */
    /*
    private void updatePosition() {

    x = getX();
    y = getY();
    if ((size % 2) == 0) {
    if (getRotation() == 0) {
    blankX = getX() + (size / 2);
    blankY = getY();
    } else {
    blankX = getX();
    blankY = getY() - (size / 2);

    }
    }
    }
     */
}
