package game.of.life;

import java.awt.*;

public class Spinner {
    final private int numMoves = 8;
    private static Image image = Toolkit.getDefaultToolkit().getImage("./Spinner.png");    
    private final static int NUM_ROWS = 14;
    private final static int NUM_COLUMNS = 21; 
    private static int move;
     
    Spinner(){
        
    }
    public static void Spin(){
        move = (int)(Math.random()* 20) + 15;
        
    }
    public static Image getImage(){
        return image;
    }
    
    public static void draw(Graphics2D g){
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        Drawing.drawImage(image, Window.getX(xdelta * 14), Window.getY(ydelta * 7), 0.0, 1.0, 1.0);
    }
}
