import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
/**
 * The Projectile object being used for simulation
 * 
 * @author Austin Lynch 
 */
public class Projectile
{
    /** the x position of the object in in meters*/
    private double xPos;
    /** the y position of the object in meters*/
    private double yPos;
    /** the x velocity of the object in meters/second*/
    private double xVelocity;
    /** the y velocity of the object in meters/second*/
    private double yVelocity;
    /** the mass of the object in grams*/
    private double mass;
    /** the center of the object */
    private Point2D.Double center;
    /**
     * Default constructor for objects of class Projectile
     */
    public Projectile(double xStart, double yStart, double xLaunch, double yLaunch, double weight)
    {
        // initialise instance variables
        this.xPos=xStart;
        this.yPos=yStart;
        this.xVelocity=xLaunch;
        this.yVelocity=yLaunch;
        this.mass=weight;
        this.center=new Point2D.Double(this.xPos,this.yPos);
    }
    
    /**
     * Returns the x position of the object
     */public double getXPos()
    {
        return xPos;
    }
    /**
     * Returns the y position of the object
     */public double getYPos()
    {
        return yPos;
    }
    /**
     * Returns the x velocity of the object
     */
    public double getXVelo()
    {
        return xVelocity;
    }
    /**
     * Returns the y velocity of the object
     */
    public double getYVelo()
    {
        return yVelocity;
    }
    /**
     * Returns the center of the object
     */
    public Point2D.Double getCenter()
    {
        return this.center;
    }
    /**
     * Returns the mass of the object
     */
    public double getMass()
    {
        return mass;
    }
    /**
     * Sets the new x position to newPos
     */
    public void setXPos(double newPos)
    {
        this.xPos=newPos;
    }
    /**
     * Sets the new y position to newPos
     */
    public void setYPos(double newPos)
    {
        this.yPos=newPos;
    }
    /**
     * Sets the center of the object based on its current position
     */
    public void setCenter()
    {
        this.center=new Point2D.Double(this.xPos,this.yPos);
    }
    /**
     * Sets the x velocity to newVelo
     */
    public void setXVelo(double newVelo)
    {
        this.xVelocity=newVelo;
    }
    /**
     *Sets the y velocity to newVelo
     */
    public void setYVelo(double newVelo)
    {
        this.yVelocity=newVelo;
    }
    /**
     * Draws the projectile as a small circular object
     */
    public void draw(Graphics2D g2)
    {
        Ellipse2D.Double circle=new Ellipse2D.Double(this.xPos-5,
                                                     this.yPos-5,
                                                     10,10);
        g2.draw(circle);
    }

}
