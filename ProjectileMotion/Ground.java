import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.Line2D;
/**
 * The horizon and the ground of the landscape
 * 
 * @author Austin Lynch
 */
public class Ground
{
    /** the length of the ground */
    private double length;
    /** how far from the top of the component the ground is situated */
    private double height;

    /**
     * Default constructor for objects of class Projectile
     */
    public Ground(double xStart, double yStart)
    {
        // initialise instance variables
        this.length=xStart;
        this.height=yStart;
    }
    /**
     * Returns the distance from the top of the component
     */
    public double getHeight()
    {
        // put your code here
        return this.height;
    }
    /**
     * Draws the ground as a line across the screen
     */
    public void draw(Graphics2D g2)
    {
        Line2D.Double horizon=new Line2D.Double(0,this.height,this.length,this.height);
        g2.draw(horizon);
    }

}