import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile
{
    /** description of instance variable x (add comment for each instance variable) */
    private double xPos;
    private double yPos;
    private double xVelocity;
    private double yVelocity;
    private double mass;

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
    }
    public double getXPos()
    {
        // put your code here
        return xPos;
    }
        public double getYPos()
    {
        // put your code here
        return yPos;
    }
        public double getXVelo()
    {
        // put your code here
        return xVelocity;
    }
        public double getYVelo()
    {
        // put your code here
        return yVelocity;
    }
    public double getMass()
    {
        // put your code here
        return mass;
    }
        public void setXPos(double newPos)
    {
        // put your code here
        this.xPos=newPos;
    }
        public void setYPos(double newPos)
    {
        // put your code here
        this.yPos=newPos;
    }
        public void setXVelo(double newVelo)
    {
        // put your code here
        this.xVelocity=newVelo;
    }
        public void setYVelo(double newVelo)
    {
        // put your code here
        this.yVelocity=newVelo;
    }
        public void draw(Graphics2D g2)
    {
        Ellipse2D.Double circle=new Ellipse2D.Double(this.xPos-10,
                                                     this.yPos-10,
                                                     10,10);
        g2.draw(circle);
    }

}
