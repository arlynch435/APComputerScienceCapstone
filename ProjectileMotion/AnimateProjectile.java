
import java.util.TimerTask;
/**
 * The class that does the animation
 * 
 * Austin Lynch 
 */
public class AnimateProjectile extends TimerTask
{
    /** the panel where the action occurs*/
    private ControlPanel controls;

    /**
     * Default constructor for objects of class AnimateProjectile
     */
    public AnimateProjectile(ControlPanel connorChong)
    {
        this.controls=connorChong;
    }

    /**
     * Runs the method that moves the projectile, calculate the properties and update the properties
     */
    public void run()
    {
               controls.nextFrame();
    }

}
