import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JColorChooser;
/**
 * The graphical representation of the object
 * 
 * @author Austin Lynch
 */
public class DisplayPanel extends JPanel
{
    /** the listener used to find the mouse position */
    private SelectListener select;
    /** a mouse position listener similar to the selectlistener */
    private DragListener move;
    /** The gravity of the planet (given in meters/second squared) */
    private static final double GRAVITY= -9.8;
    /** the projectile in use */
    private Projectile ball;
    /** the angle from the horizontal that the projectiel was launched*/
    private double theta;
    /** the time (in seconds) that the properties are calculated and the ball is graphically moved*/
    private double compoundingTime;
    /** the initial energy vector of the object */
    private Vector vector;
    /** the ground and horizon of the object*/
    private Ground ground;
    /** the state of the projectile */
    private boolean inPrelaunch;
    
    /**
     * Default constructor for objects of class DrawingPanel
     */
    public DisplayPanel(Projectile p)
    {
        //calls the JPanel constructor
        super();
        //initialize instance variables
        this.compoundingTime=1.0;
        this.ball=p;
        this.setFocusable(true);
        this.select=new SelectListener();
        this.move=new DragListener();
        this.ground=new Ground(1600,450);
        this.inPrelaunch=true;
        this.setBackground(Color.WHITE);
        //adds listeners to components
        this.addMouseListener(this.select);
        this.addMouseMotionListener(this.move);
    }
    /**
     * Returns the default size of the panel
     */
    public Dimension getPreferredSize()
    {
        Dimension pref= new Dimension(1600,500);
        return pref;
    }
    /**
     * returns some value of linear displacement based on some value of time
     */
    public double calcDelta(double property, double time)
    {
        return property*time;
    }
    /**
     * sets the intial properties of the projectile
     */
    public void intMotion(double intEnergy)
    {
        //convert the initial kinetic energy (joules) into velocity
        double startVelo=Math.sqrt(2*intEnergy/this.ball.getMass());
        //finds the angle of the vector from the horizontal
        this.theta=vector.calcTheta();
        //set the velocities based on the x and y components of the vector
        this.ball.setXVelo(Math.cos(this.theta)*startVelo);
        this.ball.setYVelo(Math.sin(this.theta)*startVelo);
    }
    /**
     * sets the initial properties of the projectile if no vector exists
     */
    public void testMotion()
    {
        this.ball.setXVelo(40);
        this.ball.setYVelo(9.8);
    }
    /**
     * Updates the properties of the projectile
     */
    public void move()
    {
        //properties are set based on prior properties times linear displacement
        this.ball.setXPos((this.calcDelta(this.ball.getXVelo(),this.compoundingTime))+this.ball.getXPos());
        this.ball.setYPos(this.ball.getYPos()-(this.calcDelta(this.ball.getYVelo(),this.compoundingTime)));
        this.ball.setYVelo(this.ball.getYVelo()+(GRAVITY*this.compoundingTime));
    }
    /**
     * Sets the new frame when things update (in seconds)
     */
    public void setCompoundingTime(double newTime)
    {
        this.compoundingTime=newTime;
    }
    /**
     * returns the time frame when things update (in seconds)
     */
    public double getTime()
    {
        return this.compoundingTime;
    }
    /**
     * returns the ground/horizon
     */
    public Ground getGround()
    {
        return ground;
    }
    /**
     * Draws the projectile and if need bee the vector
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D) g;
        this.ball.draw(g2);
        this.ground.draw(g2);
        //checks if the vecotr needs to be drawn
        if (this.inPrelaunch&&this.vector!=null)
        {
            this.vector.draw(g2);
        }
    }
    /**
     * Generates the energy vector for the projectile
     */
    public void findForce(Point2D.Double mouse)
    {
        this.vector=new Vector(this.ball.getCenter(),mouse);
    }
    /**
     * Returns the angle of the vector from the horizontal in degrees
     */
    public double getTheta()
    {
        return Math.toDegrees(this.theta);
    }
    /**
     * Returns the state of the projectile
     */
    public boolean prelaunch()
    {
        return this.inPrelaunch;
    }
    /**
     * Changes the state of the projectile to in motion
     */
    public void launching()
    {
        this.inPrelaunch=false;
    }
    /**
     * Returns the initial vector of the projectile
     */
    public Vector getVector()
    {
        return this.vector;
    }
    /**
     * Resets the state of the projectile so it may be launched again
     */
    public void launchAgain()
    {
        this.vector=null;
        this.inPrelaunch=true;
    }
        public class SelectListener implements MouseListener
    {
        public void mouseClicked(MouseEvent event)
        {
          // Invoked when the mouse button has been clicked (pressed and released) on a component.
        }
        public void mouseEntered(MouseEvent event)
        {
           //requestFocusInWindow();
            // Invoked when the mouse enters a component.
        }
        public void mouseExited(MouseEvent event)
        {
            // Invoked when the mouse exits a component.
        }
        public void mousePressed(MouseEvent event)
        {
          // Invoked when a amouse button has been pressed on a component.
          //find mouse position
          double xPos=event.getX();
          double yPos=event.getY();
          Point2D.Double mousePos=new Point2D.Double(xPos,yPos);
          //checks if projectiel needs to be launched
          if (inPrelaunch)
          {
              //calculate the vector
              findForce(mousePos);
              theta=vector.calcTheta();
            }
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
            //Allows the vector to be adjusted via dragging
            select.mousePressed(event);

            repaint();
        }
        public void mouseMoved(MouseEvent event)
        {
        }
    }
}
