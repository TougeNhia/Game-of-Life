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
private final static int EXITBUTTON = 0;
private final static int START = 1;
private static ArrayList<Player> tempList = new ArrayList<>();
private static int previewIndex;
private static int selectedPlayer;
private Image image;
private ArrayList<Button> buttons = new ArrayList<Button>();
private static ArrayList<Page>pages = new ArrayList<Page>();
private static ArrayList<Button>elements = new ArrayList<Button>();
public static enum Tab{
    MENU, PLAY, PLAYERSELECT,RULES
}
private static boolean eventCard;
private Tab type;
private static Page currPage;

public Button createButton(Button.Type _type,int _xpos, int _ypos, int _xsize, int _ysize){
    Button ptr = new Button(_type,_xpos,_ypos,_xsize,_ysize);
    buttons.add(ptr);
    return ptr;
}
public Button createElem(Button.Type _type,int _xpos, int _ypos, int _xsize, int _ysize){
    Button ptr = new Button(_type,_xpos,_ypos,_xsize,_ysize);
    elements.add(ptr);
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
        for(Button ptr : currPage.elements){
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
//         for(Button ptr: page.buttons)
//         g.drawRect(ptr.getXPos(), ptr.getYPos(), ptr.getXSize(), ptr.getYSize());     
         if(eventCard)
            loadCard(g);
         
     

     
 }
 else if (page.type == Tab.RULES){
 Drawing.drawImage(page.getImage(), Window.WINDOW_WIDTH/2, Window.WINDOW_HEIGHT/2, 0.0, 1, 1);
 for(Button ptr: page.buttons)
     g.drawRect(ptr.getXPos(), ptr.getYPos(), ptr.getXSize(), ptr.getYSize());
 }
 else if(page.type == Tab.PLAYERSELECT){ 
     Image list[] = Player.getCarList();
     ArrayList<Player> plist = Player.getTList();
     
    Drawing.drawImage(page.getImage(), Window.WINDOW_WIDTH/2, Window.WINDOW_HEIGHT/2, 0.0, 1, 1);
    Drawing.drawImage(list[previewIndex], Window.WINDOW_WIDTH/2, 2*Window.WINDOW_HEIGHT/5, 0.0, 2, 2);
    if(plist.size() > 0){
    for(int i= 0;i<plist.size();i++)
        Drawing.drawImage(plist.get(i).getCar(), (1+i)*Window.WINDOW_WIDTH/5, 4*Window.WINDOW_HEIGHT/5, 0.0, 1, 1);
    }
//    if(plist.get(0) !=null)
//    Drawing.drawImage(Player.getPlayer(0).getCar(), Window.WINDOW_WIDTH/5, 4*Window.WINDOW_HEIGHT/5, 0.0, 1, 1);
//    
//    if(plist.get(1) != null)
//    Drawing.drawImage(Player.getPlayer(1).getCar(), 2*Window.WINDOW_WIDTH/5, 4*Window.WINDOW_HEIGHT/5, 0.0, 1, 1);
//    
//    if(plist.get(2) !=null)
//    Drawing.drawImage(Player.getPlayer(2).getCar(), 3*Window.WINDOW_WIDTH/5, 4*Window.WINDOW_HEIGHT/5, 0.0, 1, 1);
//    
//    if(plist.get(3) !=null)
//    Drawing.drawImage(Player.getPlayer(3).getCar(), 4*Window.WINDOW_WIDTH/5, 4*Window.WINDOW_HEIGHT/5, 0.0, 1, 1);
    
    g.setFont(new Font("Arial",Font.BOLD,30));
    Drawing.drawString(g, "Choosing: Player " + (selectedPlayer+1),460 ,190 );
    
    g.setColor(Color.red);
     for(Button ptr : page.buttons)
       g.drawRect(ptr.getXPos(), ptr.getYPos(), ptr.getXSize(), ptr.getYSize());
 }
 
     
 }
 public static void loadElm(Graphics2D g,Page page){
    if(page.type == Tab.PLAY){ 
         if(eventCard){
            loadCard(g);
            Board.pause = true;
         }  
    }
    else if (page.type == Tab.PLAYERSELECT){
        Drawing.drawImage(Toolkit.getDefaultToolkit().getImage("./Play Button.png") , 1042, 844, 0.0, 1, 1);
        Drawing.drawImage(Toolkit.getDefaultToolkit().getImage("./Play Button Muted.png") , 1042, 844, 0.0, 1, 1);
        Button ptr = elements.get(START);
        g.drawRect(ptr.getXPos(), ptr.getYPos(), ptr.getXSize(), ptr.getYSize());
    }
     
  
 }
 public static void loadCard(Graphics2D g){
   Drawing.drawImage(Toolkit.getDefaultToolkit().getImage("./Event Box.png" ),  Window.WINDOW_WIDTH/2, Window.WINDOW_HEIGHT/2, 0.0, 1, 1);
   Drawing.drawImage(Toolkit.getDefaultToolkit().getImage("./ExitButton.png" ),  354, 278, 0.0, 1, 1); // x+30 , y+50
   
   
   Button ptr = elements.get(EXITBUTTON);
   g.drawRect(ptr.getXPos(), ptr.getYPos(), ptr.getXSize(), ptr.getYSize());
   if(Cards.getEvent().getKarma() == Cards.BAD)
        g.setColor(Color.red);
   
   else if(Cards.getEvent().getKarma() == Cards.GOOD)
        g.setColor(Color.green);    
   
   g.setFont(new Font("Arial",Font.BOLD,45));
   g.drawString(Cards.getEvent().getName(), 508-(5*Cards.getEvent().getName().length()), 305);
   
   g.setFont(new Font("Arial",Font.PLAIN,30));
   g.setColor(Color.black);
   Drawing.drawString(g,Cards.getEvent().getDesc(), 399, 314);
 //  System.out.println("loaded event");
 }
 public static void eventStat(boolean b){
     eventCard = b;
 }
 public static boolean event(){
     return eventCard;
 }
 public static Page GetCurrPage(){
     return currPage;
 }
 public static void SetPage(Page page){
     currPage = page;
 }
 public int getPlayerIndex(){
     return selectedPlayer;
 }
 public static int getPreviewIndex(){
     return previewIndex;
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
     if( previewIndex + i >= 0 && previewIndex + i < Player.getCarList().length)
     previewIndex += i;
 }
  public  static void ChangePlayerIndex(int i){
     if( selectedPlayer + i >= 0 && selectedPlayer + i < Player.getCarList().length)
     selectedPlayer += i;
 }
}
