
public class Rectangle extends Polygon {

   public Rectangle(String s) throws Exception {
      super(s);

      if (nPoints != 4)
         throw new Exception();

      if (!isRectangle(point[0], point[1], point[2], point[3]))
         throw new Exception();
   }

   static boolean isRectangle(Point a, Point b, Point c, Point d) {
      if (a.dist(b) != c.dist(d) || a.dist(b) <= 0)
         return false;
      if (a.dist(c) != b.dist(d) || a.dist(c) <= 0)
         return false;
      if (a.dist(d) != b.dist(c) || a.dist(d) <= 0)
         return false;

      return true;
   }

}
