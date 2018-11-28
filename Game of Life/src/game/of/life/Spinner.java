package game.of.life;

import java.awt.*;

public class Spinner {
    final static private int numMoves = 8;
    public static int coolDown;
    private static Image spinner = Toolkit.getDefaultToolkit().getImage("./Spinner.png");  
    private static Image arrow = Toolkit.getDefaultToolkit().getImage("./arrow.png"); 
    private final static int NUM_ROWS = 14;
    private final static int NUM_COLUMNS = 21; 
    private static int sec;
    private static double angle =45;
    private static double div = 2.5;
    private static int move;
    private static double rot;
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
     public static void Reset(){
        sec = 0;
        move = 0;
        rot = 90;
        on = false;    
     }
    Spinner(){
        sec = 0;
        move = 0;
        rot = 90;
        on = false;
    }
    public static void setOn(){
   //     if ()
        on = true;
        Spin();
    }
    public static int Spin(){
        sec = (int)((Math.random()* 2)+1);
        //div *= sec;
        return sec;
    }
    public static void testSpin(){
        
        int moves = 4;
        Player.getCurrentPlayer().changeMoves(moves);
        Player.getCurrentPlayer().setSpun(true);
        System.out.println("cheated");
    }
    public static void MoveArrow(int _timecount, double fps){
        if(Player.getCurrentPlayer().hasSpun())
            return;
//        
//        while (_timecount > move){
//            move++;
//        }
//        for (int i = 0; i < move; i++){

//        }
//        boolean keepLooping = true;
//            if (rot == 0 || rot == 45 || rot == 90 || rot == 135 || rot == 180 || rot == 225 || rot == 270 || rot == 315 ||  rot == 360){
//                while (keepLooping)
//                    for (int i = 0; i < move; i++){
//                        rot += 22.5;
//                        if(rot >= 360)
//                            rot = 0;                    
//                        if (rot != 0 || rot != 45 || rot != 90 || rot != 135 || rot != 180 || rot != 225 || rot != 270 || rot != 315 ||  rot != 360){
//                            keepLooping = false;
//                            break;
//                        }
//                    }
//            keepLooping = false;    
//            }rot += 22.5;       
//            if(rot >= 360)
//                rot = 0;     
            rot += angle/div;
            if(rot >= 360)
                rot = 0;
            if(_timecount % fps == fps-1){
            sec--;    
            div *= 2;
            }

        if(sec <= 0){
         div = 2.5;
        on = false;
        int moves = 0;
        int test = 45;
        for(int i = 0; i < numMoves;i++){
            if(rot >= (test - test) && rot <= test){
               if(i == 0)
                   moves = 8;
                break; 
            }
            moves++;
            test+=45;
        }
       // System.out.println("rot: " + rot);
        Player.getCurrentPlayer().changeMoves(moves);
        Player.getCurrentPlayer().setSpun(true);
//        System.out.println("moves: " + Player.getCurrentPlayer().getMoves());
        }
    }
    public static void setMoves(){
        
    }
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
    }
    public static boolean getOn(){
        return on;
    }
    public static void draw(Graphics2D g){
       Drawing.drawImage(spinner, Window.getX(xdelta * 14), Window.getY(ydelta * 7), 0.0, 1.0, 1.0);
        Drawing.drawImage(arrow, Window.getX(xdelta * 14), Window.getY(ydelta * 7), rot, 1.0, 1.0);
    }
}
