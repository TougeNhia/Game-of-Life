package game.of.life;

import java.awt.*;

public class Spinner {
    final private int numMoves = 8;
    private static Image image = Toolkit.getDefaultToolkit().getImage("./Spinner.png");    
    private final static int NUM_ROWS = 14;
    private final static int NUM_COLUMNS = 21; 
    private static int move;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    private static double rot = 90;
    private static boolean on = false;
    private int xpos  = Window.getX(xdelta * 14)- (Drawing.getImageWidth(spinner)/2);
    private int ypos = Window.getY(ydelta * 7)- (Drawing.getImageHeight(spinner)/2);
    private int xsize = Window.getX(xdelta * 14) + (Drawing.getImageWidth(spinner)/2);
    private int ysize = Window.getY(ydelta * 7) + (Drawing.getImageHeight(spinner)/2);
    private static int ydelta = Window.getHeight2()/NUM_ROWS;
    private static int xdelta = Window.getWidth2()/NUM_COLUMNS;    
     public boolean collide(int xpixel, int ypixel){
         
         
         return true;
     }
=======
=======
>>>>>>> parent of 14e47bd... Spinner class changes
=======
>>>>>>> parent of 14e47bd... Spinner class changes
     
>>>>>>> parent of 14e47bd... Spinner class changes
    Spinner(){
        
<<<<<<< HEAD
<<<<<<< HEAD
    }
<<<<<<< HEAD
    public int getXPos(){
        return xpos;
    }
    public int getYPos(){
        return ypos;
    }
    public int getXSize(){
        return xsize;
    }
    public int getYSize(){
        return ysize;
    }
    public static Image getSpinner(){
        return spinner;
    }
    public static int getSec(){
        return sec;
=======
    public static void Spin(){
        move = (int)(Math.random()* 20) + 15;
        
>>>>>>> parent of 14e47bd... Spinner class changes
=======
    }
    public static void Spin(){
        move = (int)(Math.random()* 20) + 15;
        
>>>>>>> parent of 14e47bd... Spinner class changes
    }
=======
    }
    public static void Spin(){
        move = (int)(Math.random()* 20) + 15;
        
    }
>>>>>>> parent of 14e47bd... Spinner class changes
    public static Image getImage(){
        return image;
    }
    
    public static void draw(Graphics2D g){
<<<<<<< HEAD
       Drawing.drawImage(spinner, Window.getX(xdelta * 14), Window.getY(ydelta * 7), 0.0, 1.0, 1.0);
        Drawing.drawImage(arrow, Window.getX(xdelta * 14), Window.getY(ydelta * 7), rot, 1.0, 1.0);
=======
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        Drawing.drawImage(image, Window.getX(xdelta * 14), Window.getY(ydelta * 7), 0.0, 1.0, 1.0);
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 14e47bd... Spinner class changes
=======
>>>>>>> parent of 14e47bd... Spinner class changes
=======
>>>>>>> parent of 14e47bd... Spinner class changes
    }
}
