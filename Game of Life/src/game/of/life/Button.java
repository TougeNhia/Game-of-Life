
package game.of.life;

import java.awt.*;

public class Button {
    private int xsize;
    private int ysize;
    private int xpos;
    private int ypos;
    private boolean isActive;
    private Type type;
    public static enum Type{
    PLAY,RULES,CONFIRM,CANCEL    
    }
    Button(Type _type,int _xpos, int _ypos, int _xsize, int _ysize){
    type = _type;
    xsize = _xsize;
    ysize = _ysize;
    xpos = _xpos;
    ypos = _ypos;
    }
    public boolean getActive(){
        return isActive;
    }
    public Page pressed(Page ptr){
        isActive = true;
        if(type == Type.PLAY){
            Board.changeActive(true);
            ptr = Page.GetPage(Page.Tab.PLAY);
        }
        
        return ptr;
    }
    int getXPos(){
        return xpos;
    }
    int getYPos(){
        return ypos;
    }
    int getXSize(){
        return xsize;
    }
    int getYSize(){
        return ysize;
    }
    public void drawHitBox(Graphics2D g){
        g.setColor(Color.red);
        g.drawRect(xpos, ypos, xsize, ysize);
    }
    
}
