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
public static ArrayList<String>rules = new ArrayList();    
public static ArrayList<Image>rulePics = new ArrayList();    
public static int rulesIndex;    
public final static int EXITBUTTON = 0;
public final static int START = 1;
private static ArrayList<Player> tempList = new ArrayList<>();
private static int previewIndex;
private static int selectedPlayer;
private Image image;
private ArrayList<Button> buttons = new ArrayList<Button>();
private static ArrayList<Page>pages = new ArrayList<Page>();
private static ArrayList<Button>elements = new ArrayList<Button>();
//private static Player prePlayers[] = new Player[4];
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
public static void Init(){
rules.add(new String("1. In the player select menu you can choose the color of your car,\n"
        + "and choose wether to start the game in college."));     
rules.add(new String("2. College adds a 1.5x bonus to your salary, lets you choose from\n"
        + " 3 jobs instead of being given one, but has to start with $1500."));

rulePics.add(Toolkit.getDefaultToolkit().getImage("./Capture 2.png"));
rulePics.add(Toolkit.getDefaultToolkit().getImage("./Capture 1.png"));
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
     
 }

 else if (page.type == Tab.RULES){
     //format the rules like this, 
 Drawing.drawImage(page.getImage(), Window.WINDOW_WIDTH/2, Window.WINDOW_HEIGHT/2, 0.0, 1, 1);
 if(rulesIndex < rulePics.size() && rulePics.get(rulesIndex) != null){
 Drawing.drawImage(rulePics.get(rulesIndex),Window.WINDOW_WIDTH/2, 2*Window.WINDOW_HEIGHT/5+30,0.0,0.6,0.6);
 System.out.println(rulePics.size()-1);
 }
  g.setFont(new Font("Arial",Font.PLAIN,25));
   g.setColor(Color.black);
 Drawing.drawString(rules.get(rulesIndex), 193, 552);
 for(Button ptr: page.buttons)
     g.drawRect(ptr.getXPos(), ptr.getYPos(), ptr.getXSize(), ptr.getYSize());
 }
 else if(page.type == Tab.PLAYERSELECT){ 
     Image list[] = Player.getCarList();
     ArrayList<Player> plist = Player.getTList();
     
    Drawing.drawImage(page.getImage(), Window.WINDOW_WIDTH/2, Window.WINDOW_HEIGHT/2, 0.0, 1, 1);
    Drawing.drawImage(list[previewIndex], Window.WINDOW_WIDTH/2, 2*Window.WINDOW_HEIGHT/5, 0.0, 2, 2);
    if(plist.size() > 0){
    for(int i= 0;i<plist.size();i++){
        Drawing.drawImage(plist.get(i).getCar(), (1+i)*Window.WINDOW_WIDTH/5, 4*Window.WINDOW_HEIGHT/5, 0.0, 1, 1);
    }
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
    if(selectedPlayer >= 4)
    Drawing.drawString("Choosing: Player " + (selectedPlayer),460 ,190 );    
    else    
    Drawing.drawString("Choosing: Player " + (selectedPlayer+1),460 ,190 );
    
    g.setColor(Color.red);
     for(Button ptr : page.buttons)
       g.drawRect(ptr.getXPos(), ptr.getYPos(), ptr.getXSize(), ptr.getYSize());
 }
 
     
 }
 public static void loadElm(Graphics2D g,Page page){
    if(page.type == Tab.PLAY){ 
         if(eventCard){
            loadCard(g,Cards.reason);
            Board.pause = true;
         }  
    }
    else if (page.type == Tab.PLAYERSELECT){
        ArrayList<Player> plist = Player.getTList();
          int preview = Cards.getPreview();
        if(plist.size() > 1)
        Drawing.drawImage(Toolkit.getDefaultToolkit().getImage("./Play Button.png") , 1042, 844, 0.0, 1, 1);
        Drawing.drawImage(Toolkit.getDefaultToolkit().getImage("./Play Button Muted.png") , 1042, 844, 0.0, 1, 1);
        Button ptr = elements.get(START);
        g.drawRect(ptr.getXPos(), ptr.getYPos(), ptr.getXSize(), ptr.getYSize());
        if(Button.college)
            Drawing.drawImage(Toolkit.getDefaultToolkit().getImage("./CollegeYES.png") , 175, 543, 0.0, 1, 1);
        else
            Drawing.drawImage(Toolkit.getDefaultToolkit().getImage("./CollegeNO.png") , 175, 543, 0.0, 1, 1);
    }
     
  
 }
 public static void loadCard(Graphics2D g,int cause){
   Drawing.drawImage(Toolkit.getDefaultToolkit().getImage("./Event Box.png" ),  Window.WINDOW_WIDTH/2, Window.WINDOW_HEIGHT/2, 0.0, 1, 1);
   Drawing.drawImage(Toolkit.getDefaultToolkit().getImage("./ExitButton.png" ),  354, 278, 0.0, 1, 1); // x+30 , y+50
  
  
   if(cause == Cards.EVENT){
   Button ptr = elements.get(EXITBUTTON);
   ptr.toggle = true;
   g.drawRect(ptr.getXPos(), ptr.getYPos(), ptr.getXSize(), ptr.getYSize());
   
   g.setFont(new Font("Arial",Font.BOLD,50));
   g.setColor(Color.WHITE);
   g.drawString("Player " + (Player.getIndexOf(Player.getCurrentPlayer())+1) + " Was...", 365, 200);
   
   if(Cards.getEvent().getKarma() == Cards.BAD)
        g.setColor(Color.red);
   
   else if(Cards.getEvent().getKarma() == Cards.GOOD)
        g.setColor(Color.green);    
   
   g.setFont(new Font("Arial",Font.BOLD,45));
   g.drawString(Cards.getEvent().getName(), 508-(5*Cards.getEvent().getName().length()), 305);
   
   g.setFont(new Font("Arial",Font.PLAIN,28));
   g.setColor(Color.black);
   Drawing.drawString(Cards.getEvent().getDesc(), 399, 314);
   }
      //if there is more than one
   else if(Cards.getMult().size() > 0){
       int preview = Cards.getPreview();
       ArrayList<Cards>mult = Cards.getMult();
       Cards ptr = mult.get(preview);
       
          g.setFont(new Font("Arial",Font.BOLD,75));
   //top
   g.setColor(Color.WHITE);
   if(Player.getCurrentPlayer().getStats() == Player.COLLEGE)
   g.drawString("Player " + (Player.getIndexOf(Player.getCurrentPlayer())+1) + " Graduated", 365, 205);
   //title
   g.setColor(new Color(17,202,65));    
   g.setFont(new Font("Arial",Font.BOLD,45));
   g.drawString(ptr.getName(), 508-(5*ptr.getName().length()), 305);
   //description
   if(ptr.getSalary() == 0){
   g.setFont(new Font("Arial",Font.PLAIN,25));
   g.setColor(Color.black);
   Drawing.drawString(ptr.getDesc(), 405, 314);
   }
   else if(ptr.getSalary() != 0){
   g.setFont(new Font("Arial",Font.PLAIN,25));
   g.setColor(Color.black);
   Drawing.drawString(ptr.getDesc(), 405, 314);
   
   if(ptr.getOutlier() != Cards.UNSTABLE)
   Drawing.drawString("PayDay Salary: $" + ptr.getSalary(),365,422);
   
   if(ptr.getOutlier() > 0){
       if(ptr.getOutlier() == Cards.DEGREE){
           g.setFont(new Font("Arial",Font.PLAIN,25));
           g.setColor(Color.black);
           Drawing.drawString("Requirement: Degree",365,462);
       }
       else if(ptr.getOutlier() == Cards.UNSTABLE){
           g.setFont(new Font("Arial",Font.PLAIN,25));
           g.setColor(Color.black);
           Drawing.drawString("PayDay Salary Range: $" + ptr.getSalary() + "-" + ptr.getRaise(),365,422);
           
            g.setFont(new Font("Arial",Font.BOLD,25));
            g.setColor(Color.red);
           Drawing.drawString(
                   "Warning: Salary is unstable, expect \n" +
                   "an unpredictable income",365,464); 
       }
   }       
   }
      }

   else if (cause == Cards.CAREER){
   Button ptr = elements.get(EXITBUTTON);
   ptr.toggle = true;
   g.drawRect(ptr.getXPos(), ptr.getYPos(), ptr.getXSize(), ptr.getYSize());
   Cards cptr = Cards.getEvent();
   g.setFont(new Font("Arial",Font.BOLD,75));
   g.setColor(Color.WHITE);
   g.drawString("Player " + (Player.getIndexOf(Player.getCurrentPlayer())+1) + " Got", 365, 205);
   
   g.setColor(new Color(17,202,65));    
   g.setFont(new Font("Arial",Font.BOLD,45));
   g.drawString(Cards.getEvent().getName(), 508-(5*cptr.getName().length()), 305);
   
   g.setFont(new Font("Arial",Font.PLAIN,25));
   g.setColor(Color.black);
   Drawing.drawString(Cards.getEvent().getDesc(), 405, 314);
   
   if(cptr.getOutlier() != Cards.UNSTABLE)
   Drawing.drawString("PayDay Salary: $" + cptr.getSalary(),365,422);
   
   if(cptr.getOutlier() > 0){
       if(cptr.getOutlier() == Cards.DEGREE){
           g.setFont(new Font("Arial",Font.PLAIN,25));
           g.setColor(Color.black);
           Drawing.drawString("Requirement: Degree",365,462);
       }
       else if(cptr.getOutlier() == Cards.UNSTABLE){
           g.setFont(new Font("Arial",Font.PLAIN,25));
           g.setColor(Color.black);
           Drawing.drawString("PayDay Salary Range: $" + cptr.getSalary() + "-" + cptr.getRaise(),365,422);
           
            g.setFont(new Font("Arial",Font.BOLD,25));
            g.setColor(Color.red);
           Drawing.drawString(
                   "Warning: Salary is unstable, expect \n" +
                   "an unpredictable income",365,464); 
       }
   }
   
   
   }
   else if(cause == Cards.PAYDAY){
    Button ptr = elements.get(EXITBUTTON);
   ptr.toggle = true;
   g.drawRect(ptr.getXPos(), ptr.getYPos(), ptr.getXSize(), ptr.getYSize());
   g.setColor(new Color(17,202,65));    
   g.setFont(new Font("Arial",Font.BOLD,45));
   g.drawString("Pay Day", 508-(5*Cards.getEvent().getName().length()), 305);
   
   int outcome = Cards.getEvent().getSalary();
   g.setFont(new Font("Arial",Font.PLAIN,25));
   g.setColor(Color.black);
   if(Cards.getEvent().getOutlier() == Cards.UNSTABLE)
       outcome = (int)Cards.getEvent().getOutCome();
   Drawing.drawString("You got paid \n "
           + "$" + outcome +" for your 'service.'", 399, 314);    
   }
   
           
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
 public static int getPlayerIndex(){
     return selectedPlayer;
 }
 public static int getPreviewIndex(){
     return previewIndex;
 }
 public static ArrayList getElems(){
     return elements;
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
     if(previewIndex+i > Player.getCarList().length-1)
         previewIndex = 0;
     else if (previewIndex+i < 0)
         previewIndex = Player.getCarList().length-1;
     else if( previewIndex + i >= 0 && previewIndex + i < Player.getCarList().length)
     previewIndex += i;

 }
  public  static void ChangeRulesIndex(int i){     
     if(rulesIndex+i > rules.size()-1)
         rulesIndex = 0;
     else if (rulesIndex+i < 0)
         rulesIndex = rules.size()-1;
     else if( rulesIndex + i >= 0 && rulesIndex + i < rules.size())
     rulesIndex += i;

 }
  public  static void ChangePlayerIndex(int i){
     if( selectedPlayer + i >= 0 )
     selectedPlayer += i;
 }
public  static void SetPlayerIndex(int i){
     if( selectedPlayer + i >= 0 && selectedPlayer + i < Player.getCarList().length)
     selectedPlayer = i;
 }
public  static void SetPreviewIndex(int i){
     if( selectedPlayer + i >= 0 && selectedPlayer + i < Player.getCarList().length)
     selectedPlayer = i;
 }
  
}
