
public class Circle {

   private Point center;
   private double radius;

   // Constructors
   public Circle(Point center, double radius) {
      this.center = center;
      this.radius = radius;
   }

   public Circle(double radius) {
      this.center = new Point(0, 0);
      this.radius = radius;
   }

   public Circle(Triangle t) {
      radius = t.area() / t.semiperimeter();

      double x = t.getDistAB() * t.getC().getX() + t.getDistBC() * t.getA().getX() + t.getDistCA() * t.getB().getX();
      x /= t.perimeter();

      double y = t.getDistAB() * t.getC().getY() + t.getDistBC() * t.getA().getY() + t.getDistCA() * t.getB().getY();
      y /= t.perimeter();

      center = new Point(x, y);
   }

   // Radius access
   public void setRadius(double radius) {
      this.radius = radius;
   }

   public double getRadius() {
      return radius;
   }

   // Center access
   public void setCenter(Point center) {
      this.center = center;
   }

   public Point getCenter() {
      return center;
   }

   // methods
   public double area() {
      return Math.PI * radius * radius;
   }
}