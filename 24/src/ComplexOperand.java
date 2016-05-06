
public class ComplexOperand implements Operand {

   private Operand operand1;
   private Operand operand2;
   private Operator operator;

   public ComplexOperand(Operand operand1, Operand operand2, Operator operator) {
      this.operand1 = operand1;
      this.operand2 = operand2;
      this.operator = operator;
   }

   public int value() {
      return operator.execute(operand1, operand2);
   }

   public String toString() {
      return "(" + operand1 + operator + operand2 + ")";
   }
}
