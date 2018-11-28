package game.of.life;

import java.awt.*;
import java.util.ArrayList;

public class Button {
    private int xsize;
    private int ysize;
    private int xpos;
    private int ypos;
    private boolean isActive;
    public boolean toggle;
    public static boolean college;
    private Type type;
    public static enum Type{
    PLAY,RULES,CONFIRM,CANCEL, RIGHT, LEFT,BOOLEAN   
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
        ArrayList<Player> plist = Player.getTList();
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
        if(type == Type.RIGHT){
           Page.ChangeRulesIndex(+1);
        }
        else if(type == Type.LEFT){
            Page.ChangeRulesIndex(-1);
        }
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
                
                if(Page.getPlayerIndex() < Player.getNumPlayers()){
                    Player player = null;
                    if(college)
                        player = Player.addPlayer(list[Page.getPreviewIndex()],college);    
                    else
                        player = Player.addPlayer(list[Page.getPreviewIndex()]);    
                    player.setCar(list[Page.getPreviewIndex()]);
                    Page.ChangePlayerIndex(1);
                    college = false;
                }

                }            
            //starts the game
            else if(type == Type.PLAY && plist.size() > 1){
                
                Player.Merge();
                ptr = Page.GetPage(Page.Tab.PLAY);
                GameOfLife.setStart(true);
            }
            else if(type == Type.BOOLEAN){
                college = !college;
            }
            }

        
        //closing an event card
        else if(ptr.getTab() == Page.Tab.PLAY){
            if(type == Type.CANCEL && toggle){
                Cards.doAfter();
                Spinner.coolDown = 15;
                toggle = false;
                Page.eventStat(false);
                Board.pause = false;
                Cards.reason = 0;
                if(Player.getCurrentPlayer().getMoves() == 0)
                Player.switchTurns();
//                if(Cards.reason == Cards.CAREER && Player.DAY == -1){
//                    if(Player.getIndexOf(Player.getCurrentPlayer())+1 < Player.getNumPlayers()){
//                    Player tRay[] = Player.getPlrArray();
//                    Cards.careerRoll(tRay[Player.getIndexOf(Player.getCurrentPlayer())+1]);
//                    Player.switchTurns();
//                    }
//               }
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
