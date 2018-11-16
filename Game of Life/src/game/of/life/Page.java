/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.of.life;
import java.awt.*;
/**
 *
 * @author 146004429
 */
public class Page {
private String name;
private Tab tab;
private Image image;
public static enum Tab{
    MENU, PLAY, PLAYERSELECT
}

Page(String _name, Tab _tab){
    tab = _tab;
    name = _name;
    
}
//public static void Create(Tab tab){
//    if(tab == Tab.MENU){
//        Drawing.drawImage(image, Window.getX(0), Window.getY(0), 0.0, 1, 1);
//    }
//}


}
