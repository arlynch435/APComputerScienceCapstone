import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JColorChooser;
/**
 * Write a description of class DrawingPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DrawingPanel extends JPanel
{
    /** description of instance variable x (add comment for each instance variable) */
    private SelectListener select;
    private DragListener move;
    private ArrowListener compass;
    private int activeShape;
    private boolean isShapePicked;
    private Color shapeColor;
    private boolean changeRadius;
    private static final GRAVITY=9.8;

    /**
     * Default constructor for objects of class DrawingPanel
     */
    public DrawingPanel()
    {
        super();
        this.setFocusable(true);
        this.select=new SelectListener();
        this.move=new DragListener();
        this.compass=new ArrowListener();
        this.requestFocusInWindow();
        this.setBackground(Color.WHITE);
        this.activeShape=-1;
        this.isShapePicked=false;
        this.shapeColor=Color.BLUE;
        this.addMouseListener(this.select);
        this.addMouseMotionListener(this.move);
        this.addKeyListener(this.compass);
    }
    public Color getColor()
    {  
        return this.shapeColor;
    }
    public Dimension getPreferredSize()
    {
        Dimension pref= new Dimension(800,500);
        return pref;
    }
    public void pickColor()
    {
        JColorChooser colorChooser=new JColorChooser();
        Color newColor=null;
        newColor=colorChooser.showDialog(this,"Pick Color",this.shapeColor);
        if (newColor!=null)
        {
            this.shapeColor=newColor;
        }
    }
    public double calcDelta(double property, double time)
    {
        return property*time;
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D) g;
    }
        public class SelectListener implements MouseListener
    {
        public void mouseClicked(MouseEvent event)
        {
          // Invoked when the mouse button has been clicked (pressed and released) on a component.
        }
        public void mouseEntered(MouseEvent event)
        {
           requestFocusInWindow();
            // Invoked when the mouse enters a component.
        }
        public void mouseExited(MouseEvent event)
        {
            // Invoked when the mouse exits a component.
        }
        public void mousePressed(MouseEvent event)
        {
          // Invoked when a amouse button has been pressed on a component.

          double xPos=event.getX();
          double yPos=event.getY();
          Point2D.Double mousePos=new Point2D.Double(xPos,yPos);
          isShapePicked=false;
           repaint();
        }
        public void mouseReleased(MouseEvent event)
        {
          // Invoked when a mouse button has been released on a component.
        }
        
    
    }
        public class DragListener implements MouseMotionListener
    {
        public void mouseDragged(MouseEvent event)
        {
            //use this one
            double xPos=event.getX();
            double yPos=event.getY();
            Point2D.Double mousePos=new Point2D.Double(xPos,yPos);
            select.mousePressed(event);

            repaint();
        }
        public void mouseMoved(MouseEvent event)
        {
        }
    }
        public class ArrowListener implements KeyListener
    {
       public void  keyPressed(KeyEvent event)
       {
           //Invoked when a key has been pressed.
           if (isShapePicked)
           {
               int key =event.getKeyCode();
               if (key==KeyEvent.VK_SPACE)
               {
                   //projectile.launch();
                }
            }
       }
       public void  keyReleased(KeyEvent event)
       {
           //Invoked when a key has been released.
        }
       public void  keyTyped(KeyEvent event)
       {
           //Invoked when a key has been typed.
        }

    }

}
