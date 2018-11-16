<<<<<<< current
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.of.life;

import java.awt.*;

public class Button extends Page {
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
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.of.life;

import java.awt.*;

public class Button extends Page {
    private Image image;
    private int xpos  = Window.getX(xdelta * 14)- (Drawing.getImageWidth(image)/2);
    private int ypos = Window.getY(ydelta * 7)- (Drawing.getImageHeight(image)/2);
    private int xsize = Window.getX(xdelta * 14) + (Drawing.getImageWidth(image)/2);
    private int ysize = Window.getY(ydelta * 7) + (Drawing.getImageHeight(image)/2);
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
>>>>>>> before discard
