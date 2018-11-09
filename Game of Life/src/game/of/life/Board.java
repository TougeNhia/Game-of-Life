package game.of.life;

import java.awt.*;

public class Board {
    private final static int NUM_ROWS = 14;
    private final static int NUM_COLUMNS = 21;      
    private static CarToken board[][] = new CarToken[NUM_ROWS][NUM_COLUMNS];
    
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
            Image image =  Toolkit.getDefaultToolkit().getImage("./board.png");    
            Drawing.drawImage(image, Window.getX(Window.getWidth2()/2), Window.getY(Window.getHeight2()/2), 0.0, 1.0, 1.0);
//Calculate the width and height of each board square.
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
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
