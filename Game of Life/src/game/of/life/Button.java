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
    PLAY,RULES,CONFIRM,CANCEL, RIGHT, LEFT    
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
        System.out.println("pressed");
        isActive = true;
        if(ptr.getTab() == Page.Tab.MENU){
            if(type == Type.PLAY){
//                Board.changeActive(true);
//                ptr = Page.GetPage(Page.Tab.PLAY);
                  ptr = Page.GetPage(Page.Tab.PLAYERSELECT);
            }
            else if (type == Type.RULES){
                ptr = Page.GetPage(Page.Tab.RULES);
            }
        }
        else if(ptr.getTab() == Page.Tab.RULES){
            if(type == Type.CANCEL){
               ptr =  Page.GetPage(Page.Tab.MENU);
            }
//        if(type == Type.RIGHT){
//           
//        }
//        else if(type == Type.LEFT){
//            
//        }
        }
        
        else if(ptr.getTab() == Page.Tab.PLAYERSELECT){
            if(type == Type.CANCEL){
                ptr =  Page.GetPage(Page.Tab.MENU);
            }    
            if(type == Type.RIGHT){
                Page.ChangePreviewIndex(1);
            }
            else if(type == Type.LEFT){
                Page.ChangePreviewIndex(-1);
            }
            else if (type == Type.CONFIRM){
                Image list[] = Player.getCarList();
                Player player = Player.addPlayer(list[Page.getPreviewIndex()]);
                player.setCar(list[Page.getPreviewIndex()]);
                Page.ChangePlayerIndex(1);
            }
            else if(type == Type.PLAY){
                Player.Merge();
                Board.changeActive(true);
                ptr = Page.GetPage(Page.Tab.PLAY);
                GameOfLife.setStart(true);
            }
        }
        //closing an event card
        else if(ptr.getTab() == Page.Tab.PLAY){
            if(type == Type.CANCEL){
                Page.eventStat(false);
                Board.pause = false;
            }
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
    int getXPos2(){
        return(xpos + xsize); 
    }
    int getYPos2(){
        return(ypos + ysize); 
    }
}
