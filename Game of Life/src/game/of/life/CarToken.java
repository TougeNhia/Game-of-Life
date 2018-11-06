package game.of.life;

import java.awt.*;

public class CarToken {
    private Color color;
    CarToken(Color _color){
        color = _color;
    }
    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta) {
        g.setColor(color); 
        
    }
}
