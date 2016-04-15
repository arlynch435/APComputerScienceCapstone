import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
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
    private DrawingPanel canvas;
    private JLabel xVelocity;
    private JLabel yVelocity;
    private Projectile ball;

    /**
     * Default constructor for objects of class ControlPanel
     */
    public ControlPanel(DrawingPanel d, Projectile p)
    {
        super();
        this.canvas=d;
        this.ball=p;
        this.angle=new JLabel("Angle: ");
        this.xPos=new JLabel("x position: "+this.ball.getXPos());
        this.yPos=new JLabel("y position: "+this.ball.getYPos());
        this.xVelocity=new JLabel("x velocity: "+this.ball.getXVelo());
        this.yVelocity=new JLabel("y velocity: "+this.ball.getYVelo());
        this.add(this.angle);
        this.add(this.xPos);
        this.add(this.yPos);
        this.add(this.xVelocity);
        this.add(this.yVelocity);
    }
        public class ClickListener implements ActionListener
    {
        
        public void actionPerformed(ActionEvent event)
        {
            //System.out.println(event.getActionCommand()+" was pressed!");
//             if ("Pick Color".equals(event.getActionCommand()))
//             {
//                 canvas.pickColor();
//                 colorDisplay.setBackground(canvas.getColor());
//                 colorDisplay.repaint();
//             }
//             if ("Add Circle".equals(event.getActionCommand()))
//             {
//                 canvas.addCircle();
//                 canvas.repaint();
//             }
//             if ("Add Square".equals(event.getActionCommand()))
//             {
//                 canvas.addSquare();
//                 canvas.repaint();
//             }
        }
    
    }

}
