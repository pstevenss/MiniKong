import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Mini_Battleship_World here.
 * 
 * @author Justin Tolbert (Thanks to brian5021 and MIN 
 * Manuel Alejandro Valdes-Marrero for reference code)
 * @version 1.0
 */
public class Mini_Battleship_World extends World
{
    private final int MIN_X = 2; // Minimum X coordinate of the player grid
    private final int MAX_X = 7; // Maximum X coordinate of the player grid
    private final int MIN_X_COMPUTER = 20; // Minimum X coordinate of the computer grid
    private final int MAX_X_COMPUTER = 24; // Maximum X coordinate of the computer grid
    private final int MIN_Y = 6; // Minimum Y coordinate of both grids
    private final int MAX_Y = 11; // Maximum Y coordinate of both gridspublic boolean hit = false; //Determines if a ship is hit or not.
    public static boolean enemyTurn = false; //Determines if it's the enemy's turn.
    public static boolean hit = false; //Determines if a hit was guessed on the previous turn
    private static int hitX; //Keeps track of the last guess on the x coord.
    private static int hitY; //Keeps track of the last guess on the y coord.
    private int initialHitX; //Keeps track of the current x guess.
    private int initialHitY; //Keeps track of the current y guess.
    private int x; //X Location of new guess.
    private int y; //Y Location of new guess.
    private int streak; //Number of hits in a row.
    private int direction; //Direction of attack in a streak.
    GreenfootSound backgroundMusic = new GreenfootSound("Gelato Beach - Super Mario Sunshine.mp3"); //Background Music
    GreenfootSound winMusic = new GreenfootSound("winFrameSong.mp3");
    GreenfootSound loseMusic = new GreenfootSound ("loseFrameMusic.mp3");
    private int switching; //Number of times direction has changed during a streak.
    private Ships[] playerShips; // Player ships
    private Ships[] computerShips; // Enemy ships
    public static boolean isInGrid = false; //Sees if a ship is in the player grid
    private BackGround prevWorld;
    private int countdown = 200;
    /**
     * Constructor for objects of class Mini_Battleship_World.
     * 
     */
    public Mini_Battleship_World(BackGround previousWorld)
    {    
        // Create a new world with 27x18 cells with a cell size of 20x20 pixels.
        super(27, 18, 20);
        prevWorld = previousWorld;
        setBackground("battleshipBackground.png");
        setup();
    }
    
    private void showTime(){
        showText("" + countdown, 13, 5);
        
    }
    
    public void act()
    {
        countdown--;
        Greenfoot.setSpeed(50);
        backgroundMusic.playLoop();
        if(Targeter.playerTurn == false)
        {
            enemyTurn = true;
        }

        if(enemyTurn)
        {
            guess();
            endGame();
        }

        Targeter.playerTurn = true;
        enemyTurn = false;
    }

    public World getPreviousWorld(){
        return prevWorld;
    }

