
package game.of.life;


import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameOfLife extends JFrame implements Runnable {
    
    boolean animateFirstTime = true;
    Image image;
    Graphics2D g;
    private int timeCount;
    Image cars[] = {Toolkit.getDefaultToolkit().getImage("./TRANSP CAR.png"),Toolkit.getDefaultToolkit().getImage("./TRANSPP CAR 2.png"),Toolkit.getDefaultToolkit().getImage("./TRANSPP CAR 3.png"),Toolkit.getDefaultToolkit().getImage("./TRANSPP CAR 4.png")};
    Player plr1 = Player.addPlayer(Toolkit.getDefaultToolkit().getImage("./TRANSP CAR.png"));
    Player plr2 = Player.addPlayer( Toolkit.getDefaultToolkit().getImage("./TRANSPP CAR 2.png"), 1 );
    Player plr3;
    Player plr4;
    Page ingame = Page.Create(Page.Tab.PLAY);
    Page playerselect = Page.Create(Page.Tab.PLAYERSELECT,Toolkit.getDefaultToolkit().getImage("./Player Select.png" ));
    Page rules = Page.Create(Page.Tab.RULES,Toolkit.getDefaultToolkit().getImage("./Rule Screen.png" ));
    Page menu = Page.Create(Page.Tab.MENU, Toolkit.getDefaultToolkit().getImage("./Menu Screen.png"));

    Button playButton = menu.createButton(Button.Type.PLAY,18,389,295,130);
    Button ruleButton = menu.createButton(Button.Type.RULES,18,558,295,130);
    Button rightArrow = playerselect.createButton(Button.Type.RIGHT,721,262,200,142);
    Button leftArrow = playerselect.createButton(Button.Type.LEFT,255,262,200,142);
    Button backToMenu = rules.createButton(Button.Type.CANCEL, 60, 60, 200, 142);
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
                Page.SetPage(menu);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                
                if (e.BUTTON1 == e.getButton() ) {
                    System.out.println((e.getX() - Window.getX(0)) + " , " + (e.getY() - Window.getY(0)));
                    Board.AddTokenPixel(e.getX() - Window.getX(0),
                    e.getY() - Window.getY(0));  
                    if(Board.detectSpinner(e.getX() - Window.getX(0),
                    e.getY() - Window.getY(0)))
                        Spinner.MoveArrow(timeCount);
                    
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
                    Player.getCurrentPlayer().move(Player.Dir.UP);
                } else if (e.VK_DOWN == e.getKeyCode()) {
                    Player.getCurrentPlayer().move(Player.Dir.DOWN);
                } else if (e.VK_LEFT == e.getKeyCode()) {
                    Player.getCurrentPlayer().move(Player.Dir.LEFT);
                } else if (e.VK_RIGHT == e.getKeyCode()) {
                    Player.getCurrentPlayer().move(Player.Dir.RIGHT);
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
        gOld.drawImage(image, 0, 0, null);
    }

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = .1;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
    
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        
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
        timeCount++;
        //timeCount goes 10 up per second.
        if(Player.getCurrentPlayer().getMoves() > 0){
        if(timeCount % 10 == 9){
        if(Board.checkCurrTileDir() != null)
        Player.getCurrentPlayer().move(Board.checkCurrTileDir());
        else
        Player.getCurrentPlayer().move(Player.getCurrentPlayer().getDir());
        }
     }
    }
public int getTC(){
return timeCount;
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




