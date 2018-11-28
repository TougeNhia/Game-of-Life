package game.of.life;

import java.awt.*;

public class CarToken {
    private Color color;
    public Player slots[] = new Player[Player.getNumPlayers()];
    private Player car;
    private boolean eventCard;
    private boolean layered;
    private Player.Dir dir;
    private Player.Dir dir2;
    Type type;
    public static enum Type{ 
        MOVE, LAYERED,FORK,STOP,ACADEMIC,PAYDAY,END
    };
    CarToken(Type _type, boolean _eventCard){
        eventCard = _eventCard;
        type = _type;
        for(int i=0;i<slots.length;i++)
            slots[i] = null;
    }
    CarToken(Type _type, Player.Dir _dir){
        dir = _dir;
        type = _type;
        for(int i=0;i<slots.length;i++)
            slots[i] = null;
    }
    CarToken(Type _type, Player.Dir _dir, Player.Dir _dir2){
        dir = _dir;
        dir2 = _dir2;
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
    public Player.Dir getDir(){
        return dir;
    }
    public Player.Dir getDir2(){
        return dir2;
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
       for(Player ptr : slots){
        if(ptr == null)
            return true;
       }
        return false;
    }
    public void addCar(Player player){
        for(int i = 0; i<slots.length;i++){
            if(slots[i] == null){
               slots[i] = player;
                break;
            }
        }
    }
}
