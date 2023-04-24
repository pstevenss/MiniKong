/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board  
{
    int [][] board;
        
    public Board(int[][] b)
    {
        board = b;
    }
    
    public void addPosition(int x, int y, boolean p1Turn)
    {
        if(p1Turn==true)
            board[y][x] = 1;
        else
            board[y][x] = 2;
    }
    
    public boolean checkWin1()
    {
        //checking horizontal wins for Player 1
        for(int r=0; r<6; r++)
            for(int c=0; c<4; c++)
            {
                if(board[r][c] == 1)
                {
                    if(board[r][c+1] == 1 && board[r][c+2] == 1 && board[r][c+3] == 1)
                        return true;
                }
            }
        
        //checking vertical wins for Player 1
        for(int r=0; r<3; r++)
            for(int c=0; c<7; c++)
            {
                if(board[r][c] == 1)
                {
                    if(board[r+1][c] == 1 && board[r+2][c] == 1 && board[r+3][c] == 1)
                        return true;
                }
            }
           
        //checking diagonal left wins for Player 1
        for(int r=0; r<3; r++)
            for(int c=0; c<4; c++)
            {
                if(board[r][c] == 1)
                {
                    if(board[r+1][c+1] == 1 && board[r+2][c+2] == 1 && board[r+3][c+3] == 1)
                        return true;
                }
            }
        
        //checking diagonal right wins for Player 1
        for(int r=0; r<3; r++)
            for(int c=3; c<7; c++)
            {
                if(board[r][c] == 1)
                {
                    if(board[r+1][c-1] == 1 && board[r+2][c-2] == 1 && board[r+3][c-3] == 1)
                        return true;
                }
            }
            
        return false;
    }
    
    public boolean checkWin2()
    {
        //checking horizontal wins for Player 2
        for(int r=0; r<6; r++)
            for(int c=0; c<4; c++)
            {
                if(board[r][c] == 2)
                {
                    if(board[r][c+1] == 2 && board[r][c+2] == 2 && board[r][c+3] == 2)
                        return true;
                }
            }
        
        //checking vertical wins for Player 2
        for(int r=0; r<3; r++)
            for(int c=0; c<7; c++)
            {
                if(board[r][c] == 2)
                {
                    if(board[r+1][c] == 2 && board[r+2][c] == 2 && board[r+3][c] == 2)
                        return true;
                }
            }
        
        //checking diagonal leftwins for Player 2
        for(int r=0; r<3; r++)
            for(int c=0; c<4; c++)
            {
                if(board[r][c] == 2)
                {
                    if(board[r+1][c+1] == 2 && board[r+2][c+2] == 2 && board[r+3][c+3] == 2)
                        return true;
                }
            }
            
        //checking diagonal right wins for Player 2
        for(int r=0; r<3; r++)
            for(int c=3; c<7; c++)
            {
                if(board[r][c] == 2)
                {
                    if(board[r+1][c-1] == 2 && board[r+2][c-2] == 2 && board[r+3][c-3] == 2)
                        return true;
                }
            }
            
        return false;
    }
    
}
