package game.of.life;

import java.awt.*;

public class Board {
    //updated
    private final static int NUM_ROWS = 14;
    public static boolean pause = true;
    private final static int NUM_COLUMNS = 21;      
    private static CarToken board[][] = new CarToken[NUM_ROWS][NUM_COLUMNS];
    private static boolean showNumbers = true;
    private static boolean isActive = false;
    //private static boolean board[][];
        public static void Reset(){
            new Board();
            for(int i =0; i<Player.getNumPlayers();i++){
               if(Player.getPlayer(i) !=null){
                   board[Player.getPlayer(i).getRow()][Player.getPlayer(i).getCol()].addCar(Player.getPlayer(i));
               }
            }
        }
    
        Board(){ 

            board[0][0] = null;  board[0][1] = new CarToken(CarToken.Type.MOVE, Player.Dir.DOWN);   board[0][2] = new CarToken(CarToken.Type.MOVE, false);   board[0][3] = new CarToken(CarToken.Type.MOVE, false);   board[0][4] = new CarToken(CarToken.Type.MOVE, false);   board[0][5] = new CarToken(CarToken.Type.MOVE, false);   board[0][6] = new CarToken(CarToken.Type.MOVE, false);   board[0][7] = new CarToken(CarToken.Type.MOVE, false);   board[0][8] = new CarToken(CarToken.Type.MOVE, Player.Dir.LEFT);   board[0][9] = null;  board[0][10] = new CarToken(CarToken.Type.MOVE, Player.Dir.DOWN);   board[0][11] = new CarToken(CarToken.Type.MOVE, false);   board[0][12] = new CarToken(CarToken.Type.MOVE, false);   board[0][13] = new CarToken(CarToken.Type.MOVE, false);   board[0][14] = new CarToken(CarToken.Type.MOVE, Player.Dir.LEFT);   board[0][15] = null;  board[0][16] = new CarToken(CarToken.Type.MOVE, Player.Dir.DOWN);   board[0][17] = new CarToken(CarToken.Type.MOVE, false);   board[0][18] = new CarToken(CarToken.Type.MOVE, false);    board[0][19] = new CarToken(CarToken.Type.MOVE, false);   board[0][20] = new CarToken(CarToken.Type.MOVE, Player.Dir.LEFT);
            board[1][0] = new CarToken(CarToken.Type.MOVE, Player.Dir.DOWN);   board[1][1] = new CarToken(CarToken.Type.MOVE, Player.Dir.LEFT);   board[1][2] = null;  board[1][3] = null;  board[1][4] = null;  board[1][5] = null;  board[1][6] = null;  board[1][7] = null;  board[1][8] = new CarToken(CarToken.Type.MOVE, false);   board[1][9] = null;  board[1][10] = new CarToken(CarToken.Type.MOVE, false);   board[1][11] = null;  board[1][12] = null;  board[1][13] = null;  board[1][14] = new CarToken(CarToken.Type.MOVE, false);   board[1][15] = null;  board[1][16] = new CarToken(CarToken.Type.MOVE, Player.Dir.RIGHT);   board[1][17] = new CarToken(CarToken.Type.MOVE, Player.Dir.DOWN);   board[1][18] = null;   board[1][19] = null;  board[1][20] = new CarToken(CarToken.Type.MOVE, false);
            board[2][0] = new CarToken(CarToken.Type.MOVE, false);   board[2][1] = null;  board[2][2] = new CarToken(CarToken.Type.MOVE, Player.Dir.RIGHT);   board[2][3] = new CarToken(CarToken.Type.MOVE, false);   board[2][4] = new CarToken(CarToken.Type.MOVE, Player.Dir.DOWN);   board[2][5] = null;  board[2][6] = new CarToken(CarToken.Type.MOVE, Player.Dir.RIGHT);   board[2][7] = new CarToken(CarToken.Type.MOVE, false);   board[2][8] = new CarToken(CarToken.Type.MOVE, Player.Dir.UP);   board[2][9] = null;  board[2][10] = new CarToken(CarToken.Type.MOVE, false);   board[2][11] = null;  board[2][12] = null;  board[2][13] = null;  board[2][14] = new CarToken(CarToken.Type.MOVE, false);   board[2][15] = null;  board[2][16] = null;  board[2][17] = new CarToken(CarToken.Type.MOVE, false);   board[2][18] = null;   board[2][19] = null;  board[2][20] = new CarToken(CarToken.Type.MOVE, false);
            board[3][0] = new CarToken(CarToken.Type.MOVE, false);   board[3][1] = null;  board[3][2] = new CarToken(CarToken.Type.MOVE, false);   board[3][3] = null;  board[3][4] = new CarToken(CarToken.Type.MOVE, false);   board[3][5] = null;  board[3][6] = new CarToken(CarToken.Type.MOVE, false);   board[3][7] = null;  board[3][8] = new CarToken(CarToken.Type.MOVE, false);   board[3][9] = null;  board[3][10] = new CarToken(CarToken.Type.MOVE, false);   board[3][11] = null;  board[3][12] = null;  board[3][13] = null;  board[3][14] = new CarToken(CarToken.Type.MOVE, Player.Dir.UP);   board[3][15] = new CarToken(CarToken.Type.MOVE, false);   board[3][16] = new CarToken(CarToken.Type.MOVE, false);   board[3][17] = new CarToken(CarToken.Type.MOVE, Player.Dir.LEFT);   board[3][18] = null;   board[3][19] = null;  board[3][20] = new CarToken(CarToken.Type.MOVE, false);
            board[4][0] = new CarToken(CarToken.Type.MOVE, false);   board[4][1] = null;  board[4][2] = new CarToken(CarToken.Type.MOVE, false);   board[4][3] = null;  board[4][4] = new CarToken(CarToken.Type.MOVE, false);   board[4][5] = null;  board[4][6] = new CarToken(CarToken.Type.MOVE, false);   board[4][7] = null;  board[4][8] = new CarToken(CarToken.Type.MOVE, false);   board[4][9] = null;  board[4][10] = new CarToken(CarToken.Type.MOVE, false);   board[4][11] = null;  board[4][12] = null;  board[4][13] = null;  board[4][14] = null;  board[4][15] = null;  board[4][16] = null;  board[4][17] = null;  board[4][18] = new CarToken(CarToken.Type.MOVE, Player.Dir.RIGHT);    board[4][19] = new CarToken(CarToken.Type.PAYDAY, false);   board[4][20] = new CarToken(CarToken.Type.MOVE, Player.Dir.UP);
            board[5][0] = new CarToken(CarToken.Type.MOVE, false);   board[5][1] = null;  board[5][2] = new CarToken(CarToken.Type.MOVE, false);   board[5][3] = null;  board[5][4] = new CarToken(CarToken.Type.MOVE, false);   board[5][5] = null;  board[5][6] = new CarToken(CarToken.Type.MOVE, false);   board[5][7] = null;  board[5][8] = new CarToken(CarToken.Type.MOVE, false);   board[5][9] = null;  board[5][10] = new CarToken(CarToken.Type.MOVE, false);   board[5][11] = null;  board[5][12] = null;  board[5][13] = null;  board[5][14] = null;  board[5][15] = null;  board[5][16] = null;  board[5][17] = null;  board[5][18] = new CarToken(CarToken.Type.MOVE, Player.Dir.UP);    board[5][19] = null;  board[5][20] = new CarToken(CarToken.Type.STOP, false);
            board[6][0] = new CarToken(CarToken.Type.MOVE, false);   board[6][1] = null;  board[6][2] = new CarToken(CarToken.Type.MOVE, false);   board[6][3] = null;  board[6][4] = new CarToken(CarToken.Type.MOVE, Player.Dir.RIGHT);   board[6][5] = new CarToken(CarToken.Type.MOVE, false);   board[6][6] = new CarToken(CarToken.Type.FORK, Player.Dir.UP,Player.Dir.DOWN);   board[6][7] = null;  board[6][8] = new CarToken(CarToken.Type.MOVE, false);   board[6][9] = null;  board[6][10] = new CarToken(CarToken.Type.MOVE, false);   board[6][11] = null;  board[6][12] = null;  board[6][13] = null;  board[6][14] = null;  board[6][15] = null;  board[6][16] = null;  board[6][17] = new CarToken(CarToken.Type.MOVE, Player.Dir.RIGHT);   board[6][18] = new CarToken(CarToken.Type.MOVE, Player.Dir.UP);    board[6][19] = null;  board[6][20] = new CarToken(CarToken.Type.MOVE, false);
            board[7][0] = new CarToken(CarToken.Type.MOVE, false);   board[7][1] = null;  board[7][2] = new CarToken(CarToken.Type.MOVE, false);   board[7][3] = null;  board[7][4] = null;  board[7][5] = null;  board[7][6] = new CarToken(CarToken.Type.MOVE, Player.Dir.RIGHT);   board[7][7] = new CarToken(CarToken.Type.MOVE, false);   board[7][8] = new CarToken(CarToken.Type.MOVE, Player.Dir.UP);   board[7][9] = null;  board[7][10] = new CarToken(CarToken.Type.MOVE, false);   board[7][11] = null;  board[7][12] = null;  board[7][13] = null;  board[7][14] = null;  board[7][15] = null;  board[7][16] = null;  board[7][17] = new CarToken(CarToken.Type.MOVE, Player.Dir.RIGHT);   board[7][18] = new CarToken(CarToken.Type.MOVE, Player.Dir.DOWN);    board[7][19] = null;  board[7][20] = new CarToken(CarToken.Type.MOVE, false);
            board[8][0] = new CarToken(CarToken.Type.MOVE, Player.Dir.RIGHT);   board[8][1] = new CarToken(CarToken.Type.MOVE, false);   board[8][2] = new CarToken(CarToken.Type.MOVE, false);   board[8][3] = new CarToken(CarToken.Type.MOVE, false);   board[8][4] = new CarToken(CarToken.Type.MOVE, Player.Dir.DOWN);   board[8][5] = null;  board[8][6] = null;  board[8][7] = null;  board[8][8] = null;  board[8][9] = null;  board[8][10] = new CarToken(CarToken.Type.MOVE, false);   board[8][11] = null;  board[8][12] = null;  board[8][13] = null;  board[8][14] = null;  board[8][15] = null;  board[8][16] = null;  board[8][17] = null;  board[8][18] = new CarToken(CarToken.Type.MOVE, false);    board[8][19] = null;  board[8][20] = new CarToken(CarToken.Type.MOVE, false);
            board[9][0] = null;  board[9][1] = null;  board[9][2] = new CarToken(CarToken.Type.MOVE, false);   board[9][3] = null;  board[9][4] = new CarToken(CarToken.Type.MOVE, false);   board[9][5] = null;  board[9][6] = null;  board[9][7] = null;  board[9][8] = null;  board[9][9] = null;  board[9][10] = new CarToken(CarToken.Type.MOVE, false);   board[9][11] = null;  board[9][12] = null;  board[9][13] = null;  board[9][14] = null;  board[9][15] = null;  board[9][16] = null;  board[9][17] = null;  board[9][18] = new CarToken(CarToken.Type.MOVE, Player.Dir.RIGHT);    board[9][19] = new CarToken(CarToken.Type.MOVE, false);   board[9][20] = new CarToken(CarToken.Type.MOVE, Player.Dir.UP);
            board[10][0] = null; board[10][1] = null; board[10][2] = new CarToken(CarToken.Type.MOVE, false);  board[10][3] = null; board[10][4] = new CarToken(CarToken.Type.MOVE, Player.Dir.RIGHT);  board[10][5] = new CarToken(CarToken.Type.MOVE, false);  board[10][6] = new CarToken(CarToken.Type.MOVE, false);  board[10][7] = new CarToken(CarToken.Type.MOVE, false);  board[10][8] = new CarToken(CarToken.Type.MOVE, false);  board[10][9] = new CarToken(CarToken.Type.MOVE, false);   board[10][10] = new CarToken(CarToken.Type.MOVE, false);   board[10][11] = new CarToken(CarToken.Type.MOVE, false);  board[10][12] = new CarToken(CarToken.Type.MOVE, Player.Dir.DOWN);  board[10][13] = null; board[10][14] = null; board[10][15] = new CarToken(CarToken.Type.END, false);  board[10][16] = null; board[10][17] = null; board[10][18] = null;  board[10][19] = null; board[10][20] = null;
            board[11][0] = new CarToken(CarToken.Type.MOVE, Player.Dir.RIGHT);  board[11][1] = new CarToken(CarToken.Type.MOVE, false);  board[11][2] = new CarToken(CarToken.Type.MOVE, Player.Dir.UP);  board[11][3] = null; board[11][4] = null; board[11][5] = null; board[11][6] = null; board[11][7] = null; board[11][8] = null; board[11][9] = null; board[11][10] = new CarToken(CarToken.Type.MOVE, false);  board[11][11] = null; board[11][12] = new CarToken(CarToken.Type.MOVE, false);  board[11][13] = null; board[11][14] = null; board[11][15] = new CarToken(CarToken.Type.MOVE, Player.Dir.UP);  board[11][16] = new CarToken(CarToken.Type.MOVE, false);  board[11][17] = new CarToken(CarToken.Type.MOVE, false);  board[11][18] = new CarToken(CarToken.Type.MOVE, false);   board[11][19] = new CarToken(CarToken.Type.MOVE, Player.Dir.LEFT);  board[11][20] = null;
            board[12][0] = new CarToken(CarToken.Type.MOVE, false);  board[12][1] = null; board[12][2] = null; board[12][3] = null; board[12][4] = null; board[12][5] = null; board[12][6] = null; board[12][7] = null; board[12][8] = null; board[12][9] = new CarToken(CarToken.Type.MOVE, Player.Dir.DOWN);  board[12][10] = new CarToken(CarToken.Type.MOVE, Player.Dir.LEFT);  board[12][11] = null; board[12][12] = new CarToken(CarToken.Type.MOVE, Player.Dir.RIGHT);  board[12][13] = new CarToken(CarToken.Type.MOVE, Player.Dir.DOWN);  board[12][14] = null; board[12][15] = null; board[12][16] = null; board[12][17] = null; board[12][18] = null;  board[12][19] = new CarToken(CarToken.Type.MOVE, false);  board[12][20] = null;
            board[13][0] = new CarToken(CarToken.Type.MOVE, Player.Dir.UP);  board[13][1] = new CarToken(CarToken.Type.MOVE, false);  board[13][2] = new CarToken(CarToken.Type.MOVE, false);  board[13][3] = new CarToken(CarToken.Type.MOVE, false);  board[13][4] = new CarToken(CarToken.Type.MOVE, false);  board[13][5] = new CarToken(CarToken.Type.MOVE, false);  board[13][6] = new CarToken(CarToken.Type.MOVE, false);  board[13][7] = new CarToken(CarToken.Type.MOVE, false);  board[13][8] = new CarToken(CarToken.Type.MOVE, false);  board[13][9] = new CarToken(CarToken.Type.MOVE, Player.Dir.LEFT);  board[13][10] = null; board[13][11] = null; board[13][12] = null; board[13][13] = new CarToken(CarToken.Type.MOVE, Player.Dir.RIGHT);  board[13][14] = new CarToken(CarToken.Type.MOVE, false);  board[13][15] = new CarToken(CarToken.Type.MOVE, false);  board[13][16] = new CarToken(CarToken.Type.MOVE, false);  board[13][17] = new CarToken(CarToken.Type.MOVE, false);  board[13][18] = new CarToken(CarToken.Type.MOVE, false);   board[13][19] = new CarToken(CarToken.Type.MOVE, Player.Dir.UP);  board[13][20] = null;
        }
        public static void changeActive(boolean b){
            isActive = b;
        }
        public static void AddTokenPixel(int xpixel,int ypixel) {
            
        Page.GetCurrPage().detect(xpixel + Window.getX(0),ypixel + Window.getY(0));    
            
        if (xpixel < 0 || xpixel > Window.getWidth2() || ypixel < 0 || 
           ypixel > Window.getHeight2())
            return;
        
        int currRow = 0;
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int currYVal = ydelta;
        while (ypixel > currYVal)
        {
            currRow++;
            currYVal += ydelta;
        }

        int currCol = 0;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        int currXVal = xdelta;
        while (xpixel > currXVal)
        {
            currCol++;
            currXVal += xdelta;
        }

        System.out.println(currRow + " " + currCol);
        
        return;
    }
   

