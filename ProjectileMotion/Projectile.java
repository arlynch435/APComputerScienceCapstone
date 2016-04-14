

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

    /**
     * Default constructor for objects of class Projectile
     */
    public Projectile(double xStart, double yStart, double xLaunch, double yLaunch)
    {
        // initialise instance variables
        this.xPos=xStart;
        this.yPos=yStart;
        this.xVelocity=xLaunch;
        this.yVelocity=yLaunch;
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

}
