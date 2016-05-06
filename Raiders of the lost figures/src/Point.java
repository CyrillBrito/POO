public class Point {

   private double x, y;

   // Constructor
   public Point(double x, double y) {
      setX(x);
      setY(y);
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
      double dx = x - p.getX();
      double dy = y - p.getY();
      return Math.sqrt(dx * dx + dy * dy);
   }

   public String toString() {
      return (int) x + " " + (int) y;
   }
}
