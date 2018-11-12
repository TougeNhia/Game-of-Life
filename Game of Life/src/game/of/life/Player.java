package game.of.life;
import java.awt.*;
public class Player {
    
    final private static int numPlayers = 4;
    private Image car; 
    private int moves;
    private static Player currPlayer;
    private static Player players[] = new Player[numPlayers];    
    
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
        currPlayer = players[i+1];
    }
    public Player getCurrentPlayer(){
        return currPlayer;
    }
    
//    public void move(){
//        if(currPlayer == this){
//            
//            moves--;
//        }
//    }
}
