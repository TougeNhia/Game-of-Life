package game.of.life;

import java.awt.*;

public class Spinner {
    final private int numMoves = 10;
    private static Image image = Toolkit.getDefaultToolkit().getImage("./Spinner.png");    
    Spinner(){
        
    }
    
    int Spin(){
    return ((int)(Math.random()*10)+1);
    }
    public static Image getImage(){
        return image;
    }
    
    public static void draw(Graphics2D g, int xpos, int ypos){
        
        Drawing.drawImage(getImage(), xpos, ypos, 0.0, 1.0, 1.0);
    }
}
