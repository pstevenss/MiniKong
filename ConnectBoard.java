import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class ConnectBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConnectBoard  extends World
{

    private World prevWorld;
    int[] openColumns = {5,5,5,5,5,5,5};
    boolean p1Turn = true;
    int clicks=0;
    int end=42;
    Board b;
    int [][] bb = 
    { {0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0},
    };
    
    /*public ConnectBoard()

    {    
        super(7, 6, 60);
        addObject(new Player_1(),0,0);
        setPaintOrder(WinOne.class, WinTwo.class, Draw.class, Player_1.class, Player_2.class);
        b = new Board(bb);
    }*/
    
    public ConnectBoard(World previousWorld)
    {
    
        super(7, 6, 60);
        addObject(new Player_1(),0,0);
        setPaintOrder(WinOne.class, WinTwo.class, Draw.class, Player_1.class, Player_2.class);
        b = new Board(bb);
        prevWorld = previousWorld;
    }
    
    public void add(int x, Player_1 p1)
    {
        if(openColumns[x] != -1)
        {
            p1.setLocation(x,openColumns[x]);
            b.addPosition(x, openColumns[x], p1Turn);
            openColumns[x]--;
            if(b.checkWin1() == false)
            {
                p1Turn = false;
                clicks++;
                createNewPlayer();  
            }
            else
                addObject(new WinOne(prevWorld), 3,3);
        }
        else
            p1.followMouse = true;
    }
    public World getPreviousWorld(){
    return prevWorld;
}

    public void add(int x, Player_2 p2)
    {
        if(openColumns[x] != -1)
        {
            p2.setLocation(x,openColumns[x]);
            b.addPosition(x, openColumns[x], p1Turn);
            openColumns[x]--;
            if(b.checkWin2() == false)
            {
                p1Turn = true;
                clicks++;
                createNewPlayer();  
            }
            else
                addObject(new WinTwo(prevWorld), 3,3);
        }
        else
            p2.followMouse = true;
    }

    public void createNewPlayer()
    {
        if(clicks == end)
            addObject(new Draw(), 3, 3);
        else
        {
            if(p1Turn==true)
                addObject(new Player_1(),0,0);
            else
                addObject(new Player_2(),0,0);
        }
    }
    
    public void resetBoard()
    {
        for(int i=0; i<7; i++)
            openColumns[i]=5;
        int [][] bb = 
        { {0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0},
        };

        p1Turn = true;
        clicks=0;
        end=42;
        List<Actor> actors = getObjects(null); 
        for(int i=0; i<actors.size(); i++)
        {
            Actor a = actors.get(i); 
            removeObject(a);
        }
        b = new Board(bb);
        addObject(new Player_1(),0,0);
    }
}   
