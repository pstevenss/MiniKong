import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GemCollected here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GemCollected extends Actor
{
     private BackGround world = null;
    public int footx=-1;
    public int footy=-1;

    private int width = 22;
    private int height = 14;
    
    private GreenfootImage greengem[] = new GreenfootImage[4];
    
    public GemCollected()
    {
        greengem[0] = new GreenfootImage("greengem.png");
        greengem[1] = new GreenfootImage("greengem.png");
        greengem[2] = new GreenfootImage("greengem2.png");
        greengem[3] = new GreenfootImage("greengem3.png");
    }
    /**
     * Act - do whatever the GemsCollected wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        switch(world.player.numGemsCollected)
        {
            case 3:
                setImage(greengem[3]);
                break;
            case 2:
                setImage(greengem[2]);
                break;
            case 1:
                setImage(greengem[1]);
                break;
            default:
                setImage(greengem[0]);
                break;
        }
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