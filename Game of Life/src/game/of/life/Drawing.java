package game.of.life;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
public class Drawing {
    private static Graphics2D g;
    private static GameOfLife mainClassInst;
    public static void setDrawingInfo(Graphics2D _g,GameOfLife _mainClassInst) {
        g = _g;
        mainClassInst = _mainClassInst;
    }
    public static int getImageWidth(Image image){
        return image.getWidth(mainClassInst);
    }
    public static int getImageHeight(Image image){
        return image.getHeight(mainClassInst);
    }
    
    
////////////////////////////////////////////////////////////////////////////
    public static void drawCircle(int xpos,int ypos,double rot,double xscale,double yscale,Color color)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.setColor(color);
        g.fillOval(-10,-10,20,20);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
////////////////////////////////////////////////////////////////////////////
    public static void drawImage(Image image,int xpos,int ypos,double rot,double xscale,
            double yscale) {
        int width = image.getWidth(mainClassInst);
        int height = image.getHeight(mainClassInst);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(image,-width/2,-height/2,
        width,height,mainClassInst);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
    public static void drawString(String text, int x, int y) {
    for (String line : text.split("\n"))
        g.drawString(line, x, y += g.getFontMetrics().getHeight());
}
    
}

