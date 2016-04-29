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
 * Write a description of class ControlPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlPanel extends JPanel 
{
    /** description of instance variable x (add comment for each instance variable) */
    private JLabel angle;
    private JLabel xPos;
    private JLabel yPos;
    private DisplayPanel canvas;
    private JLabel xVelocity;
    private JLabel yVelocity;
    private Projectile ball;
    private JButton buttonTest;
    private Timer timer;
    private TimerTask animator;
    /**
     * Default constructor for objects of class ControlPanel
     */
    public ControlPanel(DisplayPanel d, Projectile p) throws InterruptedException
    {
        super();
        this.canvas=d;
        this.ball=p;
        ClickListener listen=new ClickListener();
        this.angle=new JLabel("Angle: ");
        this.xPos=new JLabel(String.format("x position: %.2f",this.ball.getXPos()));
        this.yPos=new JLabel(String.format("y position: %.2f",this.ball.getYPos()));
        this.xVelocity=new JLabel(String.format("x velocity: %.2f",this.ball.getXVelo()));
        this.yVelocity=new JLabel(String.format("y velocity: %.2f",(500-this.ball.getYVelo())));
        this.timer=new Timer();
        this.animator=new AnimateProjectile(this);
        this.buttonTest=new JButton("Launch!");
        this.buttonTest.addActionListener(listen);
        this.add(this.buttonTest);
        this.add(this.angle);
        this.add(this.xPos);
        this.add(this.yPos);
        this.add(this.xVelocity);
        this.add(this.yVelocity);
        this.canvas.setCompoundingTime(.01);
    }
    public void nextFrame()
    {
        canvas.move();
        xPos.setText(String.format("x position: %.2f",ball.getXPos()));
        yPos.setText(String.format("y position: %.2f",(500-ball.getYPos())));
        xVelocity.setText(String.format("x velocity: %.2f",ball.getXVelo()));
        yVelocity.setText(String.format("y velocity: %.2f",ball.getYVelo()));
        canvas.repaint();
    }
        public class ClickListener implements ActionListener
    {
        
        public void actionPerformed(ActionEvent event) 
        {
            Date time=new Date();
            timer.schedule(animator,time);
            timer.cancel();
        }
    
    }

}
