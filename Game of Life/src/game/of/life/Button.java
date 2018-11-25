
package game.of.life;

import java.awt.*;

public class Button extends Page {
    private int xsize;
    private int ysize;
    private int xpos;
    private int ypos;
    private boolean isActive;
    Button(String name, Tab _tab, int _xsize, int _ysize, int _xpos, int _ypos){
    super(name, _tab);
    xsize = _xsize;
    ysize = _ysize;
    xpos = _xpos;
    ypos = _ypos;
    }
    public boolean getActive(){
        return isActive;
    }
    public void pressed(){
        if(isActive){
            
        }
    }
    public void drawHitBox(Graphics2D g){
        g.setColor(Color.red);
        g.drawRect(xpos, ypos, xsize, ysize);
    }
    
}
