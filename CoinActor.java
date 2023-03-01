import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CoinActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinActor extends Actor
{
    private BackGround world = null;
    public int footx=-1;
    public int footy=-1;

    private int width = 12;
    private int height = 12;

    
    public CoinActor()
    {
    }
    
    /**
     * Act - do whatever the CoinActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    @Override
    public void addedToWorld(World world) {
        this.world = (BackGround) world;    
    }
    
    public void setFoot(int x,int y)
    {
        footx  = x;
        //setX(x - (int)(width/2));
        footy = y;
        //setY(y - (int)(height/2));
        setLocation(x,y-(int)(height/2));
    }
}
