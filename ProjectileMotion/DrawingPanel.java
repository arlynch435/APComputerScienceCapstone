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
    private static final double GRAVITY= -9.8;
    private Projectile ball;
    private double theta;
    private double downPull;
    private double compoundingTime;

    /**
     * Default constructor for objects of class DrawingPanel
     */
    public DrawingPanel(Projectile p)
    {
        super();
        this.compoundingTime=1.0;
        this.ball=p;
        this.downPull=9/8;
        this.theta=30;
        this.setFocusable(true);
        this.select=new SelectListener();
        this.move=new DragListener();
        this.compass=new ArrowListener();
        this.requestFocusInWindow();
        this.setBackground(Color.WHITE);
        this.addMouseListener(this.select);
        this.addMouseMotionListener(this.move);
        this.addKeyListener(this.compass);
    }
    public Dimension getPreferredSize()
    {
        Dimension pref= new Dimension(1600,500);
        return pref;
    }
    public double calcDelta(double property, double time)
    {
        return property*time;
    }
    public void intMotion(double intForce)
    {
        double startVelo=intForce/this.ball.getMass();
        this.downPull=this.GRAVITY/this.ball.getMass();
        this.ball.setXVelo(Math.cos(this.theta)*startVelo);
        this.ball.setYVelo(Math.sin(this.theta)*startVelo);
    }
    public void testMotion()
    {
        this.downPull=this.GRAVITY/this.ball.getMass();
        this.ball.setXVelo(10);
        this.ball.setYVelo(30);
    }
    public void move()
    {
        this.ball.setXPos((this.calcDelta(this.ball.getXVelo(),this.compoundingTime))+this.ball.getXPos());
        this.ball.setYPos(this.ball.getYPos()-(this.calcDelta(this.ball.getYVelo(),this.compoundingTime)));
        this.ball.setYVelo(this.ball.getYVelo()+(this.calcDelta(this.downPull,this.compoundingTime)));
    }
    public void setCompoundingTime(double newTime)
    {
        this.compoundingTime=newTime;
    }
    public double getTime()
    {
        return this.compoundingTime;
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D) g;
        this.ball.draw(g2);
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
               int key =event.getKeyCode();
               if (key==KeyEvent.VK_SPACE)
               {
                   testMotion();
                   repaint();
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
