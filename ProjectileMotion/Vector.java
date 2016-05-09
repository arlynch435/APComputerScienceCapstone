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
    private Point2D.Double distance;
    private double thetaFromX;
    private double magnitude;
    private static final double MAXXDISTANCE=100.0;

    /**
     * Default constructor for objects of class Projectile
     */
    public Vector(double xStart, double yStart, double xEnd, double yEnd)
    {
        // initialise instance variables
        this(new Point2D.Double(xStart,yStart),new Point2D.Double(xEnd,yEnd));
    }
    public Vector(Point2D.Double start, double xEnd,double yEnd)
    {
        this(start,new Point2D.Double(xEnd,yEnd));
    }
    public Vector (Point2D.Double start, Point2D.Double end)
    {
        this.ball=start;
        this.distance=end;
        this.setToMax();
    }
    public void setToMax()
    {
        if(this.distance.getX()-this.ball.getX()<0)
        {
            this.distance.setLocation(this.ball.getX(),this.distance.getY());
        }
        if (this.distance.getX()-this.ball.getX()>=MAXXDISTANCE)
        {
            this.distance.setLocation(this.ball.getX()+MAXXDISTANCE,this.distance.getY());
        }
    }
    public double calcTheta()
    {
        this.calcMagnitude();
        this.thetaFromX=Math.acos((distance.getX()-ball.getX())/this.magnitude);
        return this.thetaFromX;
    }
    public double calcMagnitude()
    {
        this.magnitude=Math.sqrt(Math.pow((ball.getX()-distance.getX()),2)+Math.pow(ball.getY()-distance.getY(),2));
        return this.magnitude;
    }
        public void draw(Graphics2D g2)
    {
        Line2D.Double me=new Line2D.Double(ball,distance);
        g2.draw(me);
    }

}