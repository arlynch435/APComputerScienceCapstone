import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.TimerTask;
import java.util.Timer;
import java.util.Date;
/**
 * A panel that holds all the statistics and launch capabilites of the projectile
 * 
 * Austin Lynch
 */
public class ControlPanel extends JPanel 
{
    /** display of the initial angle of the projectile*/
    private JLabel angle;
    /** display of the x position of the projectile */
    private JLabel xPos;
    /** display of the y position of the projectile */
    private JLabel yPos;
    /** display of the projectile and all the action occuring */
    private DisplayPanel canvas;
    /** display of the x velocity of the projectile */
    private JLabel xVelocity;
    /** display of the y velocity of the projectile */
    private JLabel yVelocity;
    /** the projectile being used */
    private Projectile ball;
    /** The button used to launch the projectile */
    private JButton launchButton;
    /** the obejct used to trigger animations */
    private Timer timer;
    /** the object to perform animations */
    private TimerTask animator;
    /** the margin of error for the closeness of two doubles */
    private static final double EPSILON=.01;
    /** the vector of the ball */
    private Vector victor;
    /**
     * Default constructor for objects of class ControlPanel
     */
    public ControlPanel(DisplayPanel d, Projectile p) throws InterruptedException
    {
        // calls the JPanel constructor
        super();
        //initialize instance variables
        this.canvas=d;
        this.ball=p;
        ClickListener listen=new ClickListener(this);
        this.angle=new JLabel(String.format("Angle: %.2f",this.canvas.getTheta()));
        this.xPos=new JLabel(String.format("x position: %.2f",this.ball.getXPos()));
        this.yPos=new JLabel(String.format("y position: %.2f",450-this.ball.getYPos()));
        this.xVelocity=new JLabel(String.format("x velocity: %.2f",this.ball.getXVelo()));
        this.yVelocity=new JLabel(String.format("y velocity: %.2f",(this.ball.getYVelo())));
        this.timer=new Timer();
        this.animator=new AnimateProjectile(this);
        this.launchButton=new JButton("Launch!");
        //adds components and listeners to main components
        this.launchButton.addActionListener(listen);
        this.add(this.launchButton);
        this.add(this.angle);
        this.add(this.xPos);
        this.add(this.yPos);
        this.add(this.xVelocity);
        this.add(this.yVelocity);
        //sets the compound time of the drawing panel to one millisecond
        this.canvas.setCompoundingTime(.001);
    }
    /**
     * Where the animation occurs
     */
    public void nextFrame()
    {
        // checks to see if the projectile is getting ready for launch
        if (canvas.prelaunch())
        {
            //sets vector
            this.victor=canvas.getVector();
            if (this.victor==null)//should the user forget to create a vecotr
            {
                //test method is used as a default "vector"
                canvas.testMotion();
            }
            else
            {
                //finds the strenght of the vector, converts it to Joules and sets the initial velocities
                canvas.intMotion(victor.calcMagnitude()*100);
            }
            //switches state to launching the ball and out of prelaunch
            canvas.launching();
        }
        //update the projectile
        canvas.move();
        //update the labels
        xPos.setText(String.format("x position: %.2f",ball.getXPos()));
        yPos.setText(String.format("y position: %.2f",(450-ball.getYPos())));
        xVelocity.setText(String.format("x velocity: %.2f",ball.getXVelo()));
        yVelocity.setText(String.format("y velocity: %.2f",ball.getYVelo()));
        // update the ball
        ball.setCenter();
        //update the graphical representation
        canvas.repaint();
        //if the ball hits the ground, the animation will stop
        if ((Math.abs(ball.getYPos()-canvas.getGround().getHeight())<=EPSILON || canvas.getGround().getHeight()-ball.getYPos()<0)&&
                    !canvas.prelaunch())
        {
            animator.cancel();
            //switches the projectile back to a prelaunch state
            ball.setYPos(canvas.getGround().getHeight());
            canvas.launchAgain();
            canvas.repaint();
        }
    }
        public class ClickListener implements ActionListener
    {
        private ControlPanel controls;
        public ClickListener(ControlPanel chong)
        {
            this.controls=chong;
        }
        public void actionPerformed(ActionEvent event) 
        {
            //sets new animator
            animator=new AnimateProjectile(this.controls);
            //timer sets animator in motion
            timer.scheduleAtFixedRate(animator,0,1);
           }
        }
    
    }
