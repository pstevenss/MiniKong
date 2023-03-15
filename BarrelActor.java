import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BarrelActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BarrelActor extends Actor
{
    private BackGround world = null;
    public int footx=-1;
    public int footy=-1;
    
    private int width = 12;
    private int height = 12;
    
    private GreenfootImage barrel[] = new GreenfootImage[2];
    
    public static enum State {CARRIED,ROLLLEFT,FALLINGRIGHT,FALLINGLEFT,ROLLRIGHT,DYING,NAN}
    
    private State playerState = State.NAN;
    
    private int rotation = 0;
    private int speed=6;
    private int fallingspeed = 4;
    private int ladderspeed = 2;
    private boolean canFallDownLadder = false;
   
    private int hasFallen = 0;
    private int fallLimit = 2;
    
    public BarrelActor()
    {
        barrel[0] = new GreenfootImage("BarrelRolling1.png");
        barrel[1] = new GreenfootImage("DropBarrel.png");
        playerState = State.NAN;
        canFallDownLadder = false;
        hasFallen = 0;
    }
    
    /**
     * Act - do whatever the BarrelActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(world.player.isDying())
        {
            return;
        }
        
        if(!world.player.isAlive())
        {
            world.removeObject(this);
            return;
        }
        
        // Add your action code here.
        if(State.NAN == playerState)
        {
            playerState = State.ROLLLEFT;
            rotation = 0;
            return;
        }
        
        if(State.ROLLLEFT == playerState)
        {
            footx = footx - speed;
            int  tmpy = world.whereIsFloor(footx,footy);
            rotation = (rotation + 330) % 360;
            
            if((tmpy > -1) && (tmpy < (footy+4)))
            {
                //Set our foot to new Y coordinate
                footy = tmpy;
            }
            else if(tmpy != footy)
            {
                playerState = State.FALLINGLEFT;
                //System.out.println("FALLING LEFT!!! " + tmpy + " " + footy);
                setImage(barrel[1]);
                rotation = 0;
            }
            
            if((hasFallen < fallLimit) && canFallDownLadder && 
                world.onLadder(footx,footy + 4) && 
                (Greenfoot.getRandomNumber(10) == 8))
            {
                playerState = State.FALLINGLEFT;
                setImage(barrel[1]);
                rotation = 0;
                hasFallen++;
            }
            
            setRotation(rotation);
            setFoot(footx,footy);
            return;
        }
        
        
        if(State.ROLLRIGHT == playerState)
        {
            canFallDownLadder = true;
            footx = footx + speed;
            int  tmpy = world.whereIsFloor(footx,footy);
            rotation = (rotation + 30) % 360;
            
            if((tmpy > -1) && (tmpy < (footy+4)))
            {
                //Set our foot to new Y coordinate
                footy = tmpy;
            }
            else if(tmpy != footy)
            {
                playerState = State.FALLINGRIGHT;
                setImage(barrel[1]);
                rotation = 0;
            }
            
            if((hasFallen < fallLimit) && world.onLadder(footx,footy + 4) && (Greenfoot.getRandomNumber(10) == 8))
            {
                playerState = State.FALLINGRIGHT;
                setImage(barrel[1]);
                rotation = 0;
                hasFallen++;
            }
            
            setRotation(rotation);
            setFoot(footx,footy);
            return;
        }
        
        if(State.FALLINGRIGHT == playerState|| State.FALLINGLEFT==playerState)
        {
            
            if(world.onLadder(footx,footy + 4))
            {
                footy = footy + ladderspeed;
            }
            else
            {
                footy = footy + fallingspeed;
            }
            int tmpy = world.whereIsFloor(footx,footy);
            
            if(footy > 380)
            {
                world.removeObject(this);
                return;
            }
            
            if((tmpy > -1) && (tmpy < footy+6) && !world.onLadder(footx,footy + 4))
            {
                //check for death impact, but for now we will assume they are ok
                footy = tmpy;
                rotation = 0;
                if(State.FALLINGLEFT == playerState)
                {
                    playerState = State.ROLLRIGHT;
                }
                else
                {
                    playerState = State.ROLLLEFT;
                }
                setImage(barrel[0]);
            }
            
            setFoot(footx,footy);
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
