import java.util.Scanner;

public class Main {

   public static void main(String args[]) {
      Scanner input = new Scanner(System.in);

      Point a = new Point(input.nextDouble(), input.nextDouble());
      Point b = new Point(input.nextDouble(), input.nextDouble());
      Point c = new Point(input.nextDouble(), input.nextDouble());
      input.close();

      if (!Triangle.isTriangle(a, b, c)) {
         System.out.println("NAT");
         return;
      }

      Triangle t = new Triangle(a, b, c);
      Circle circle = new Circle(t);

      System.out.println((int) circle.getCenter().getX() + " " + (int) circle.getCenter().getY());
      System.out.println((int) circle.getRadius());
   }
}
