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
private static int previewIndex;
private Image image;
private ArrayList<Button> buttons = new ArrayList<Button>();
private static ArrayList<Page>pages = new ArrayList<Page>();
public static enum Tab{
    MENU, PLAY, PLAYERSELECT
}
private Tab type;
private static Page currPage;

public Button createButton(Button.Type _type,int _xpos, int _ypos, int _xsize, int _ysize){
    Button ptr = new Button(_type,_xpos,_ypos,_xsize,_ysize);
    buttons.add(ptr);
    return ptr;
}

public void addButton(Button button){
buttons.add(button);
}
Page(Tab _type, Image _image){
    image = _image;
    type = _type;
}
Page(Tab _type){
    type = _type;
}

public Image getImage(){
    return image;
}
public static void detect(int xpixel, int ypixel){
    
        for(Button ptr : currPage.buttons){
            if(xpixel >= ptr.getXPos() && xpixel <= ptr.getXPos2() && ypixel >= ptr.getYPos() && ypixel <= ptr.getYPos2()) 
                currPage = ptr.pressed(currPage);
        }
    
}
public static Page Create(Tab _type, Image _image){
    Page ptr = new Page(_type,  _image);
    pages.add(ptr);
    currPage = ptr;
    return ptr;
}
public static Page Create(Tab _type){
    Page ptr = new Page(_type);
    pages.add(ptr);
    currPage = ptr;
    return ptr;
}
 static void loadPage(Graphics2D g,Page page){    
     
 if(page.type == Tab.MENU){
     Drawing.drawImage(page.getImage(), Window.WINDOW_WIDTH/2, Window.WINDOW_HEIGHT/2, 0.0, 1, 1);
//comment this out later
     g.setColor(Color.red);
     for(Button ptr : page.buttons)    
       g.drawRect(ptr.getXPos(), ptr.getYPos(), ptr.getXSize(), ptr.getYSize());
 }
 else if(page.type == Tab.PLAY){
     
 }
 else if(page.type == Tab.PLAYERSELECT){ 
     Image list[] = Player.getCarList();
    Drawing.drawImage(page.getImage(), Window.WINDOW_WIDTH/2, Window.WINDOW_HEIGHT/2, 0.0, 1, 1);
    Drawing.drawImage(list[previewIndex], Window.WINDOW_WIDTH/2, Window.WINDOW_HEIGHT/2, 0.0, 1, 1);
     g.setColor(Color.red);
     for(Button ptr : page.buttons)    
       g.drawRect(ptr.getXPos(), ptr.getYPos(), ptr.getXSize(), ptr.getYSize());
 
 }
     
 }
 public static Page GetCurrPage(){
     return currPage;
 }
 public static void SetPage(Page page){
     currPage = page;
 }
 public static Page GetPage(Tab ref){
     for(Page ptr : pages){
         if(ptr.type == ref)
             return ptr;
     }
     return null;
 }
 public Tab getTab(){
     return type;
 }
 public  static void ChangePreviewIndex(int i){
     if(previewIndex + i < Player.getCarList().length)
     previewIndex += i;
 }
}
