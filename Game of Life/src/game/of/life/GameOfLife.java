
package game.of.life;


import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameOfLife extends JFrame implements Runnable {
    
    boolean animateFirstTime = true;
    static boolean gameOver;
    static boolean startGame;
    Image image;
    Graphics2D g;
    int timer;
    private int timeCount;
    boolean move;
    double frameRate = 40;
    Image cars[] = {Toolkit.getDefaultToolkit().getImage("./TRANSP CAR.png"),Toolkit.getDefaultToolkit().getImage("./TRANSPP CAR 2.png"),Toolkit.getDefaultToolkit().getImage("./TRANSPP CAR 3.png"),Toolkit.getDefaultToolkit().getImage("./TRANSPP CAR 4.png")};
//    Player plr1 = Player.addPlayer(Toolkit.getDefaultToolkit().getImage("./TRANSP CAR.png"),1);
//    Player plr2 = Player.addPlayer( Toolkit.getDefaultToolkit().getImage("./TRANSPP CAR 2.png"));
//    Player plr3 = Player.addPlayer(Toolkit.getDefaultToolkit().getImage("./TRANSP CAR 3.png"));
//    Player plr4 = Player.addPlayer(Toolkit.getDefaultToolkit().getImage("./TRANSP CAR 4.png"));
    Page ingame = Page.Create(Page.Tab.PLAY);
    Page playerselect = Page.Create(Page.Tab.PLAYERSELECT,Toolkit.getDefaultToolkit().getImage("./Player Select.png" ));
    Page rules = Page.Create(Page.Tab.RULES,Toolkit.getDefaultToolkit().getImage("./Rule Screen.png" ));
    Page menu = Page.Create(Page.Tab.MENU, Toolkit.getDefaultToolkit().getImage("./Menu Screen.png"));
    //hitboxes not images (x y refers to top left not center)
    Button playButton = menu.createButton(Button.Type.PLAY,18,389,295,130);
    Button scrollRight = rules.createButton(Button.Type.RIGHT, 705, 700, 198, 142);
    Button scrollLeft = rules.createButton(Button.Type.LEFT, 224, 700, 198, 142);
    Button ruleButton = menu.createButton(Button.Type.RULES,18,558,295,130);
    Button rightArrow = playerselect.createButton(Button.Type.RIGHT,721,292,200,142);
    Button leftArrow = playerselect.createButton(Button.Type.LEFT,255,292,200,142);
    Button backToMenu = rules.createButton(Button.Type.CANCEL, 27, 40, 247, 102);
    Button backMenu = playerselect.createButton(Button.Type.CANCEL, 15, 39, 244, 102);
    Button exitEvent = ingame.createElem(Button.Type.CANCEL, 316,241,78,75);
    Button selectCar = playerselect.createButton(Button.Type.CONFIRM,468,494,248,102);
    Button startgame = playerselect.createElem(Button.Type.PLAY, 919, 793, 247, 102);
    Button collegeYes = playerselect.createElem(Button.Type.BOOLEAN, 20, 519, 318, 48);
    
    //Button move = ingame.createButton(Button.Type.PLAY, , ERROR, WIDTH, WIDTH);
    
    
    public static void main(String[] args) {
        GameOfLife frame = new GameOfLife();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        System.out.println(Window.WINDOW_WIDTH);
        System.out.println(Window.WINDOW_HEIGHT);
    }

    public GameOfLife() {
                Page.Init();
                Page.SetPage(menu);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                
                
                if (e.BUTTON1 == e.getButton() ) {
                    System.out.println((e.getX() - Window.getX(0)) + " , " + (e.getY() - Window.getY(0)));
                    Board.AddTokenPixel(e.getX() - Window.getX(0),
                    e.getY() - Window.getY(0));  
                    if(Board.detectSpinner(e.getX() - Window.getX(0),
                    e.getY() - Window.getY(0))){
                        if(Spinner.coolDown == 0 && !Board.pause && Board.ifActive()){
                            if(Player.getCurrentPlayer().getMoves() == 0)
                            Spinner.setOn();
                        }
                    }
                

                }                
                else if(e.BUTTON3 == e.getButton()){
                System.out.println(Page.GetCurrPage().getTab());
                Spinner.testSpin();
                }
                repaint();
            }
        });
            

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {

        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.VK_UP == e.getKeyCode()) {
                    
                        
                } else if (e.VK_DOWN == e.getKeyCode()) {
                } else if (e.VK_LEFT == e.getKeyCode()) {
                    if(Board.ifActive() && Cards.getEvent() !=null){
                        Cards.changePreview(-1);
                    }
                } else if (e.VK_RIGHT == e.getKeyCode()) {
                    if(Board.ifActive() && Cards.getEvent() !=null){
                        Cards.changePreview(1);
                    }
                } else if (e.VK_ESCAPE == e.getKeyCode()) {
                    reset();
                }
                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }
////////////////////////////////////////////////////////////////////////////
     public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
             Drawing.setDrawingInfo(g,this);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            
        }
//fill background
//        
//        g.setColor(Color.cyan);
//        g.fillRect(0, 0, Window.xsize, Window.ysize);
        Drawing.drawImage(Toolkit.getDefaultToolkit().getImage("Background.png"), Window.WINDOW_WIDTH/2, Window.WINDOW_HEIGHT/2, 0.0, 1, 1);
      
        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.white);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.black);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        //if
        Page.loadPage(g, Page.GetCurrPage());
        Board.Draw(g);
        Page.loadElm(g, Page.GetCurrPage());
        gOld.drawImage(image, 0, 0, null);
}

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = 1/frameRate;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
    
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        Cards.Reset();
        Player.Reset();
        Board.Reset();
        Spinner.Reset();
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {

        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }

            reset();

        }
        if(startGame){
            startGame = false;    
            Board.changeActive(true);
            reset();
            if(Player.getCurrentPlayer().getStats() == Player.CAREER)
                Cards.careerRoll(Player.getCurrentPlayer());
            else{
                exitEvent.toggle = true;
                exitEvent.pressed(Page.GetCurrPage());
            }
        }
        //if pause is false, then the game will run
        if(!Board.pause && Board.ifActive()){
        if(Player.getCurrentPlayer().hasSpun()){
          if(wait(10)){
            move = true;
            }  
        }      
        else{
            timer = 0;
            move = false;
        }
        if(wait(20) && Player.getCurrentPlayer().getJob() == null && Player.getCurrentPlayer().getStats() == Player.CAREER)
        Cards.careerRoll(Player.getCurrentPlayer());
        
        if (Spinner.getOn()){
//            if (timeCount % frameRate == frameRate-1){
                Spinner.MoveArrow(timeCount, frameRate);
//            }
        }

        if(move && Player.getCurrentPlayer().getMoves() > 0){
            if(wait(15)){
        if(Board.checkCurrTileDir() != null)
            Player.getCurrentPlayer().move(Board.checkCurrTileDir(),Board.checkType());
        else
            Player.getCurrentPlayer().move(Player.getCurrentPlayer().getDir(),Board.checkType());
        }


     }        
        timeCount++;
        timer++;
        if(Spinner.coolDown > 0)
            Spinner.coolDown--;
        }
        //timeCount goes 40 up per second.
    }
public int getTC(){
return timeCount;
}
    public boolean wait(int time){
    if(timeCount % time == time-1)
        return true;
    return false;
    }
public static void setStart(boolean b){
    startGame = b;
}
////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }

}




