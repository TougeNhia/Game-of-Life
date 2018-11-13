package game.of.life;

import java.awt.*;

public class CarToken {
    private Color color;
    private Player slots[] = new Player[Player.getNumPlayers()];
    private Player car;
    CarToken(Color _color){
        color = _color;
        for(int i=0;i<slots.length;i++)
            slots[i] = null;
    }
    public void draw(Graphics2D g,int row,int column,int xdelta,int ydelta) {
        g.setColor(color); 
        g.fillRect(Window.getX(column*xdelta),Window.getY(row*ydelta),xdelta,ydelta); 
        
    }
    public Player getSlot(int i){
        return slots[i];
    }
    public Player getCurrPlayerSlot(){
        int i = 0;
        for(i = 0; i<slots.length;i++){
            if(slots[i] == Player.getCurrentPlayer())
                break;
        }
        return slots[i];
    }
}