    public void setup()
    {
        //Creating grids for player and enemy
        for(int x=0; x<=5; x++)
        {
            for(int y=0; y <=5; y++)
            {
                addObject(new Tile(), x+2, y+6);
                addObject(new Tile(), x+19, y+6);
            }
        }

        // Creating player ships

        playerShips = new Ships[3];
        playerShips[0] = new PlayerShip1();
        playerShips[1] = new PlayerShip1();
        playerShips[2] = new PlayerShip2();

        //Adding player ships, start button, directions button, and timer to the world 
        addObject(playerShips[0], 2,14);
        addObject(playerShips[1], 6,14);
        addObject(playerShips[2], 4,16);
        addObject(new StartButton(), 13,15);
        addObject(new DirectionsButton(), 13,2);
        addObject(new Timer(), 24, 11);

        computerShips = new Ships[3];
        computerShips[0] = new EnemyShip2();
        computerShips[1] = new EnemyShip2();
        computerShips[2] = new EnemyShip1();

        for (int i = computerShips.length - 2; i >= 0; i--) {
            // Generates random positions for enemy long pieces
            int posX;
            int posY;

            posX = MIN_X_COMPUTER + Greenfoot.getRandomNumber(MAX_X_COMPUTER - MIN_X_COMPUTER);
            posY = MIN_Y + Greenfoot.getRandomNumber(MAX_Y - MIN_Y+1);

            addObject(computerShips[i], posX, posY);
        }
        
        int posX;
        int posY;
        posX = MIN_X_COMPUTER + Greenfoot.getRandomNumber(MAX_X_COMPUTER - MIN_X_COMPUTER);
        posY = MIN_Y + Greenfoot.getRandomNumber(MAX_Y - MIN_Y);
        if (posY == 6){
            posY += 1;
        }
        addObject(computerShips[2], posX, posY);
        
        /*for (int i = computerShips.length - 1; i>=0; i--){
            if (computerShips[i].getIntersectingObjects(EnemyShip1.class) || 
            computerShips[i].getIntersectingObjects(EnemyShip2.class)){
                
            }
        }*/
    }

        
    public void guess()
    {
        int count = 0; //To prevent infinite loops
        do{
            if(count >= 20){
                count = 0;
                hit = false;
                streak = 0;
                switching = 0;
            }

            if(!hit && (switching >=2 || streak >=3)){
                //Streak being more than 3 and switching being more
                //than 2 means they probably hit more than one ship.
                hit = true;
                hitX = initialHitX;
                hitY = initialHitY;
                streak = 1;
            }

            if(!hit){
                //If AI just hit something with no prior history:
                switching = 0;
                streak = 0;
                int cycles = 0;
                int guesses = 0;
                Tile tile;
                do{
                    //First attacks positions with no adyacent misses.
                    if(cycles >= 40 && guesses < 4){
                        guesses++;
                        cycles = 0;
                    }
                    //Random coords with no previous attack
                    do{
                        x = MIN_X + Greenfoot.getRandomNumber(MAX_X - MIN_X + 1);
                        y = MIN_Y + Greenfoot.getRandomNumber(MAX_Y - MIN_Y +1);
                    } while (alreadyGuessed());
                    tile = getObjectsAt(x,y, Tile.class).get(0);
                    cycles++;
                } while (tile.getMissedAttacks() > guesses);
                initialHitX = x;
                initialHitY = y;
                cycles = 0;
            } else {
                //If the ship hits:
                if(streak == 1) {
                    //First hit
                    do{
                        //Attack in another random direction
                        direction = Greenfoot.getRandomNumber(4);
                        count++;
                        switch(direction){
                                //Each case is a random direction- 
                                //up, down, left, or right.
                            case 0:
                                x = hitX + 1;
                                y = hitY;
                                break;
                            case 1:
                                x = hitX;
                                y = hitY + 1;
                                break;
                            case 2:
                                x = hitX - 1;
                                y = hitY;
                                break;
                            case 3:
                                x = hitX;
                                y = hitY - 1;
                                break;
                        }
                    }while ((!inGrid() || alreadyGuessed()) && count < 20);
                } else {
                    //If the AI hits another piece of a ship, 
                    //attack in the same directions.
                    switch (direction) {
                        case 0: 
                            x = hitX + 1;
                            y = hitY;
                            break;
                        case 1:
                            x = hitX;
                            y = hitY + 1;
                            break;
                        case 2:
                            x = hitX - 1;
                            y = hitY;
                            break;
                        case 3:
                            x = hitX;
                            y = hitY - 1;
                            break;
                    }
                    if (!inGrid() || alreadyGuessed()) {
                        // change direction 180 degrees, attack other side
                        direction = (direction + 2) % 4;
                        switching ++;
                        switch (direction) {
                            case 0: 
                                x = hitX + streak;
                                y = hitY;
                                break;
                            case 1:
                                x = hitX;
                                y = hitY + streak;
                                break;
                            case 2:
                                x = hitX - streak;
                                y = hitY;
                                break;
                            case 3:
                                x = hitX;
                                y = hitY - streak;
                                break;
                        }
                        if (!inGrid() || alreadyGuessed()){
                            //AI can't find the next ship piece
                            streak = 1;
                            continue;
                        }
                    }
                }
            }
        } while (!inGrid() || alreadyGuessed());
        Ships ship = getShip();
        if (ship != null) {
            // Target's on a ship
            List<Ships> shipList = getObjectsAt(x,y,Ships.class);
            if(shipList != null)
            {
                   addObject(new Hit(), x, y);
                   Greenfoot.playSound("Roblox Explosion Sound Effect.mp3");
                   for(Ships ships: shipList){
                       ship.hit();
                    }
                    Greenfoot.delay(80);
            }
            
            hitX = x;
            hitY = y;
            if (ship.isSunk()) {
                //A sunken ship is destroyed and cannot be targeted.
                hit = false;
            } else {
                hit = true;
                streak++;
            }
        } else {
            // The AI misses.
            Greenfoot.playSound("Studio_Project (3).mp3");
            addObject(new Miss(), x, y);
            Greenfoot.delay(80);
        }
    }

