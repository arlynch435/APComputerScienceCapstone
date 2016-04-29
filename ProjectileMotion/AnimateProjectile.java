
import java.util.TimerTask;
/**
 * Write a description of class AnimateProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimateProjectile extends TimerTask
{
    /** description of instance variable x (add comment for each instance variable) */
    private ControlPanel controls;

    /**
     * Default constructor for objects of class AnimateProjectile
     */
    public AnimateProjectile(ControlPanel connorChong)
    {
        this.controls=connorChong;
    }

    /**
     * An example of a method - replace this comment with your own
     *    that describes the operation of the method
     *
     * @pre        preconditions for the method
     *            (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *            (what the method guarantees upon completion)
     * @param    y    description of parameter y
     * @return    description of the return value
     */
    public void run()
    {
        // put your code here animate();
        try{
           for( int seconds = 0; seconds < 3000; seconds++ )
           {
               controls.nextFrame();
               Thread.sleep( 1 );
            }
       }
       catch(InterruptedException e)
       {
           e.printStackTrace();
        }
    }

}
