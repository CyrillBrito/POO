import java.util.Scanner;

public class Main {

   public static void main(String args[]) {

      Scanner input = new Scanner(System.in);

      while (input.hasNextLine()) {
         Polynomial polyA = new Polynomial(input.nextLine());
         Polynomial polyB;

         switch (input.nextLine()) {
         case "+":
            polyB = new Polynomial(input.nextLine());
            System.out.println(polyA.sum(polyB));
            break;
         case "*":
            polyB = new Polynomial(input.nextLine());
            System.out.println(polyA.mult(polyB));
            break;
         case "@":
            System.out.println(polyA.compute(input.nextDouble()));
            break;
         default:
            System.out.println("nwwalf");
            break;
         }
      }

      input.close();
   }
}
