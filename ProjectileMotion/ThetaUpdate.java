
/**
 * Checks when theta updates and calls appropriate text on the control panel
 * 
 * @author Austin Lynch 
 */
public class ThetaUpdate
{
    private ControlPanel controls;

    /**
     * Constructor for objects of class ThetaUpdate
     */
    public ThetaUpdate()
    {
        // initialise instance variables
    }
    /**
     * Takes in controls as a variable
     */
    public void setControls(ControlPanel c)
    {
        this.controls=c;
    }

    /**
     * Updates the canvas
     * 
     */
    public void updateNumber()
    {
        // put your code here
        this.controls.updateAngle();
    }
}
