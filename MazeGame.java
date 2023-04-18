import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MazeGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeGame extends World
{
    private BackGround prevWorld;
    /**
     * Constructor for objects of class MazeGame.
     * 
     */
    public MazeGame(BackGround previousWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(12, 12, 50); 
        GreenfootImage background = new GreenfootImage("space1.jpg");
        setBackground(background);
        prepare();
        prevWorld= previousWorld;
        addObject(new MazeTimer(prevWorld),129,30);
        addObject(new MazeRunner(), 0, 11);
    }
    public BackGround getPreviousWorld(){
        return prevWorld;
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        MazeBlock mazeBlock70 = new MazeBlock();
        addObject ( new winBlock(prevWorld), 12, 0);
        MazeBlock mazeBlock = new MazeBlock();
        addObject(mazeBlock,0,10);
        MazeBlock mazeBlock2 = new MazeBlock();
        addObject(mazeBlock2,0,10);
        MazeBlock mazeBlock4 = new MazeBlock();
        addObject(mazeBlock4,1,10);
        MazeBlock mazeBlock5 = new MazeBlock();
        addObject(mazeBlock5,2,10);
        MazeBlock mazeBlock6 = new MazeBlock();
        addObject(mazeBlock6,2,9);
        MazeBlock mazeBlock7 = new MazeBlock();
        addObject(mazeBlock7,4,11);
        MazeBlock mazeBlock8 = new MazeBlock();
        addObject(mazeBlock8,4,10);
        MazeBlock mazeBlock9 = new MazeBlock();
        addObject(mazeBlock9,5,10);
        MazeBlock mazeBlock10 = new MazeBlock();
        addObject(mazeBlock10,6,10);
        MazeBlock mazeBlock11 = new MazeBlock();
        addObject(mazeBlock11,4,8);
        MazeBlock mazeBlock12 = new MazeBlock();
        addObject(mazeBlock12,2,8);
        MazeBlock mazeBlock13 = new MazeBlock();
        addObject(mazeBlock13,1,8);
        mazeBlock13.setLocation(4,6);
        mazeBlock12.setLocation(7,8);
        mazeBlock11.setLocation(7,10);
        mazeBlock8.setLocation(5,11);
        mazeBlock9.setLocation(6,11);
        mazeBlock10.setLocation(6,11);
        mazeBlock11.setLocation(8,11);
        mazeBlock12.setLocation(4,9);
        mazeBlock13.setLocation(5,9);
        MazeBlock mazeBlock14 = new MazeBlock();
        addObject(mazeBlock14,6,9);
        MazeBlock mazeBlock15 = new MazeBlock();
        addObject(mazeBlock15,7,9);
        MazeBlock mazeBlock16 = new MazeBlock();
        addObject(mazeBlock16,9,11);
        MazeBlock mazeBlock17 = new MazeBlock();
        addObject(mazeBlock17,11,11);
        MazeBlock mazeBlock18 = new MazeBlock();
        addObject(mazeBlock18,11,10);
        mazeBlock5.setLocation(1,9);
        mazeBlock6.setLocation(1,8);
        MazeBlock mazeBlock19 = new MazeBlock();
        addObject(mazeBlock19,3,11);
        MazeBlock mazeBlock20 = new MazeBlock();
        addObject(mazeBlock20,3,9);
        MazeBlock mazeBlock21 = new MazeBlock();
        addObject(mazeBlock21,0,8);
        MazeBlock mazeBlock22 = new MazeBlock();
        addObject(mazeBlock22,1,6);
        MazeBlock mazeBlock23 = new MazeBlock();
        addObject(mazeBlock23,1,5);
        MazeBlock mazeBlock24 = new MazeBlock();
        addObject(mazeBlock24,1,4);
        MazeBlock mazeBlock25 = new MazeBlock();
        addObject(mazeBlock25,8,9);
        MazeBlock mazeBlock26 = new MazeBlock();
        addObject(mazeBlock26,11,9);
        MazeBlock mazeBlock27 = new MazeBlock();
        addObject(mazeBlock27,10,8);
        MazeBlock mazeBlock28 = new MazeBlock();
        addObject(mazeBlock28,10,9);
        MazeBlock mazeBlock29 = new MazeBlock();
        addObject(mazeBlock29,11,8);
        MazeBlock mazeBlock30 = new MazeBlock();
        addObject(mazeBlock30,11,7);
        MazeBlock mazeBlock31 = new MazeBlock();
        addObject(mazeBlock31,11,6);
        MazeBlock mazeBlock32 = new MazeBlock();
        addObject(mazeBlock32,11,5);
        MazeBlock mazeBlock33 = new MazeBlock();
        addObject(mazeBlock33,10,5);
        MazeBlock mazeBlock34 = new MazeBlock();
        addObject(mazeBlock34,9,5);
        MazeBlock mazeBlock35 = new MazeBlock();
        addObject(mazeBlock35,8,5);
        MazeBlock mazeBlock36 = new MazeBlock();
        addObject(mazeBlock36,8,6);
        mazeBlock33.setLocation(11,4);
        mazeBlock34.setLocation(10,4);
        mazeBlock35.setLocation(9,4);
        MazeBlock mazeBlock37 = new MazeBlock();
        addObject(mazeBlock37,8,4);
        MazeBlock mazeBlock38 = new MazeBlock();
        addObject(mazeBlock38,8,5);
        MazeBlock mazeBlock39 = new MazeBlock();
        addObject(mazeBlock39,9,6);
        MazeBlock mazeBlock40 = new MazeBlock();
        addObject(mazeBlock40,8,7);
        MazeBlock mazeBlock41 = new MazeBlock();
        addObject(mazeBlock41,7,7);
        MazeBlock mazeBlock42 = new MazeBlock();
        addObject(mazeBlock42,6,7);
        MazeBlock mazeBlock43 = new MazeBlock();
        addObject(mazeBlock43,6,6);
        MazeBlock mazeBlock44 = new MazeBlock();
        addObject(mazeBlock44,6,5);
        MazeBlock mazeBlock45 = new MazeBlock();
        addObject(mazeBlock45,4,7);
        MazeBlock mazeBlock46 = new MazeBlock();
        addObject(mazeBlock46,4,6);
        MazeBlock mazeBlock47 = new MazeBlock();
        addObject(mazeBlock47,4,5);
        MazeBlock mazeBlock48 = new MazeBlock();
        addObject(mazeBlock48,4,4);
        MazeBlock mazeBlock49 = new MazeBlock();
        addObject(mazeBlock49,6,4);
        MazeBlock mazeBlock50 = new MazeBlock();
        addObject(mazeBlock50,4,3);
        MazeBlock mazeBlock51 = new MazeBlock();
        addObject(mazeBlock51,4,2);
        MazeBlock mazeBlock52 = new MazeBlock();
        addObject(mazeBlock52,4,1);
        MazeBlock mazeBlock53 = new MazeBlock();
        addObject(mazeBlock53,2,6);
        MazeBlock mazeBlock54 = new MazeBlock();
        addObject(mazeBlock54,2,5);
        MazeBlock mazeBlock55 = new MazeBlock();
        addObject(mazeBlock55,2,4);
        MazeBlock mazeBlock56 = new MazeBlock();
        addObject(mazeBlock56,2,3);
        MazeBlock mazeBlock57 = new MazeBlock();
        addObject(mazeBlock57,10,0);
        MazeBlock mazeBlock58 = new MazeBlock();
        addObject(mazeBlock58,10,1);
        MazeBlock mazeBlock59 = new MazeBlock();
        addObject(mazeBlock59,10,2);
        MazeBlock mazeBlock60 = new MazeBlock();
        addObject(mazeBlock60,5,1);
        MazeBlock mazeBlock61 = new MazeBlock();
        addObject(mazeBlock61,6,1);
        MazeBlock mazeBlock62 = new MazeBlock();
        addObject(mazeBlock62,6,2);
        MazeBlock mazeBlock63 = new MazeBlock();
        addObject(mazeBlock63,7,2);
        MazeBlock mazeBlock64 = new MazeBlock();
        addObject(mazeBlock64,8,2);
        MazeBlock mazeBlock65 = new MazeBlock();
        addObject(mazeBlock65,9,2);
        MazeBlock mazeBlock66 = new MazeBlock();
        addObject(mazeBlock66,1,1);
        MazeBlock mazeBlock67 = new MazeBlock();
        addObject(mazeBlock67,2,2);
        mazeBlock55.setLocation(3,4);
        mazeBlock56.setLocation(2,4);
        mazeBlock67.setLocation(1,2);
        mazeBlock66.setLocation(1,2);
        mazeBlock5.setLocation(0,9);
        mazeBlock5.setLocation(1,9);
        mazeBlock2.setLocation(0,9);
        mazeBlock4.setLocation(2,9);
        mazeBlock2.setLocation(3,8);
        mazeBlock2.setLocation(1,10);
        mazeBlock2.setLocation(2,8);
        mazeBlock19.setLocation(1,11);
        mazeBlock.setLocation(2,11);
        mazeBlock2.setLocation(3,11);
        mazeBlock61.setLocation(1,1);
        mazeBlock66.setLocation(3,2);
        MazeBlock mazeBlock68 = new MazeBlock();
        addObject(mazeBlock68,7,0);
        MazeBlock mazeBlock3 = new MazeBlock();
        addObject(mazeBlock3,7,11);
        MazeBlock mazeBlock69 = new MazeBlock();
        addObject(mazeBlock69,10,11);
    }
}
