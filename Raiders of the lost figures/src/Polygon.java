
public class Polygon {

   protected Point point[];
   protected int nPoints;

   // Constructor
   public Polygon(String s) {
      String aos[] = s.split(" ");

      nPoints = (aos.length - 1) / 2;
      point = new Point[nPoints];

      for (int i = 0; i < nPoints; i++) {
         double x = Double.parseDouble(aos[i * 2 + 1]);
         double y = Double.parseDouble(aos[i * 2 + 2]);
         point[i] = new Point(x, y);
      }
   }

   // Methods
   public double perimeter() {
      double result = 0;

      for (int i = 0; i < nPoints; i++)
         result += point[i].dist(point[(i + 1) % nPoints]);

      return result;
   }

   public Point centroid() {
      double x = 0;
      double y = 0;

      for (int i = 0; i < nPoints; i++) {
         x += point[i].getX();
         y += point[i].getY();
      }

      x /= nPoints;
      y /= nPoints;
      return new Point(x, y);
   }
}