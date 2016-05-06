
public class Subtraction implements Operator {

   @Override
   public int execute(Operand operand1, Operand operand2) {
      // In case that the expression is invalid
      if (operand1.value() < 0 || operand2.value() < 0)
         return -1;

      return operand1.value() - operand2.value();
   }

   public String toString() {
      return "-";
   }
}
