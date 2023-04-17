import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ships here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ships extends Actor
{
    protected int shipHealth; // Health of ship (How many times it can get hit)
    int numOfHits; //Keeps track of how many times the ship got hit
    
    public Ships(){
        numOfHits = 0;
        shipHealth = 3;
    }
    
    /*
    public Ships(int shipHealth){
        numOfHits = 0;
        this.shipHealth = shipHealth;
    }
    */
    
    /**
     * Act - do whatever the Ships wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
    
    public int getNumberOfHits(){
        return numOfHits;
    }
    
    public boolean isSunk(){
        return numOfHits == shipHealth;
    }
    
    public void hit(){
        numOfHits++;
    }
}
