
public class Triangle extends Polygon {

   public Triangle(String s) throws Exception {
      super(s);

      if (nPoints != 3)
         throw new Exception();

      if (!isTriangle(point[0], point[1], point[2]))
         throw new Exception();
   }

   static boolean isTriangle(Point a, Point b, Point c) {
      if (a.dist(b) >= b.dist(c) + c.dist(a))
         return false;
      if (b.dist(c) >= c.dist(a) + a.dist(b))
         return false;
      if (c.dist(a) >= a.dist(b) + b.dist(c))
         return false;

      return true;
   }
}