        public static boolean detectSpinner(int xpixel,int ypixel){
            if (xpixel < 0 || xpixel > Window.getWidth2() || ypixel < 0 || 
           ypixel > Window.getHeight2())
            return false;
        
        int currRow = 0;
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int currYVal = ydelta;
        while (ypixel > currYVal)
        {
            currRow++;
            currYVal += ydelta;
        }

        int currCol = 0;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        int currXVal = xdelta;
        while (xpixel > currXVal)
        {
            currCol++;
            currXVal += xdelta;
        }
        if (currRow >= 4 && currRow <= 9 && currCol >= 11 && currCol <= 16)
            return true;
         System.out.println("checked");
        return false;
        }
        public static void Draw(Graphics2D g) {
          if(isActive)  
          { 
//Calculate the width and height of each board square.
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
       Image board =  Toolkit.getDefaultToolkit().getImage("./experimental board.png");    
        Drawing.drawImage(board, Window.getX(Window.getWidth2()/2), Window.getY(Window.getHeight2()/2), 0.0, 1.0, 1.0); 
                g.setColor(Color.black);
        g.setFont(new Font("Arial",Font.PLAIN,20));
        if(Player.getPlayer(0) != null){
        g.drawString("Player 1 = $" + Player.getPlayer(0).getMoney(), 25, Window.getY(Window.getHeight2())+30);
        if(Player.getPlayer(0).getJob() != null)
        g.drawString(Player.getPlayer(0).getJob().getName(), 25, Window.getY(Window.getHeight2())+60);
        Drawing.drawImage(Player.getPlayer(0).getCar(), Window.getX(xdelta * Player.getPlayer(0).getCol() + 13), Window.getY(ydelta * Player.getPlayer(0).getRow() + 13),Player.getPlayer(0).getRot(), 0.55, 0.55);
        }
        if(Player.getPlayer(1) != null){
        g.drawString("Player 2 = $" + Player.getPlayer(1).getMoney(), 275, Window.getY(Window.getHeight2())+30);
        if(Player.getPlayer(1).getJob() != null)
        g.drawString(Player.getPlayer(1).getJob().getName(), 275, Window.getY(Window.getHeight2())+60);
        Drawing.drawImage(Player.getPlayer(1).getCar(), Window.getX(xdelta * Player.getPlayer(1).getCol() + 39), Window.getY(ydelta * Player.getPlayer(1).getRow() + 13), Player.getPlayer(1).getRot(), 0.55, 0.55);
        }
        if(Player.getPlayer(2) != null){
        g.drawString("Player 3 = $" + Player.getPlayer(2).getMoney(), 575, Window.getY(Window.getHeight2())+30);
        if(Player.getPlayer(2).getJob() != null)
        g.drawString(Player.getPlayer(0).getJob().getName(), 575, Window.getY(Window.getHeight2())+60);
        Drawing.drawImage(Player.getPlayer(2).getCar(), Window.getX(xdelta * Player.getPlayer(2).getCol() + 13), Window.getY(ydelta * Player.getPlayer(2).getRow() + 39), Player.getPlayer(2).getRot(), 0.55, 0.55);
        }
        if(Player.getPlayer(3) != null){
        if(Player.getPlayer(3).getJob() != null)
        g.drawString(Player.getPlayer(3).getJob().getName(), 850, Window.getY(Window.getHeight2())+60);    
        g.drawString("Player 4 = $" + Player.getPlayer(3).getMoney(), 850, Window.getY(Window.getHeight2())+30);
        Drawing.drawImage(Player.getPlayer(3).getCar(), Window.getX(xdelta * Player.getPlayer(3).getCol() + 39), Window.getY(ydelta * Player.getPlayer(3).getRow() + 39), Player.getPlayer(3).getRot(), 0.55, 0.55);
        }
        
//        if (getCurrentPlayer.jobs)

        
        
         
 //Draw the grid.
        g.setColor(Color.black);
        for (int zi = 1;zi<NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
// displays the square's corresponding number
        if(showNumbers){
            int count = 1;
                for(int row = 0; row<NUM_ROWS;row++){
                    for (int column = 0;column<NUM_COLUMNS;column++){ 
                        g.setColor(Color.black);
            g.setFont(new Font("Arial",Font.PLAIN,15));
                    g.drawString( row +", " + column, Window.getX(column*xdelta), Window.getY(row*ydelta)+ydelta);
                    count++;
                }
            }
//
            for (int zi = 1;zi<NUM_COLUMNS;zi++)
            {
                g.drawLine(Window.getX(zi*xdelta),Window.getY(0),
                        Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
            }
        }
        Spinner.draw(g);
        }
          
    }

    public static void updateBoard(int carrow, int carcolumn){
            Player ptr = Player.getCurrentPlayer();
            board[ptr.getRow()][ptr.getCol()].slots[board[ptr.getRow()][ptr.getCol()].getCurrPlayerIndex()] = null;  
            board[carrow][carcolumn].addCar(ptr);
             ptr.update(carrow, carcolumn);
    } 
        
        
    public static boolean checkBoard(int row,int col){
        if( row >= NUM_ROWS || row < 0 || col >= NUM_COLUMNS || col < 0 || board[row][col] == null )
            return false;

        if(board[row][col].checkSlots())
            return true;        
//        if(board[row][col] != null)
//            return true;
        return false;
        }
       
    public static Player.Dir checkCurrTileDir(){
         Player ptr = Player.getCurrentPlayer();
         if(board[ptr.getRow()][ptr.getCol()].getDir() != null){
             return board[ptr.getRow()][ptr.getCol()].getDir();
         }
         return null;
    }
    public static CarToken.Type checkType(){
         Player ptr = Player.getCurrentPlayer();
         if(board[ptr.getRow()][ptr.getCol()].type != null){
             return board[ptr.getRow()][ptr.getCol()].type;
         }
         return null;
    }
    public static boolean ifActive(){
        return isActive;
    }
    public int getNumRows(){
        return NUM_ROWS;
    }
    public int getNumColumns(){
        return NUM_COLUMNS;
    }
}
