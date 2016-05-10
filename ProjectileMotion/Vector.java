import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
/**
 * The vector from which the ball will go across the screen
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vector
{
    /** the point where the ball resides */
    private Point2D.Double ball;
    /** the point where the other end of the vector exists */
    private Point2D.Double distance;
    /** the angle from the horizontal that the vecotr is situated in */
    private double thetaFromX;
    /** the amount of energy (calculated in centiJoules for scale purposes) */
    private double magnitude;
    /** The maximum x component allowed for the vector to exist */
    private static final double MAXXDISTANCE=500.0;
    public Vector(double xStart, double yStart, double xEnd, double yEnd)
    {
        this(new Point2D.Double(xStart,yStart),new Point2D.Double(xEnd,yEnd));
    }
    public Vector(Point2D.Double start, double xEnd,double yEnd)
    {
        this(start,new Point2D.Double(xEnd,yEnd));
    }
    /**
     * Default constructor for objects of class Projectile
     */
    public Vector (Point2D.Double start, Point2D.Double end)
    {
        this.ball=start;
        this.distance=end;
        this.setToMax();
    }
    /**
     * Sets the vector to its maximum distance
     */
    public void setToMax()
    {
        //keeps the vector from a negative x value
        if(this.distance.getX()-this.ball.getX()<0)
        {
            this.distance.setLocation(this.ball.getX(),this.distance.getY());
        }
        //keeps the vector from becoming unnecessarily large
        if (this.distance.getX()-this.ball.getX()>=MAXXDISTANCE)
        {
            this.distance.setLocation(this.ball.getX()+MAXXDISTANCE,this.distance.getY());
        }
    }
    /**
     * Calculates and returns the angle from the horizontal and the vector
     */
    public double calcTheta()
    {
        this.calcMagnitude();
        this.thetaFromX=Math.acos((distance.getX()-ball.getX())/this.magnitude);
        return this.thetaFromX;
    }
    /**
     * Calculates and returns the strength of the vector
     */
    public double calcMagnitude()
    {
        //uses distance formula
        this.magnitude=Math.sqrt(Math.pow((ball.getX()-distance.getX()),2)+Math.pow(ball.getY()-distance.getY(),2));
        return this.magnitude;
    }
    /**
     * Draws a linear representation of the vector
     */
    public void draw(Graphics2D g2)
    {
        Line2D.Double me=new Line2D.Double(ball,distance);
        g2.draw(me);
    }

}