import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mini_Battleship_World here.
 * 
 * @author Justin Tolbert (Thanks to brian5021 for reference code)
 * @version 1.0
 */
public class Mini_Battleship_World extends World
{
    public boolean hit = false; //Determines if a ship is hit or not.
    public static boolean enemyTurn = false; //Determines if it's the enemy's turn.
    private static int lastXGuess; //Keeps track of the last guess on the x coord.
    private static int lastYGuess; //Keeps track of the last guess on the y coord.
    private int xGuess; //Keeps track of the current x guess.
    private int yGuess; //Keeps track of the current y guess.
    /**
     * Constructor for objects of class Mini_Battleship_World.
     * 
     */
    public Mini_Battleship_World()
    {    
        // Create a new world with 32x22 cells with a cell size of 20x20 pixels.
        super(27, 18, 20);
        setup();
    }
    
    public void act()
    {
        if(Targeter.playerTurn == false)
        {
            enemyTurn = true;
        }
        
        /*
        if(enemyTurn)
        {
            guess();
            endGame();
        }
        */
        Targeter.playerTurn = true;
        enemyTurn = false;
    }
    
    public void setup()
    {
        for(int x=0; x<=5; x++)
        {
            for(int y=0; y <=5; y++)
            {
                addObject(new Tile(), x+2, y+6);
                addObject(new Tile(), x+19, y+6);
            }
        }
        

        addObject(new PlayerShip1(), 2,14);
        addObject(new PlayerShip1(), 6,14);
        addObject(new PlayerShip2(), 4,16);
        addObject(new StartButton(), 13,15);
        
        addObject(new EnemyShip2(), 21,11);
        addObject(new EnemyShip2(), 20,6);
        addObject(new EnemyShip1(), 23,8);

        //addObject(new EnemyShip2(),x,y);
        //addObject(new EnemyShip2(),x,y);
        //addObject(new EnemyShip1(),x,y);

    }
}