
public class Point {
   private double x, y;

   // Constructor
   public Point(double x, double y) {
      this.x = x;
      this.y = y;
   }

   // X access
   public void setX(double x) {
      assert x > 0;
      this.x = x;
   }

   public double getX() {
      return x;
   }

   // Y access
   public void setY(double y) {
      assert y > 0;
      this.y = y;
   }

   public double getY() {
      return y;
   }

   // Methods
   public double dist(Point p) {
      double dx = getX() - p.getX();
      double dy = getY() - p.getY();
      return Math.sqrt(dx * dx + dy * dy);
   }
}