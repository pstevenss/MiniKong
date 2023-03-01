import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GuysCounterActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuysCounterActor extends Actor
{
     private BackGround world = null;
    public int footx=-1;
    public int footy=-1;

    private int width = 22;
    private int height = 14;
    
    private GreenfootImage guys[] = new GreenfootImage[4];
    
    public GuysCounterActor()
    {
        guys[0] = new GreenfootImage("guys0.png");
        guys[1] = new GreenfootImage("guys1.png");
        guys[2] = new GreenfootImage("guys2.png");
        guys[3] = new GreenfootImage("guys3.png");
    }
    /**
     * Act - do whatever the GuysCounterActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        switch(world.player.numLives)
        {
            case 3:
                setImage(guys[3]);
                break;
            case 2:
                setImage(guys[2]);
                break;
            case 1:
                setImage(guys[1]);
                break;
            default:
                setImage(guys[0]);
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