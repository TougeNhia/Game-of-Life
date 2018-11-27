package game.of.life;
import java.awt.*;
import java.util.ArrayList;
public class Player {
    
    private static int numPlayers = 4;
    private static Image cars[] = {Toolkit.getDefaultToolkit().getImage("./TRANSP CAR.png"),Toolkit.getDefaultToolkit().getImage("./TRANSPP CAR 2.png"),Toolkit.getDefaultToolkit().getImage("./TRANSPP CAR 3.png"),Toolkit.getDefaultToolkit().getImage("./TRANSPP CAR 4.png")};
    public final static int CAREER = 0;
    public final static int COLLEGE = 1;
    private Image car; 
    private int money;
    private int moves;
    private static Player currPlayer;
    private static Player players[] = new Player[numPlayers]; 
    private static ArrayList<Player> plrList = new ArrayList<Player>();
    private int currRow;
    private int currCol;
    private Dir direct;
    private boolean hasSpun;
    private double rot;
    private boolean isRetired;
    public static enum Dir{
    RIGHT,UP,DOWN,LEFT
    }
    public static void Reset(){
        currPlayer = players[0];
    }
    public static Player addPlayer(Image _car){
       Player ptr = new Player(_car);
//       for(int i=0; i<numPlayers;i++){
//           if(players[i] == null){
//               players[i] = ptr; 
//               break;
//           }
//       }    
    plrList.add(ptr);
    return ptr;
    }  
    
    public static Player addPlayer(Image _car, int test){
       Player ptr = null;
       for(int i=0; i<numPlayers;i++){
           if(players[i] == null){
               ptr = new Player(_car, test);
               players[i] = ptr; 
               break;
           }
       }
       if(ptr == null){
           ptr = new Player(_car,test);
           players[numPlayers-1] = ptr;
       }
       return ptr;
    }

    Player(Image _car){
     moves = 0;
     car = _car;
     currRow = 6;
     currCol = 17;
     money = 10000;
    }
        Player(Image _car, boolean college){
     if(college)
     {
         moves = 0;
        car = _car;
        currRow = 7;
        currCol = 17;
        money = 5000;
        
     }

         
    }    
    //use this one for testing    
    Player(Image _car, int test){
         moves = 0;
        car = _car;
        currRow = 9;
        currCol = 10;
        money = 0;
        direct = Dir.DOWN;
        }
    public static Player getPlayer(int i){
        return players[i];
    }
    public Image getCar(){
        return car;
    }
    public double getRot(){
        return rot;
    }
    public static int getNumPlayers(){
        return(numPlayers);
    }
    public static void setNumPlayers(){
        numPlayers = plrList.size();
    }
    public static void Merge(){
        for(int i = 0; i < numPlayers;i++){
            if( i < plrList.size() && plrList.get(i) !=null)
            players[i] = plrList.get(i);
            
            
//            for(int t = 0; t < plrList.size();i++){
//                if(players[i] == null){
//                    players[i] = plrList.get(t);
//                    break;
//                }
//            }
        }
    }
    public void changeMoney(double m, int operator){
        if(operator == Cards.LIN)
            money += m;
        else if (operator == Cards.MULT)
            money *= m;
        else if (operator == Cards.DIV)
            money /= m;
    }
    
    public void changeMoves(int _moves){
        moves += _moves;
    }
    public Dir getDir(){
        return direct;
    }
    public int getMoney(){
        return money;
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
    public boolean hasSpun(){
        return hasSpun;
    }
    public boolean isRetired(){
        return isRetired;
    }
     public void setSpun(boolean b){
        hasSpun = b;
    }
    public static Image[] getCarList(){
        return cars;
    }
    public static ArrayList<Player> getTList(){
        return plrList;
    }
    public void setCar(Image _car){
        car = _car;
    }
    public void update(int row, int col){
        currRow = row;
        currCol = col;
    }
    public static void switchTurns(){
        System.out.println(currPlayer.currRow + " " + currPlayer.currCol);
        for(int i=0;i<players.length;i++){
            if(players[i] == currPlayer){
                if(i+1 < players.length && players[i+1] != null)
                    currPlayer = players[i+1];
                else
                    currPlayer = players[0];
                
                break;
            }
        }
    }
    public void move(Dir direction,CarToken.Type dir){
        
       if(dir == CarToken.Type.MOVE){     
       direct = direction;         
       if( direction == Dir.RIGHT && Board.checkBoard(currRow,currCol+1)){
            rot = 0;
            Board.updateBoard(currRow,currCol+1);
            moves--;
            
           
       }
           
//up
       else if(direction == Dir.UP && Board.checkBoard(currRow-1,currCol)){
           rot = -90;
            Board.updateBoard(currRow-1,currCol);
             moves--;
            
            } 
        
       else if(direction == Dir.LEFT && Board.checkBoard(currRow,currCol-1)){
           rot = -180; 
           Board.updateBoard(currRow,currCol-1);
           moves--;
             
            }
        
       else if(direction == Dir.DOWN && Board.checkBoard(currRow+1,currCol)){
           rot = -270; 
           Board.updateBoard(currRow+1,currCol);
             moves--;
             
            }
       if(moves <= 0){
           hasSpun = false;
           switchTurns();
          Cards.eventRoll(currPlayer);
           
       }
       System.out.println(moves);  
       }
       else if(dir == CarToken.Type.STOP){
           
       }
       else 
       System.out.println(dir);       
        
    }
}
