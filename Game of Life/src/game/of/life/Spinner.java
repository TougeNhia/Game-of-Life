package game.of.life;

import java.awt.*;

public class Spinner {
    final private int numMoves = 8;
    private static Image spinner = Toolkit.getDefaultToolkit().getImage("./Spinner.png");  
    private static Image arrow = Toolkit.getDefaultToolkit().getImage("./arrow.png"); 
    private final static int NUM_ROWS = 14;
    private final static int NUM_COLUMNS = 21; 
    private static int sec;
    private static int move;
    private static double rot = 90;
    private static boolean on = false;
     
    Spinner(){
        sec = 0;
        move = 0;
        rot = 90;
        on = false;
    }
    public static void setOn(){
   //     if ()
        on = true;
    }
    public static int Spin(){
        sec = (int)(Math.random()* 5);
        return sec;
    }
    public static void MoveArrow(int _timecount){
        while (_timecount > move){
            move++;
        }
        for (int i = 0; i < move; i++){
            rot += 22.5;
        }
        boolean keepLooping = true;
            if (rot == 0 || rot == 90 || rot == 180 || rot == 360){
                while (keepLooping)
                    for (int i = 0; i < move; i++){
                    rot += 22.5;
                        if (rot != 0 || rot != 90 || rot != 180 || rot != 360){
                            keepLooping = false;
                        }
                    }
            keepLooping = false;    
            }
        
        on = false;
    }
    public static Image getSpinner(){
        return spinner;
    }
    public static int getSec(){
        return sec;
    }
    public static boolean getOn(){
        return on;
    }
    public static void draw(Graphics2D g){
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        Drawing.drawImage(spinner, Window.getX(xdelta * 14), Window.getY(ydelta * 7), 0.0, 1.0, 1.0);
        Drawing.drawImage(arrow, Window.getX(xdelta * 14), Window.getY(ydelta * 7), rot, 1.0, 1.0);
    }
}
