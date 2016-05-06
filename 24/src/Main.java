import java.util.Scanner;

public class Main {

   public static void main(String args[]) {

      Scanner input = new Scanner(System.in);

      while (input.hasNextLine()) {
         String numbers = input.nextLine();
         String value = input.nextLine();

         Game24 game = new Game24(numbers, value);
         game.play();
      }
      input.close();
   }
}
