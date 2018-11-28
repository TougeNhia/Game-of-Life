package game.of.life;
import java.awt.*;
import java.util.ArrayList;
public class Player {
    public static int DAY;
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
    private Cards job;   
    private int currRow;
    private static int plrCount = 0;
    private int currCol;
    private Dir direct;
    private boolean hasSpun;
    private double rot;
    private boolean isRetired;
    private int status;
    private boolean paid;
    public static enum Dir{
    RIGHT,UP,DOWN,LEFT
    }
    public static void Reset(){
        Merge();
        currPlayer = players[0];
        DAY = 0;
    }
    public static Player addPlayer(Image _car){
       Player ptr = new Player(_car);  
    if(plrList.size() >= numPlayers){
        return null;
    }
    else
    plrList.add(ptr);    
    return ptr;
    }
       public static Player addPlayer(Image _car, boolean college){
       Player ptr = new Player(_car,college);  
    if(plrList.size() >= numPlayers){
        return null;
    }
    else
    plrList.add(ptr);    
    return ptr;
    } 
    public static void Wipe(){
        plrList.clear();
    }
    


    Player(Image _car){
     moves = 0;
     car = _car;
//     currRow = 6;
//     currCol = 17;
currRow = 11;
currCol = 15;
     money = 10000;
     status = CAREER;
          direct = Dir.LEFT;
    }
        Player(Image _car, boolean college){
     if(college)
     {
         moves = 0;
        car = _car;
        currRow = 7;
        currCol = 17;
//      currRow = 6;
//     currCol = 20;
        money = 1500;
        status = COLLEGE;
     //   direct = Dir.UP;
     }

         
    }    
    //use this one for testing    

    Player(Image _car, int test){
     moves = 0;
     car = _car;
     currRow = 6;
     currCol = 17;
     money = 10000;
     status = CAREER;
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
    public int getStats(){
        return status;
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
    public Cards getJob(){
        return job;
    }
    public void obtainJob(Cards ptr){
        job = ptr;
    }
    public int getMoney(){
        return money;
    }
    public static Player getCurrentPlayer(){
        return currPlayer;
    }
    public static Player[] getPlrArray(){
        return players;
    }
    public static int getIndexOf(Player ptr){
        for(int i=0; i<numPlayers;i++){
            if(players[i] == ptr)
                return i;
        }
        return 0;
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
    public void setStat(int stat){
        status = stat;
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
    public static boolean CheckJob(Cards ptr){
        for(Player pptr : plrList){
            if(Cards.CheckJob(ptr)|| pptr.job == ptr)
                return true;
        }
        return false;
    }
    public static void switchTurns(){
        
        Player ptr = currPlayer;
        ptr.paid = false;
        for(int i=0;i<players.length;i++){
            if(players[i] == currPlayer){
                if(i+1 < players.length && players[i+1] != null){
                     currPlayer = players[i+1];
                     System.out.print("done n");
                }
                   
                else{
                    currPlayer = players[0];
                    DAY++;
                    
                    System.out.print("done a");
                }
                break;
            }
        }
//        int i = 0;
//        while(currPlayer == ptr){
//            if(i < players.length && players[i] != currPlayer && !players[i].isRetired){
//             currPlayer = players[i];  
//            }
//            else if (i > players.length){
//                GameOfLife.gameOver = true;
//            }
        
    }
    public void move(Dir direction,CarToken.Type dir){
        
       event(dir);
       direct = direction;         
       if( direction == Dir.RIGHT && Board.checkBoard(currRow,currCol+1)){
            rot = 0;
            Board.updateBoard(currRow,currCol+1);
            moves--;
            
           
       }
           
//up
        if(direction == Dir.UP && Board.checkBoard(currRow-1,currCol)){
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
           moves = 0;
           hasSpun = false;
           if(event(Board.checkType()))
           Cards.eventRoll(currPlayer);
           
       }
           
       
       System.out.println(moves);  
       
 
       System.out.println(dir);       
        
    }
    public boolean event(CarToken.Type dir){
               
        if(dir == CarToken.Type.STOP){          
           if(status == COLLEGE){ 
               moves = 0;
               Cards.careerRoll(currPlayer);
               return false;
           }
       }
       else if (dir == CarToken.Type.FORK){
           Cards.getChoice(currPlayer);
                return false;
       }
       else if(dir == CarToken.Type.END){
            plrCount++;
            if(plrCount == plrList.size()-1){
                GameOfLife.gameOver = true;
            System.out.print("true sfadfd");
            }
            
            isRetired = true;
            moves = 0;
            Cards.End();
 //           switchTurns();
            return false;
        }
       else if(!paid && dir == CarToken.Type.PAYDAY){
            paid = true;
            Cards.payDay(currPlayer);
            return false;
       }
        
        return true;
    }
    
    //skips retires, returns true if one is not retired
    public static boolean checkAllRetired(){
       for(Player ptr : players){
           if(ptr != null && ptr.isRetired)
               continue;
           return true;
       }
       return false;
    }
}
