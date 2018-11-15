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
    public static void Reset(){
        currPlayer = players[0];
    }
    public static Player addPlayer(Image _car){
       Player ptr = new Player(_car);
       for(int i=0; i<numPlayers;i++){
           if(players[i] == null){
               players[i] = ptr; 
               break;
           }
       }
           
    return ptr;
    }
    
    Player(Image _car){
     moves = 2;
     car = _car;
     currRow = 6;
     currCol = 17;
    }
    public static Player getPlayer(int i){
        return players[i];
    }
    public Image getCar(){
        return car;
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
        if(i != numPlayers-1)
            currPlayer = players[i+1];
        else
            currPlayer = players[0];
    }
    public static Player getCurrentPlayer(){
        return currPlayer;
    }
    public int getMoves(){
        return moves;
    }
    public int getRow(){
        return currRow;
    }
    public int getCol(){
        return currCol;
    }
    public void update(int row, int col){
        currRow = row;
        currCol = col;
    }
    public void move(){
        if(currPlayer == this){
            
                
       if(Board.checkBoard(currRow,currCol+1))
           Board.updateBoard(currRow,currCol+1);
//up
        if(Board.checkBoard(currRow+1,currCol))
            Board.updateBoard(currRow+1,currCol);
        
                
                
            moves--;
        }
    }
}
