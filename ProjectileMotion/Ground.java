import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.Line2D;
/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground
{
    /** description of instance variable x (add comment for each instance variable) */
    private double length;
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
        public double getHeight()
    {
        // put your code here
        return this.height;
    }
        public void draw(Graphics2D g2)
    {
        Line2D.Double horizon=new Line2D.Double(0,this.height,this.length,this.height);
        g2.draw(horizon);
    }

}