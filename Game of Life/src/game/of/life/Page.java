/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.of.life;
import java.awt.*;
import java.util.ArrayList;
/**
 *
 * @author 146004429
 */
public class Page {
private String name;
private Tab tab;
private Image image;
private ArrayList<Button> buttons;
public static enum Tab{
    MENU, PLAY, PLAYERSELECT
}
public static Tab currPage;

Page(String _name, Tab _tab){
    tab = _tab;
    name = _name;
    
}
public Tab getTab(){
    return tab;
}
public Image getImage(){
    return image;
}
public static void Create(Page page, Tab tab){
    if(tab == Tab.MENU){
        Drawing.drawImage(page.getImage(), Window.getX(0), Window.getY(0), 0.0, 1, 1);
    }
    if(page.getTab() == Tab.PLAYERSELECT){
        Drawing.drawImage(page.getImage(), Window.getX(0), Window.getY(0), 0.0, 1, 1);
  //      buttons.add();
    }
}


}
