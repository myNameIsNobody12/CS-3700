import java.lang.Math;
public class Cord
{
    public class Point
    {
        private double x;
        private double y;
    

        public Point(double x, double y) //constructor
        {
            this.x = x;
            this.y = y;
        }

        public double getX()
        {
            return this.x;
        }

        public double getY()
        {
            return this.y;
        }

        public String compareOrigin()
        {
            double OriginX = this.x - 0;
            double OriginY = this.y - 0;
            return "x:" + OriginX + ", y: " + OriginY;
        }

        public  String comparePoints(Point other)
        {
            double comX = this.x - other.x; 
            if (comX < 0 ) // ensures that the distance is a positive number
            {
                comX = comX * -1;
            }

            double comY = this.y - other.y; 
            if (comY < 0 )
            {
                comY = comY * -1;
            }
            return "x: " + comX +", y: " + comY;
        }
    }
    public class Circle
    {
        private Point center;
        private double radius;

        public Circle(Point center, double radius)
        {
            //since I imported the math library for exponents I might as well use actual PI
            this.center = center;
            this.radius = radius;
        }

        public String getCenter()
        {
            return "("+this.center.x+", "+this.center.y+")";
        }

        public double getRadius()
        {
            return this.radius;
        }

        public double getArea()
        {
            return Math.pow(this.radius, 2) * Math.PI;// Math.pow is exponents for java
        }

        public double getCircumference()
        {
            return 2*Math.PI*this.radius;
        }

        public boolean contains(Point p)
        {
            /*to get this to work we have to use the distance formula 
             * to find d, if d>radius then the point is NOT in the circle
             * otherwise it will be 
             */
            double d = Math.sqrt(Math.pow(p.x - this.center.x, 2) + Math.pow(p.y - this.center.y, 2));
            if (d > this.radius)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

    }
    public static void main(String[] args) 
        {
            Cord core = new Cord();
            Point one = core.new Point(55,12);
            Point two = core.new Point(22.3,35.5);
            Circle uno = core.new Circle(two, 17);
            System.out.println("Point one: ( " + one.getX() + ", " + one.getY() + ")\nPoint two: ( " + two.getX() + ", " + two.getY() + ")\nPoint one distance from origin: " + one.compareOrigin() + "\nPoint two distance from the origin: " + two.compareOrigin() + "\nPoints one & two's distance from each other: " + one.comparePoints(two));
            System.out.println("Center point of circle uno: " + uno.getCenter()+"\nRadius of uno: "+ uno.getRadius());
            System.out.println("Area of uno: " + uno.getArea() + "\nCircumference of uno: " + uno.getCircumference());
            System.out.println("does uno contain Point one? " + uno.contains(one));
        }
}
