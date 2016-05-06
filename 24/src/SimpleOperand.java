
public class SimpleOperand implements Operand {

   private int operand;

   public SimpleOperand(int operand) {
      this.operand = operand;
   }

   public int value() {
      return operand;
   }

   public String toString() {
      return Integer.toString(operand);
   }
}
