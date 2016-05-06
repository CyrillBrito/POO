
public class Triangle {

   private Point a;
   private Point b;
   private Point c;

   // Constructor
   public Triangle(Point a, Point b, Point c) {
      this.a = a;
      this.b = b;
      this.c = c;
   }

   // Point A access
   public void setA(Point a) {
      this.a = a;
   }

   public Point getA() {
      return a;
   }

   // Point B access
   public void setB(Point b) {
      this.b = b;
   }

   public Point getB() {
      return b;
   }

   // Point C access
   public void setC(Point c) {
      this.c = c;
   }

   public Point getC() {
      return c;
   }

   public double getDistAB() {
      return a.dist(b);
   }

   public double getDistBC() {
      return b.dist(c);
   }

   public double getDistCA() {
      return c.dist(a);
   }

   // Methods
   public double perimeter() {
      return a.dist(b) + b.dist(c) + c.dist(a);
   }

   public double semiperimeter() {
      return perimeter() / 2;
   }

   public double area() {
      double s = semiperimeter();
      return Math.sqrt(s * (s - a.dist(b)) * (s - b.dist(c)) * (s - c.dist(a)));
   }
   
   public static boolean isTriangle(Point a, Point b, Point c) {
      if(a.dist(b) + b.dist(c) > c.dist(a) && b.dist(c) + c.dist(a) > a.dist(b) && c.dist(a) + a.dist(b) > b.dist(c))
         return true;
      else
         return false;
   }
}
