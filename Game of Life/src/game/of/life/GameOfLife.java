
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> parent of 14e47bd... Spinner class changes
=======
>>>>>>> parent of 14e47bd... Spinner class changes
=======
>>>>>>> parent of 14e47bd... Spinner class changes
    
>>>>>>> parent of 14e47bd... Spinner class changes
=======
    Image car;
    Player plr1 = Player.addPlayer(Toolkit.getDefaultToolkit().getImage("./TRANSP CAR.png"));
    Player plr2 = Player.addPlayer( Toolkit.getDefaultToolkit().getImage("./TRANSPP CAR 2.png"));
    Player plr3 = Player.addPlayer(Toolkit.getDefaultToolkit().getImage("./TRANSPP CAR 3.png"));
    Player plr4 = Player.addPlayer(Toolkit.getDefaultToolkit().getImage("./TRANSPP CAR 4.png"));
    
    
>>>>>>> parent of e5ede38... Merge branch 'master' of https://github.com/TougeNhia/Game-of-Life
    public static void main(String[] args) {
        GameOfLife frame = new GameOfLife();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public GameOfLife() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                
                if (e.BUTTON1 == e.getButton() ) {
                    Board.AddTokenPixel(e.getX() - Window.getX(0),
                    e.getY() - Window.getY(0));  
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
        
        g.setColor(Color.cyan);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.white);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.red);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        //if
        
        g.setColor(Color.black);
        g.setFont(new Font("Arial",Font.PLAIN,30));
        g.drawString("Player 1 =", 50, 60);
        g.drawString("Player 2 =", 300, 60);
        g.drawString("Player 3 =", 600, 60);
        g.drawString("Player 4 =", 875, 60);
        
        Board.Draw(g);
        Spinner.draw(g);
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        timeCount++;
=======
        timeCount ++;
>>>>>>> parent of 14e47bd... Spinner class changes
=======
        timeCount ++;
>>>>>>> parent of 14e47bd... Spinner class changes
=======
        timeCount ++;
>>>>>>> parent of 14e47bd... Spinner class changes
        //timeCount goes 10 up per second.

        
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




