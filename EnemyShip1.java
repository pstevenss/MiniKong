import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerShip2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyShip1 extends Ships
{
    public static boolean shipSunk;
    
    public EnemyShip1(){
        setImage("EnemyVert.png");
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/3, image.getHeight()/3);
        //getImage().setTransparency(100);
    }
    
    /**
     * Act - do whatever the EnemyShip1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isSunk()){
            GreenfootImage img = new GreenfootImage("EnemyVertDestroyed.png");
            img.scale(img.getWidth()/3, img.getHeight()/3);
            setImage(img);
        }
    }
}
