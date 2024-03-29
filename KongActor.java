import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KongActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KongActor extends Actor
{
    static final int width = 38;
    static final int height = 32;
    private int footx = 0;
    private int footy = 0;
    
    public static enum State {STANDING,ANGRY,BARREL,NAN}
    
    private GreenfootImage kong[] = new GreenfootImage[5];
    
    BackGround world = null;
    
    private State playerState = State.NAN;
    private int angrycounter = 0;
    private int standingcounter = 0;
    private int barrelcounter = 0;
    
    private int standLimit = -1;
    private int angryLimit = -1;
    
    public KongActor()
    {
        //setFoot(205,76);
        // deleted other kong idles , kept kong 4 
        kong[4] = new GreenfootImage("Kong04.png");
        angrycounter = 0;
        standingcounter = 0;
        barrelcounter = 0;
    }
    
    /**
     * Act - do whatever the KongActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        
        if(State.NAN == playerState)
        {
            setImage(kong[4]);
            playerState = State.BARREL;
            standingcounter = 0;
            barrelcounter = 0;
        }

        if(!world.player.isAlive())
        {
            playerState = State.NAN;
            return;
        }
        
        if(!PlayerActor.hasMoved)
        {
            playerState=State.NAN;
            return;
        }
        
        if(State.ANGRY == playerState)
        {
            angrycounter++;
            if(angrycounter > angryLimit)
            {
                playerState = State.BARREL;
                angrycounter = 0;
                barrelcounter = 0;
            }
            switch(angrycounter % 4)
            {
                case 3:
                case 2:
                    setImage(kong[4]);
                    break;
                default:
                    setImage(kong[4]);
                    break;
            }
            
            return;
        }
        
        if(State.STANDING == playerState)
        {
            standingcounter++;
            if(standingcounter > standLimit)
            {
                int rand = Greenfoot.getRandomNumber(10);
                if(rand > 7)
                {
                    playerState = State.ANGRY;
                }
                else
                {
                    playerState = State.BARREL;
                }
                standingcounter = 0;
                angrycounter = 0;
                barrelcounter = 0;
            }
            standLimit = 15+ Greenfoot.getRandomNumber(30);
            angryLimit = 11 + Greenfoot.getRandomNumber(25);
            
            setImage(kong[4]);
            return;
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
