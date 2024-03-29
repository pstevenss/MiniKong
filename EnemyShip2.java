import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyShip2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyShip2 extends Ships
{
    public static boolean shipSunk;

    public EnemyShip2(){
        setImage("Longpiece.png");
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/2, image.getHeight()/2);
        // getImage().setTransparency(100);
    }

    /**
     * Act - do whatever the EnemyShip2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isSunk()){
            GreenfootImage img = new GreenfootImage("LongEnemyDestoyed.png");
            //Greenfoot.playSound("[Super Mario 64] Mario - YIPPEE ! Sound Effect [Free Ringtone Download].mp3");
            img.scale(img.getWidth()/2, img.getHeight()/2);
            setImage(img);
        }
    }
}
