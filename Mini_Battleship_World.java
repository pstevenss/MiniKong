import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

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
    private int proximity; //Helps AI aim near guessed ships.
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
            guess();
            endGame();
            Targeter.playerTurn = true;
        }
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
    
    public void guess()
    {
        if(hit == false)
        {
            xGuess = Greenfoot.getRandomNumber(6) + 2;
            yGuess = Greenfoot.getRandomNumber(6) + 6;
        }
        
        if(hit == true)
        {
           if(proximity == 1)
           {
               int random = Greenfoot.getRandomNumber(4);
               switch(random)
               {
                   case 0: xGuess = lastXGuess + Greenfoot.getRandomNumber(2);
                   yGuess = lastYGuess;
                   break;
                   case 1: xGuess = lastXGuess;
                   yGuess = lastYGuess - Greenfoot.getRandomNumber(2);
                   break;
                   case 2: xGuess = lastXGuess - Greenfoot.getRandomNumber(2);
                   yGuess = lastYGuess;
                   break;
                   case 3: xGuess = lastXGuess;
                   yGuess = lastYGuess + Greenfoot.getRandomNumber(2);
                   break;
               }
           }
           if(proximity > 1)
            {
               List range1 = getObjectsAt(lastXGuess + 1, lastYGuess, Hit.class);
               List range2 = getObjectsAt(lastXGuess - 1, lastYGuess, Hit.class);
               List range3 = getObjectsAt(lastXGuess, lastYGuess + 1, Hit.class);
               List range4 = getObjectsAt(lastXGuess, lastYGuess - 1, Hit.class);
               int random = Greenfoot.getRandomNumber(2);
        
               if(range1.size() > 0 && range2.size() == 0 && range3.size() == 0 && range4.size() == 0)
            
               {
                    switch(random)
                    {
                        case 0: xGuess = lastXGuess + 2;
                        yGuess = lastYGuess;
                        break;
                        case 1: xGuess = lastXGuess - 1;
                        yGuess = lastYGuess;
                        break;
                    }  
                }
                if(range1.size() == 0 && range2.size() > 0 && range3.size() == 0 && range4.size() == 0)
                {
                   switch(random)
                   {
                       case 0: xGuess = lastXGuess - 2;
                       yGuess = lastYGuess;
                       break;
                       case 1: xGuess = 1;
                       yGuess = lastYGuess;
                       break;
                   }
                }
                if(range1.size() == 0 && range2.size() == 0 && range3.size() > 0 && range4.size() == 0)
                {
                    switch(random)
                    {
                        case 0: xGuess = lastXGuess;
                        yGuess = lastYGuess + 2;
                        break;
                        case 1: xGuess = lastXGuess;
                        yGuess = lastYGuess - 1;
                        break;
                    }
                }
                if(range1.size() == 0 && range2.size() == 0 && range3.size() == 0 && range4.size() > 0)
                {
                    switch(random)
                    {
                        case 0: xGuess = lastXGuess;
                        yGuess = lastYGuess - 2;
                        break;
                        case 1: xGuess = lastXGuess;
                        yGuess = lastYGuess + 1;
                        break;
                    }
                }
           }
        }
        else
        {
            hit = false;
            proximity = 0;
        }
        
        List checkShip = getObjectsAt(xGuess,yGuess,Ships.class);
        List check = getObjectsAt(xGuess,yGuess,Miss_Or_Hit.class);
        
        if(checkShip.size() > 0 && check.size() > 0)
        {
           guess(); 
        }
        if(checkShip.size() > 0 && check.size() == 0 && xAndY())
        {
            addObject(new Hit(),xGuess,yGuess);
            hit = true;
            proximity = proximity + 1;
            lastXGuess = xGuess;
            lastYGuess = yGuess;
        }
        if(checkShip.size() == 0 && check.size() == 0 && xAndY())
        {
            addObject(new Miss(),xGuess,yGuess);
            hit = false;
            proximity = 0;
        }
        if(checkShip.size() == 0 && check.size() > 0 )
        {
            guess();
        }
        if(xAndY() == false)
        {
            guess();
        }
    }
    
    /**
     * Make sure the sure guess is inside the grid
     */
    public boolean xAndY()
    {
       if(xGuess > 0 && xGuess < 8 && yGuess > 5 && yGuess < 12)
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
        if(PlayerShip1.shipSunk && PlayerShip2.shipSunk || EnemyShip1.shipSunk && EnemyShip2.shipSunk)
        {
            Greenfoot.stop();
        }
    }
}