package game.of.life;

import java.awt.*;

public class CarToken {
    private Color color;
    public Player slots[] = new Player[Player.getNumPlayers()];
    private Player car;
    private boolean eventCard;
    Type type;
    public static enum Type{ 
        MOVE, LAYERED
    };
    CarToken(Type _type, boolean _eventCard){
        eventCard = _eventCard;
        type = _type;
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
    public int getCurrPlayerIndex(){
                int i = 0;
        for(i = 0; i<slots.length;i++){
            if(slots[i] == Player.getCurrentPlayer())
                break;
        }
        return i;
    }
    public boolean checkSlots(){
        if(slots[0] != null)
            return true;
        return false;
    }
    public void addCar(Player player){
        for(Player ptr: slots){
            if(ptr == null){
                ptr = player;
                break;
            }
        }
    }
}
