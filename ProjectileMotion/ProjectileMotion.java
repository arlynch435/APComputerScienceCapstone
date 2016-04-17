import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
public class ProjectileMotion extends JFrame
{
    private static final int FRAME_WIDTH=1600;
    private static final int FRAME_HEIGHT=800;

    /**
     * Default constructor for objects of class DrawingEditor
     */
    public ProjectileMotion()
    {
        super();
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        Projectile ball=new Projectile(1600,500,0,0,100);
        DrawingPanel canvas=new DrawingPanel(ball);
        ControlPanel controls=new ControlPanel(canvas, ball);
        this.setLayout(new BorderLayout());
        this.add(canvas,BorderLayout.CENTER);
        this.add(controls,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Projectile Motion");
    }
    public static void main(String[] args)
    {
        ProjectileMotion window= new ProjectileMotion();
    }

}
