package game.of.life;

import java.awt.*;

public class Spinner {
    final private int numMoves = 8;
    private Image image = Toolkit.getDefaultToolkit().getImage("./Spinner.png");    
    
    Spinner(){
        
    }
    
    int Spin(){
    return ((int)(Math.random()*numMoves)+1);
    }
    
    public void draw(Graphics2D g, int xpos, int ypos){
        
        Drawing.drawImage(image, xpos, ypos, 0.0, 1.0, 1.0);
    }
}
