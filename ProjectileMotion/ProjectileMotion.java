import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
public class ProjectileMotion extends JFrame
{
    /** the width of the window*/
    private static final int FRAME_WIDTH=1600;
    /** the height of the window*/
    private static final int FRAME_HEIGHT=800;
    /** the the control panel of the program*/
    private ControlPanel controls;
    /**
     * Default constructor for objects of class ProjectileMotion
     */
    public ProjectileMotion() throws InterruptedException
    {
        super();
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        Projectile ball=new Projectile(50,400,0,0,10);
        DisplayPanel canvas=new DisplayPanel(ball);
        controls=new ControlPanel(canvas, ball);
        this.setLayout(new BorderLayout());
        this.add(canvas,BorderLayout.CENTER);
        this.add(controls,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Projectile Motion");
    }
    public static void main(String[] args)throws InterruptedException
    {
        ProjectileMotion window= new ProjectileMotion();
    }

}
