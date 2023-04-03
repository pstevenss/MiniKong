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
    private boolean sunk = false; //Keeps track if a ship got completed destroyed.
    int numOfHits; //Keeps track of how many times the ship got hit
    
    /**
     * Act - do whatever the Ships wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            
        }
    }
    
    public int getNumberOfHits(){
        return numOfHits;
    }
    
    /*
    public boolean shipsInGrid(){
        boolean status = false;
        for (int shipIndex = 0; shipIndex >= playerShips.length - 1; shipIndex++){
            if ((playerShips[shipIndex].getX() < MIN_X && playerShips[shipIndex].getX() > MAX_X) && 
            (playerShips[shipIndex].getY() < MIN_Y && playerShips[shipIndex].getY() > MAX_Y)){
                status = true;
            }
        }
        return status;
    }
    

    public static boolean shipInGrid(){
        boolean status = false;
        
        if ( 7 > EnemyShip1.getY() && this.getY() < 11 && 
        2 > this.getX() && this.getX() < 7 ){
                status = true;
            }
        return status;
    }
    */
   
    /**
     * Gets the ship status.
     * 
     * @return true, dead; false, still alive.
     */
    public boolean isSunk() {
        return sunk;
    }
    /**
     * Checks if the given coordinates correspond to the transparent cell.
     * 
     * @param x X coordinate to check.
     * @param y Y coordinate to check.
     */
    //public boolean isBlank(int x, int y) {
       // return (x == blankX && y == blankY);
    
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
        if ((size % 2) != 0) {
            // odd size ship: 3, 5
            if (getIntersectingObjects(Hit.class).size() >= size) {
                sunk = true;
            }
        } else {
            // even size ship 2, 4
            if (getRotation() == 0) {
                if (getIntersectingObjects(Hit.class).size() >= size && getOneObjectAtOffset((size / -2), 0, Hit.class) != null) {
                    sunk = true;
                }
            } else {
                if (getIntersectingObjects(Hit.class).size() >= size && getOneObjectAtOffset(0, (size / 2), Hit.class) != null) {
                    sunk = true;
                }
            }
        }
        if (sunk) {
            //Greenfoot.playSound(Need sound for sunk ship);
            changeImage();
            if (icon != null) {
                icon.changeImage();
            }
            Greenfoot.delay(80);
        }
    }
}
