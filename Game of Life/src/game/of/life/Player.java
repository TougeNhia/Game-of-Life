package game.of.life;
import java.awt.*;
public class Player {
    
    final private static int numPlayers = 4;
    private static Image cars[] = {Toolkit.getDefaultToolkit().getImage("./TRANSP CAR.png"),Toolkit.getDefaultToolkit().getImage("./TRANSPP CAR 2.png"),Toolkit.getDefaultToolkit().getImage("./TRANSPP CAR 3.png"),Toolkit.getDefaultToolkit().getImage("./TRANSPP CAR 4.png")};

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
     moves = 10;
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
        System.out.println(currPlayer.currRow + " " + currPlayer.currCol);
        for(Player ptr : players){
            if(ptr != currPlayer){
                currPlayer = ptr;
                break;
            }
        }
    }
    public void changeMoves(int _moves){
        moves += _moves;
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
    public static Image[] getCarList(){
        return cars;
    }
    public void update(int row, int col){
        currRow = row;
        currCol = col;
    }
    public void move(Dir direction){
        
            
                
       if( direction == Dir.RIGHT && Board.checkBoard(currRow,currCol+1)){
            Board.updateBoard(currRow,currCol+1);
            moves--;
            switchTurns();
           
       }
           
//up
       else if(direction == Dir.UP && Board.checkBoard(currRow-1,currCol)){
            Board.updateBoard(currRow-1,currCol);
             moves--;
             switchTurns();
            } 
        
       else if(direction == Dir.LEFT && Board.checkBoard(currRow,currCol-1)){
            Board.updateBoard(currRow,currCol-1);
             moves--;
             switchTurns();
            }
        
       else if(direction == Dir.DOWN && Board.checkBoard(currRow+1,currCol)){
            Board.updateBoard(currRow+1,currCol);
             moves--;
             switchTurns();
            }
                
                
          System.out.println(moves);      
            
        
    }
}
