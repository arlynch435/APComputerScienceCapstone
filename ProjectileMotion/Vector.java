import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vector
{
    /** description of instance variable x (add comment for each instance variable) */
    private Point2D.Double ball;
    private Point2D.Double magnitude;

    /**
     * Default constructor for objects of class Projectile
     */
    public Vector(double xStart, double yStart, double xEnd, double yEnd)
    {
        // initialise instance variables
        Point2D.Double start= new Point2D.Double(xStart,yStart);
        Point2D.Double end= new Point2D.Double(xEnd,yEnd);
        this(start,end);
    }
    public Vector(Point2D.Double start, double xEnd,double yEnd)
    {
        Point2D.Double end= new Point2D.Double(xEnd,yEnd);
        this(start,end);
    }
    public Vector (Point2D.Double start, Point2D.Double end)
    {
        this.ball=start;
        this.magnitude=end;
    }
        public void draw(Graphics2D g2)
    {
        Line2D.Double horizon=new Line2D.Double(0,this.height,this.length,this.height);
        g2.draw(horizon);
    }

}