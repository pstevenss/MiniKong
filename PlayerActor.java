import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerActor extends Actor
{
    
    private GreenfootImage[] guy = new GreenfootImage[3];
    private BackGround world = null;
    
    public static enum State {STANDING,WALKING,JUMPING,CLIMBING,CLIMBINGSTANDING,FALLING,DYING,DEAD,NAN}
    
    public int numGemsCollected = 3; //changed variable to: gems collected 
    
    /*Not a state type state*/
    private State playerState = State.NAN;
    static final int width = 18;
    static final int height = 27;
    
    public int footx = -1;
    public int footy = -1;
    private int walkcounter = 0;
    private int fallcount = 0;
    private int chx = 0;
    private int jumpcounter = 0;
    public static final int JUMPTIME = 7;
    
    public static boolean hasMoved = false;
    
    private int dyingcount = 0;
    
    public PlayerActor()
    {
        super();
        guy[0] = new GreenfootImage("Guy1.png");
        guy[1] = new GreenfootImage("Guy2.png");
        guy[2] = new GreenfootImage("Guy3.png");
        numGemsCollected = 3;
        playerState = State.NAN;
        //setFoot(58,363);
        walkcounter = 0;
        fallcount = 0;
        jumpcounter = 0;
    }
    
    public void reset()
    {
        playerState = State.NAN;
        //setFoot(58,363);
        walkcounter = 0;
        fallcount = 0;
        jumpcounter = 0;
    }
    
    public void kill()
    {
        playerState = State.DEAD;
    }
    
    public boolean isAlive()
    {
        if(State.DYING == playerState || State.DEAD == playerState|| State.NAN == playerState)
        {
            return false;
        }
        return true;
    }
    
    public boolean isDead()
    {
        if(State.DEAD == playerState)
        {
            return true;
        }
        return false;
    }
    
    public boolean isDying()
    {
        if(State.DYING == playerState)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Act - do whatever the PlayerActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        //System.out.println("Hi");
        //check for dying and then check for dead
        // An initial state player just constructed
        if(State.NAN == playerState)
        {
            setFoot(footx,footy);
            playerState = State.STANDING;
            walkcounter = 0;
            setImage(guy[0]);
            hasMoved = false;
            setFoot(58,363);
            setRotation(0);
        }
        
        if(State.DEAD == playerState)
        {
            //playerState = State.NAN;
            //Stuck here until an external force makes us live again.
            setRotation(0);
            return;
        }
        
        if(State.DYING == playerState)
        {
            dyingcount++;
            setRotation(45*dyingcount);
            if(dyingcount > 20)
            {
                playerState = State.DEAD;
                dyingcount = 0;
            }
            return;
        }
        
        /*Colission Detection stuff here*/
        
    
        try
        {
            if(isTouching(Gem.class))
            {
                Gem c = (Gem)getOneIntersectingObject(Gem.class);
                world.winTheGame();
            }
        }
        catch(Exception e)
        {
        }
        
        if(State.STANDING == playerState || State.WALKING == playerState || State.JUMPING == playerState)
        {
            /*You can enter Jump/Climb states or , move left/right or stand still*/
            processStandWalkAction();
        }
        else if(State.CLIMBING == playerState || State.CLIMBINGSTANDING == playerState)
        {
            /*You can only go up and down and can only transition to climbing or standing*/
            processClimbingAction();  
        }
        
        if(jumpcounter < 0)
        {
            jumpcounter++;
        }
        
        if(State.JUMPING == playerState)
        {
            if(jumpcounter < 1)
            {
                footy = footy - 11;
                setImage(guy[2]);
            }
            //might have to move this
            jumpcounter++;
            if(jumpcounter > JUMPTIME)
            {
                jumpcounter = -5;
                footy = footy + 11;
                
                int tmpy = world.whereIsFloor(footx,footy);
                
                if(tmpy > -1)
                {
                    playerState = State.STANDING;
                
                    if(chx != 0)
                    {
                        playerState = State.WALKING;
                    }
                }
                else
                {
                    playerState = State.FALLING;
                    fallcount = 0;
                }
            }
        }
        
        if(State.WALKING == playerState || State.JUMPING == playerState)
        {
            footx = footx + chx;
            //do a bunch of checking
            
            if (State.JUMPING != playerState)
            {
                int tmpy = world.whereIsFloor(footx,footy);
                if((tmpy > -1) && (tmpy < (footy + 4)))
                {
                    //Set our foot to new Y coordinate
                    footy = tmpy;
                }
                else if (tmpy != footy)
                {
                    fallcount = 0;
                    playerState = State.FALLING;
                    setImage(guy[1]);
                    setFoot(footx,footy);
                    return;
                }
            }
            setFoot(footx,footy);
        }
        
        if(State.FALLING == playerState)
        {
            fallcount++;
            if(chx < 4)
            {
                //might want to have acceleration
                chx = 4;
            }
            else
            {
                chx++;
            }
            
            footy = footy + chx;
            int tmpy = world.whereIsFloor(footx,footy);
            
            if(footy > 380)
            {
                //reset the player
                playerState = State.DYING;
                dyingcount = 0;
                return;
            }
            
            if((tmpy > -1) && (tmpy < footy+6))
            {
                //check for death impact, but for now we will assume they are ok
                footy = tmpy;
                playerState = State.STANDING;
            }
            
            setFoot(footx,footy);
        }
        
        if(State.CLIMBING == playerState)
        {
            footy = footy + chx;
            
            setFoot(footx,footy);
            
            if(!world.onLadder(footx,footy))
            {
                playerState = State.FALLING;
                footy = footy - 2;
                chx = 4; 
                return;
            }
        }
        
        if(State.STANDING == playerState || State.CLIMBINGSTANDING == playerState)
        {
            setImage(guy[0]);
            walkcounter = 0;
            chx = 0;
            setFoot(footx,footy);
        }
        
        if(State.WALKING == playerState || State.CLIMBING == playerState)
        {
            walkcounter = (walkcounter + 1) % 2;
            setImage(guy[walkcounter]);
        }
       
    }    
    
    public void processStandWalkAction()
    {
        boolean keyAction = false;
        
        if(Greenfoot.isKeyDown("space") && (jumpcounter == 0))
        {
            hasMoved = true;
            playerState = State.JUMPING;
            //System.out.println("JUMPING " + jumpcounter);
        }
       
        if(Greenfoot.isKeyDown("left"))
        {
            hasMoved = true;
            keyAction = true;
            chx = -4;
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            hasMoved = true;
            keyAction = true;
            chx = 4;
        }
        
        if(playerState != State.JUMPING)
        {
            if(world.onLadder(footx,footy))
            {

                if(Greenfoot.isKeyDown("up"))
                {
                    chx = -2;
                    playerState = State.CLIMBING;
                    return;
                }
                
                if(Greenfoot.isKeyDown("down"))
                {
                    chx = 2;
                    playerState = State.CLIMBING;
                    return;
                }
            }
            
            playerState = State.WALKING;
        
            if(!keyAction)
            {
                playerState = State.STANDING;
            }
        }
        
        
    }
    
    public void processClimbingAction()
    {
        boolean keyAction = false;
        
        if(Greenfoot.isKeyDown("up"))
        {
            chx = -2;
            keyAction = true;
        }
                
        if(Greenfoot.isKeyDown("down"))
        {
            chx = 2;
            keyAction = true;
        }
        
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("left"))
        {
            chx = 4;
            playerState = State.FALLING;
            return;
        }
        
        playerState = State.CLIMBING;
        if(!keyAction)
        {
            playerState = State.CLIMBINGSTANDING;
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
