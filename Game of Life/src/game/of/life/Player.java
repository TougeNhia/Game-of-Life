package game.of.life;
import java.awt.*;
public class Player {
    
    final private static int numPlayers = 4;
    private Image car; 
    private int moves;
    private static Player currPlayer;
    private static Player players[] = new Player[numPlayers];   
    private int currRow;
    private int currCol;
    private Dir direct;
    public static enum Dir{
    RIGHT,UP,DOWN,LEFT
    }
    
    
    Player(Image _car){
     moves = 0;
     car = _car;
    }
    
    public static int getNumPlayers(){
        return(numPlayers);
    }
    public static void switchTurns(){
        int i = 0;
        for(Player ptr : players){
            if(ptr == currPlayer)
                break;
            i++;
        }
        if(i != numPlayers)
            currPlayer = players[i+1];
        else
            currPlayer = players[0];
    }
    public static Player getCurrentPlayer(){
        return currPlayer;
    }
    
    public void move(){
        if(currPlayer == this){
            while(moves > 0)
                
       if(Board.checkBoard(currRow,currCol+1))
           Board.updateBoard(currRow,currCol+1);
//up
        if(Board.checkBoard(currRow+1,currCol))
            Board.updateBoard(currRow+1,currCol);
        
                
                
            moves--;
        }
    }
}