    /**
     * Validates if the guessed coordinates are inside the player grid.
     * 
     * @return true, if inside the grid; false, otherwise.
     */
    private boolean inGrid() {
        return (x >= MIN_X && x <= MAX_X && y >= MIN_Y && y <= MAX_Y);
    }
    
    public boolean shipsInGrid(){
        int numInGrid = 0;
        for (int shipIndex = 0; shipIndex < playerShips.length; shipIndex++){
            if (shipIndex < 2){
               if ((playerShips[shipIndex].getX() >= MIN_X+1 && playerShips[shipIndex].getX() <= MAX_X-1) && 
                (playerShips[shipIndex].getY() >= MIN_Y && playerShips[shipIndex].getY() <= MAX_Y)){
                    numInGrid++;
                } 
            } else if (shipIndex == 2){
                if (((playerShips[shipIndex].getX() >= MIN_X && playerShips[shipIndex].getX() <= MAX_X) && 
                (playerShips[shipIndex].getY() >= MIN_Y+1 && playerShips[shipIndex].getY() <= MAX_Y-1))){
                    numInGrid++;
                }
            }
        }
        return numInGrid == 3;
    }

    /** 
     * Finds out if the guessed coords have already been hit
     * 
     * @return true, if a Hit or a Miss is there; false, otherwise.
     */
    private boolean alreadyGuessed() {
        return (getObjectsAt(x, y, Miss_Or_Hit.class).size() !=0);
    }

    /**
     * Gets the ship, if any, in the guessed coordinates.
     * 
     * @return the Ship in guessed position; null, otherwise.
     */
    private Ships getShip() {
        List<Ships> list = getObjectsAt(x, y, Ships.class);
        if (list.size() == 0) {
            return null;
        }
        Ships ship = list.get(0);
        if (ship == null) {
            return null;
        }

        //if (ship.isBlank(x, y)) {
        //  return null;
        //} else {
        return ship;
    }

    /**
     * Make sure the guess is inside the grid
     */
    public boolean xAndY()
    {
        if(initialHitX > 0 && initialHitX < 8 && initialHitY > 5 && initialHitY < 12)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void endGame()
    {
        if(computerShips[0].isSunk() && computerShips[1].isSunk() &&
        computerShips[2].isSunk())
        {
            Greenfoot.delay(20);
            Greenfoot.setWorld(new WinFrame(prevWorld));
            backgroundMusic.stop();
            winMusic.play();
        } else if (playerShips[0].isSunk() && playerShips[1].isSunk() && 
        playerShips[2].isSunk()){
            Greenfoot.delay(20);
            Greenfoot.setWorld(new LoseFrame(prevWorld));
            backgroundMusic.stop();
            loseMusic.play();
        }
    }
}