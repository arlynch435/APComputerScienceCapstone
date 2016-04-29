import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
public class ProjectileMotion extends JFrame
{
    private static final int FRAME_WIDTH=1600;
    private static final int FRAME_HEIGHT=800;
    private ControlPanel controls;
    /**
     * Default constructor for objects of class DisplayEditor
     */
    public ProjectileMotion() throws InterruptedException
    {
        super();
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        Projectile ball=new Projectile(50,400,0,0,10);
        DisplayPanel canvas=new DisplayPanel(ball);
        canvas.testMotion();
        controls=new ControlPanel(canvas, ball);
        this.setLayout(new BorderLayout());
        this.add(canvas,BorderLayout.CENTER);
        this.add(controls,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Projectile Motion");
    }
    public void animate()
    {
        controls.nextFrame();
    }
    public static void main(String[] args)throws InterruptedException
    {
        ProjectileMotion window= new ProjectileMotion();
//         for( int seconds = 0; seconds < 3000; seconds++ )
//         {
//             window.animate();
//             Thread.sleep( 1 );
//         }
    }

}
