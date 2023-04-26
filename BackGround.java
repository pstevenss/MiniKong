import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class BackGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackGround extends World
{

    public PlayerActor player = null; 
    public KongActor kong = null;
    public Gem greengem = null;
    public Gem greengemcopy1 = null;
    public Gem greengemcopy2 = null;
    private boolean switchToWorld = false;

    public GemCollected gc = null;
    private GreenfootSound backgroundMusic;

    public WinLoseActor winlose = null;

    public static enum State {PLAYING,WIN,LOSE,NAN}

    public State gameState = State.PLAYING; 
    int counter = 0;

    /**
     * Constructor for objects of class BackGround.
     * 
     */
    public BackGround()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(288, 376,1);
        setBackground("Background.jpg");
        // loads background music
        // starts background music 
        backgroundMusic = new GreenfootSound("8d82b5_Donkey_Kong_Country_Theme_Song.mp3");
        backgroundMusic.play();

        player = new PlayerActor();
        addObject(player, 0, 0);
        player.setFoot(58,363);

        kong = new KongActor();
        addObject(kong,0,0);
        kong.setFoot(215,76);

        greengem = new Gem();
        greengemcopy1= new Gem(2);
        greengemcopy2= new Gem(1);

        addObject(greengem,0,0);
        addObject(greengemcopy1,0,0);
        addObject(greengemcopy2,0,0);

        greengem.setFoot(140,27);
        greengemcopy1.setFoot(140,260);
        greengemcopy2.setFoot(140,160);

        gc = new GemCollected();
        addObject(gc,0,0);
        gc.setFoot(20,20);

        //counter = 0;
        gameState = State.NAN;

        winlose = new WinLoseActor();

        //Set spedd to 40%
        Greenfoot.setSpeed(40);
        //Auto Start the Game
        //Greenfoot.start();

    }

    public void resetGame()
    {
        removeObject(player);
        removeObject(kong);
        removeObject(greengem);
        removeObject(greengemcopy1);
        removeObject(greengemcopy2);

        removeObject(gc);

        player = new PlayerActor();
        addObject(player, 0, 0);
        player.setFoot(58,363);

        kong = new KongActor();
        addObject(kong,0,0);
        kong.setFoot(215,76);

        greengem = new Gem();
        greengemcopy1 = new Gem(2);
        greengemcopy2 = new Gem(1);

        addObject(greengem,0,0);
        addObject(greengemcopy1,0,0);
        addObject(greengemcopy2,0,0);
        greengem.setFoot(140,27);
        greengemcopy1.setFoot(140,27);
        greengemcopy2.setFoot(140,27);

        gc = new GemCollected();
        addObject(gc,0,0);
        gc.setFoot(20,20);

        counter = 0;
        gameState = State.PLAYING;

    }

    @Override
    public void act()
    {
        if(gameState == State.NAN)
        {
            //when they hit the play button splash scren disappears
            gameState = State.PLAYING;
        }
        /*We will have modes for this*/
        //System.out.println("Background Act");
        if (gameState == State.PLAYING) {
            // check if the player is touching a Gem
            Gem gem = player.getTouchingGem();

            if (gem != null && gem.getGemNumber() == 2) {
                backgroundMusic.stop();
                Greenfoot.setWorld(new Mini_Battleship_World(this)); 
                removeObject(gem);
            }
            
            if (gem != null && gem.getGemNumber() == 1) {
                backgroundMusic.stop();
                Greenfoot.setWorld(new MazeGame(this)); 
                removeObject(gem);
            }
        
            /*
            if(player.isDead())
            {
                if(player.numGemsCollected > 0) /// add projectcomm pi code to change 
                //all gems collected 
                {
                    player.numGemsCollected--;
                    player.reset();
                }
                else
                {
                    if(player.numGemsCollected >= 3)
                    {
                        gameState = State.WIN;
                        counter = 3;
                    }
                    else
                    {
                        gameState = State.LOSE;
                        counter = 3;
                    }
                }
            }*/
        }

        if(gameState == State.WIN)
        {
            if(counter == 3)
            {
                //addObject(winlose,85,55);
                addObject(winlose,140,200);
                winlose.setWin();
                removeObject(greengem);
                player.kill();
            }
            counter++;
            if(counter > 100)
            {
                removeObject(winlose);
                resetGame();
            }

        }

    }

    /*public void switchWorld() {
    if (player.isGemTouching(Gem.class)) {
    World currentWorld = player.getWorld();
    if (currentWorld instanceof Mini_Battleship_World) {
    Mini_Battleship_World miniWorld = (Mini_Battleship_World) currentWorld;
    List<Gem> gems = miniWorld.getObjects(Gem.class);
    if (!gems.isEmpty()) {
    Gem gem = gems.get(0);
    miniWorld.removeObject(gem);
    }
    } else if (currentWorld instanceof BackGround) {
    BackGround bgWorld = (BackGround) currentWorld;
    List<Gem2> greenGems = bgWorld.getObjects(Gem2.class);
    if (!greenGems.isEmpty()) {
    Gem2 greenGem = greenGems.get(0);
    int gemX = greenGem.getX();
    int gemY = greenGem.getY();
    bgWorld.addObject(player, gemX, gemY);
    bgWorld.removeObject(greenGem); // remove the Gem2 object from the world
    }
    }
    Greenfoot.setWorld(getPreviousWorld());
    } 
    }
     */

    public World getPreviousWorld() {
        return this;
    }

    public void winTheGame()
    {
        gameState = State.WIN;
        counter = 0;
    }

    public boolean onLadder(int x, int y)
    {
        /*Whole Ladders*/
        if(x >= 212 && x < 224 && y >= 316 && y < 359)
        {
            return true;
        }

        if(x >= 44 && x < 56 && y >= 266 && y < 309)
        {
            return true;
        }

        if(x >= 95 && x < 107 && y >= 262 && y < 313)
        {
            return true;
        }

        if(x >= 168 && x < 180 && y >= 212 && y < 263)
        {
            return true;
        }

        if(x >= 52 && x < 64 && y >= 166 && y < 209)
        {
            return true;
        }

        if(x >= 166 && x < 178 && y >= 112 && y < 163)
        {
            return true;
        }

        if(x >= 220 && x < 232 && y >= 116 && y < 159)
        {
            return true;
        }

        if(x >= 38 && x < 50 && y >= 73 && y < 107)
        {
            return true;
        }

        if(x >= 170 && x < 182 && y >= 0 && y < 77)
        {
            return true;
        }

        /*busted ladders*/
        if(x >= 132 && x < 144 && y >= 346 && y < 365)
        {
            return true;
        }

        if(x >= 132 && x < 144 && y >= 310 && y < 334)
        {
            return true;
        }

        if(x >= 220 && x < 232 && y >= 242 && y < 259)
        {
            return true;
        }

        if(x >= 220 && x < 232 && y >= 216 && y < 234)
        {
            return true;
        }

        if(x >= 108 && x < 120 && y >= 196 && y < 213)
        {
            return true;
        }

        if(x >= 108 && x < 120 && y >= 162 && y < 188)
        {
            return true;
        }

        if(x >= 128 && x < 140 && y >= 98 && y < 115)
        {
            return true;
        }

        if(x >= 128 && x < 140 && y >= 76 && y < 90)
        {
            return true;
        }

        return false;
    }

    public int whereIsFloor(int x,int y)
    {

        if(y > 327)/*was 323*/
        {

            if(x < 16)
            {
                return (-1);
            }

            if( x < 145)
            {
                return(364);
            }
            if( x < 170)
            {
                return(362);
            }
            if( x < 198)
            {
                return(360);
            }
            if(x < 226)
            {
                return(358);
            }
            if(x < 254)
            {
                return(356);
            }
            if(x < 271)
            {
                return (354);
            }

            return(-1);
        }

        /*Regular Row Type 1*/
        if(y > 277)
        {
            if(x < 12)
            {
                return (-1);
            }

            if(x<24)
            {
                return(304);
            }

            if(x<50)
            {
                return(306);
            }

            if(x<76)
            {
                return(308);
            }

            if(x<102)
            {
                return(310);
            }

            if(x<128)
            {
                return(312);
            }

            if(x<154)
            {
                return(314);
            }

            if(x<180)
            {
                return(316);
            }

            if(x<206)
            {
                return(318);
            }

            if(x<232)
            {
                return(320);
            }

            if(x<244)
            {
                return(322);
            }

            return(-1);
        }

        /*regular row type 2*/
        if(y > 227)
        {
            if(x < 35)
            {
                return(-1);
            }

            if(x < 48)
            {
                return(272);
            }

            if(x < 74)
            {
                return(270);
            }

            if(x < 100)
            {
                return(268);
            }

            if(x < 126)
            {
                return(266);
            }

            if(x < 152)
            {
                return(264);
            }

            if(x < 176)
            {
                return(262);
            }

            if(x < 204)
            {
                return(260);
            }

            if(x < 232)
            {
                return(258);
            }

            if(x < 256)
            {
                return(256);
            }

            if(x < 268)
            {
                return(254);
            }

            return(-1);
        }

        /*Regular Row Type 1 Copy 1*/
        if(y > 177)
        {
            if(x < 12)
            {
                return (-1);
            }

            if(x<24)
            {
                return(204);
            }

            if(x<50)
            {
                return(206);
            }

            if(x<76)
            {
                return(208);
            }

            if(x<102)
            {
                return(210);
            }

            if(x<128)
            {
                return(212);
            }

            if(x<154)
            {
                return(214);
            }

            if(x<180)
            {
                return(216);
            }

            if(x<206)
            {
                return(218);
            }

            if(x<232)
            {
                return(220);
            }

            if(x<244)
            {
                return(222);
            }

            return(-1);
        }

        /*regular row type 2 Copy 1*/
        if(y > 127)
        {
            if(x < 35)
            {
                return(-1);
            }

            if(x < 48)
            {
                return(172);
            }

            if(x < 74)
            {
                return(170);
            }

            if(x < 100)
            {
                return(168);
            }

            if(x < 126)
            {
                return(166);
            }

            if(x < 152)
            {
                return(164);
            }

            if(x < 176)
            {
                return(162);
            }

            if(x < 204)
            {
                return(160);
            }

            if(x < 232)
            {
                return(158);
            }

            if(x < 256)
            {
                return(156);
            }

            if(x < 268)
            {
                return(154);
            }

            return(-1);
        }

        /*Regular Row Type 1 Copy 2*/
        if(y > 83)
        {
            if(x < 12)
            {
                return (-1);
            }

            if(x<24)
            {
                return(104);
            }

            if(x<50)
            {
                return(106);
            }

            if(x<76)
            {
                return(108);
            }

            if(x<102)
            {
                return(110);
            }

            if(x<128)
            {
                return(112);
            }

            if(x<154)
            {
                return(114);
            }

            if(x<180)
            {
                return(116);
            }

            if(x<206)
            {
                return(118);
            }

            if(x<232)
            {
                return(120);
            }

            if(x<244)
            {
                return(122);
            }

            return(-1);
        }

        if(y > 40)
        {
            //System.out.println("Y > 35 , X is " + x);
            if(x<34)
            {
                //System.out.println(" Fall Off");
                return(-1);
            }

            if(x < 267)
            {
                //System.out.println(" 76");
                return(76);
            }

            return(-1);
        }

        if(y > 0)
        {
            if(x<110)
            {
                return(-1);
            }

            if(x<188)
            {
                return(30);
            }

            return(-1);
        }

        return(-1);
    }
}
