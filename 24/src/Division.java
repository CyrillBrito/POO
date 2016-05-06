
public class Division implements Operator {

   @Override
   public int execute(Operand operand1, Operand operand2) {
      // In case that the expression is invalid
      if (operand1.value() < 0 || operand2.value() < 0)
         return -1;

      // In case that operand1 is NOT divisible by operand 2 or operand2 is 0
      if (operand2.value() == 0 || operand1.value() % operand2.value() != 0)
         return -1;

      return operand1.value() / operand2.value();
   }

   public String toString() {
      return "/";
   }
}
