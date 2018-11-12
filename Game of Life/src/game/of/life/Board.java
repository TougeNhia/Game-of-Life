package game.of.life;

import java.awt.*;

public class Board {
    //updated
    private final static int NUM_ROWS = 14;
    private final static int NUM_COLUMNS = 21;      
    private static CarToken car[][] = new CarToken[NUM_ROWS][NUM_COLUMNS];
    private static boolean board[][];
    
        Board(){ 
            board[0][0] = false;  board[0][1] = true;   board[0][2] = true;   board[0][3] = true;   board[0][4] = true;   board[0][5] = true;   board[0][6] = true;   board[0][7] = true;   board[0][8] = true;   board[0][9] = false;  board[0][10] = true;   board[0][11] = true;   board[0][12] = true;   board[0][13] = true;   board[0][14] = true;   board[0][15] = false;  board[0][16] = true;   board[0][17] = true;   board[0][18] = true;    board[0][19] = true;   board[0][20] = true;
            board[1][0] = true;   board[1][1] = true;   board[1][2] = false;  board[1][3] = false;  board[1][4] = false;  board[1][5] = false;  board[1][6] = false;  board[1][7] = false;  board[1][8] = true;   board[1][9] = false;  board[1][10] = true;   board[1][11] = false;  board[1][12] = false;  board[1][13] = false;  board[1][14] = true;   board[1][15] = false;  board[1][16] = true;   board[1][17] = true;   board[1][18] = false;   board[1][19] = false;  board[1][20] = true;
            board[2][0] = true;   board[2][1] = false;  board[2][2] = true;   board[2][3] = true;   board[2][4] = true;   board[2][5] = false;  board[2][6] = true;   board[2][7] = true;   board[2][8] = true;   board[2][9] = false;  board[2][10] = true;   board[2][11] = false;  board[2][12] = false;  board[2][13] = false;  board[2][14] = true;   board[2][15] = false;  board[2][16] = false;  board[2][17] = true;   board[2][18] = false;   board[2][19] = false;  board[2][20] = true;
            board[3][0] = true;   board[3][1] = false;  board[3][2] = true;   board[3][3] = false;  board[3][4] = true;   board[3][5] = false;  board[3][6] = true;   board[3][7] = false;  board[3][8] = true;   board[3][9] = false;  board[3][10] = true;   board[3][11] = false;  board[3][12] = false;  board[3][13] = false;  board[3][14] = true;   board[3][15] = true;   board[3][16] = true;   board[3][17] = true;   board[3][18] = false;   board[3][19] = false;  board[3][20] = true;
            board[4][0] = true;   board[4][1] = false;  board[4][2] = true;   board[4][3] = false;  board[4][4] = true;   board[4][5] = false;  board[4][6] = true;   board[4][7] = false;  board[4][8] = true;   board[4][9] = false;  board[4][10] = true;   board[4][11] = false;  board[4][12] = false;  board[4][13] = false;  board[4][14] = false;  board[4][15] = false;  board[4][16] = false;  board[4][17] = false;  board[4][18] = true;    board[4][19] = true;   board[4][20] = true;
            board[5][0] = true;   board[5][1] = false;  board[5][2] = true;   board[5][3] = false;  board[5][4] = true;   board[5][5] = false;  board[5][6] = true;   board[5][7] = false;  board[5][8] = true;   board[5][9] = false;  board[5][10] = true;   board[5][11] = false;  board[5][12] = false;  board[5][13] = false;  board[5][14] = false;  board[5][15] = false;  board[5][16] = false;  board[5][17] = false;  board[5][18] = true;    board[5][19] = false;  board[5][20] = true;
            board[6][0] = true;   board[6][1] = false;  board[6][2] = true;   board[6][3] = false;  board[6][4] = true;   board[6][5] = true;   board[6][6] = true;   board[6][7] = false;  board[6][8] = true;   board[6][9] = false;  board[6][10] = true;   board[6][11] = false;  board[6][12] = false;  board[6][13] = false;  board[6][14] = false;  board[6][15] = false;  board[6][16] = false;  board[6][17] = true;   board[6][18] = true;    board[6][19] = false;  board[6][20] = true;
            board[7][0] = true;   board[7][1] = false;  board[7][2] = true;   board[7][3] = false;  board[7][4] = false;  board[7][5] = false;  board[7][6] = true;   board[7][7] = true;   board[7][8] = true;   board[7][9] = false;  board[7][10] = true;   board[7][11] = false;  board[7][12] = false;  board[7][13] = false;  board[7][14] = false;  board[7][15] = false;  board[7][16] = false;  board[7][17] = true;   board[7][18] = true;    board[7][19] = false;  board[7][20] = true;
            board[8][0] = true;   board[8][1] = true;   board[8][2] = true;   board[8][3] = true;   board[8][4] = true;   board[8][5] = false;  board[8][6] = false;  board[8][7] = false;  board[8][8] = false;  board[8][9] = false;  board[8][10] = true;   board[8][11] = false;  board[8][12] = false;  board[8][13] = false;  board[8][14] = false;  board[8][15] = false;  board[8][16] = false;  board[8][17] = false;  board[8][18] = true;    board[8][19] = false;  board[8][20] = true;
            board[9][0] = false;  board[9][1] = false;  board[9][2] = true;   board[9][3] = false;  board[9][4] = true;   board[9][5] = false;  board[9][6] = false;  board[9][7] = false;  board[9][8] = false;  board[9][9] = false;  board[9][10] = true;   board[9][11] = false;  board[9][12] = false;  board[9][13] = false;  board[9][14] = false;  board[9][15] = false;  board[9][16] = false;  board[9][17] = false;  board[9][18] = true;    board[9][19] = true;   board[9][20] = true;
            board[10][0] = false; board[10][1] = false; board[10][2] = true;  board[10][3] = false; board[10][4] = true;  board[10][5] = true;  board[10][6] = true;  board[10][7] = true;  board[10][8] = true;  board[1][9] = true;   board[1][10] = true;   board[10][11] = true;  board[10][12] = true;  board[10][13] = false; board[10][14] = false; board[10][15] = true;  board[10][16] = false; board[10][17] = false; board[10][18] = false;  board[10][19] = false; board[10][20] = false;
            board[11][0] = true;  board[11][1] = true;  board[11][2] = true;  board[11][3] = false; board[11][4] = false; board[11][5] = false; board[11][6] = false; board[11][7] = false; board[11][8] = false; board[11][9] = false; board[11][10] = true;  board[11][11] = false; board[11][12] = true;  board[11][13] = false; board[11][14] = false; board[11][15] = true;  board[11][16] = true;  board[11][17] = true;  board[11][18] = true;   board[11][19] = true;  board[11][20] = false;
            board[12][0] = true;  board[12][1] = false; board[12][2] = false; board[12][3] = false; board[12][4] = false; board[12][5] = false; board[12][6] = false; board[12][7] = false; board[12][8] = false; board[12][9] = true;  board[12][10] = true;  board[12][11] = false; board[12][12] = true;  board[12][13] = true;  board[12][14] = false; board[12][15] = false; board[12][16] = false; board[12][17] = false; board[12][18] = false;  board[12][19] = true;  board[12][20] = false;
            board[13][0] = true;  board[13][1] = true;  board[13][2] = true;  board[13][3] = true;  board[13][4] = true;  board[13][5] = true;  board[13][6] = true;  board[13][7] = true;  board[13][8] = true;  board[13][9] = true;  board[13][10] = false; board[13][11] = false; board[13][12] = false; board[13][13] = true;  board[13][14] = true;  board[13][15] = true;  board[13][16] = true;  board[13][17] = true;  board[13][18] = true;   board[13][19] = true;  board[13][20] = false;
        }
    
        public static void AddTokenPixel(int xpixel,int ypixel) {

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
        System.out.println(currCol + " " + currRow);
        
        return;
    }
    
        public static void Draw(Graphics2D g) {
//Calculate the width and height of each board square.
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        Image board =  Toolkit.getDefaultToolkit().getImage("./board.png");    
        //Image playerCar1 = Toolkit.getDefaultToolkit().getImage("./board.png");  
//        if (getCurrentPlayer.jobs)
        //Drawing.drawImage(playerCar1, Window.getX(xdelta * 17), Window.getY(ydelta * 6), 0.0, 1.0, 1.0);
        Drawing.drawImage(board, Window.getX(Window.getWidth2()/2), Window.getY(Window.getHeight2()/2), 0.0, 1.0, 1.0);
 //Draw the grid.
        g.setColor(Color.black);
        for (int zi = 1;zi<NUM_ROWS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
        }
        
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),
                    Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
        }
    }
}
