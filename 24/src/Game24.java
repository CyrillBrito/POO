import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game24 {

   private SimpleOperand[] operands;
   private int value;

   // Constructor
   public Game24(String operands, String value) {

      String[] aos = operands.split(" ");

      this.operands = new SimpleOperand[4];
      for (int i = 0; i < 4; i++)
         this.operands[i] = new SimpleOperand(Integer.parseInt(aos[i]));

      this.value = Integer.parseInt(value);
   }

   // Solves the game and prints the result
   public ArrayList<String> play() {

      ArrayList<SimpleOperand> listOperands = createListOperands();
      ArrayList<Operator> listOperators = createListOperators();

      ArrayList<ComplexOperand> expressions = createExpressions(listOperands, listOperators);

      ArrayList<String> expressionsStr = expressionsToStrings(expressions);
      removeDuplicates(expressionsStr);
      Collections.sort(expressionsStr);

      if (expressionsStr.size() == 0)
         System.out.println("void");
      else
         for (String s : expressionsStr)
            System.out.println(s);
      
      return expressionsStr;
   }

   // Creates a list with the permutations of the four numbers/simpleOperands
   private ArrayList<SimpleOperand> createListOperands() {
      Permutations<SimpleOperand> permutation = new Permutations<SimpleOperand>(operands);
      return permutation.withoutRepetition(0);
   }

   // Creates a list with the permutations of three operators
   private ArrayList<Operator> createListOperators() {
      Operator[] operators = { new Addition(), new Subtraction(), new Multiplication(), new Division() };
      Permutations<Operator> permutation = new Permutations<Operator>(operators);
      return permutation.threeWithRepetition();
   }

   // Creates all possible expressions with the desired value
   private ArrayList<ComplexOperand> createExpressions(ArrayList<SimpleOperand> listOperands, ArrayList<Operator> listOperators) {
      ArrayList<ComplexOperand> expressions = new ArrayList<ComplexOperand>();

      for (int i = 0; i < listOperands.size(); i += 4)
         for (int j = 0; j < listOperators.size(); j += 3)
            expressions.addAll(createExpressionsOrder(listOperands.subList(i, i + 4), listOperators.subList(j, j + 3)));

      return expressions;
   }

   // Creates the expressions in different orders of operations
   private ArrayList<ComplexOperand> createExpressionsOrder(List<SimpleOperand> listOperands, List<Operator> listOperators) {

      ArrayList<ComplexOperand> expressions = new ArrayList<ComplexOperand>();
      ComplexOperand complex1;
      ComplexOperand complex2;
      ComplexOperand expression;

      // ------- making the expression (((a b) c) d) -------
      complex1 = new ComplexOperand(listOperands.get(0), listOperands.get(1), listOperators.get(0));
      complex2 = new ComplexOperand(complex1, listOperands.get(2), listOperators.get(1));
      expression = new ComplexOperand(complex2, listOperands.get(3), listOperators.get(2));
      // Checks if the expression value is correct
      if (expression.value() == value)
         expressions.add(expression);

      // ------- making the expression ((a b) (c d)) -------
      complex1 = new ComplexOperand(listOperands.get(0), listOperands.get(1), listOperators.get(0));
      complex2 = new ComplexOperand(listOperands.get(2), listOperands.get(3), listOperators.get(2));
      expression = new ComplexOperand(complex1, complex2, listOperators.get(1));
      // Checks if the expression value is correct
      if (expression.value() == value)
         expressions.add(expression);

      // ------- making the expression (a (b (c d))) -------
      complex1 = new ComplexOperand(listOperands.get(2), listOperands.get(3), listOperators.get(2));
      complex2 = new ComplexOperand(listOperands.get(1), complex1, listOperators.get(1));
      expression = new ComplexOperand(listOperands.get(0), complex2, listOperators.get(0));
      // Checks if the expression value is correct
      if (expression.value() == value)
         expressions.add(expression);

      // ----- making the expression ((a (b c)) d) -------
      complex1 = new ComplexOperand(listOperands.get(1), listOperands.get(2), listOperators.get(1));
      complex2 = new ComplexOperand(listOperands.get(0), complex1, listOperators.get(0));
      expression = new ComplexOperand(complex2, listOperands.get(3), listOperators.get(2));
      // Checks if the expression value is correct
      if (expression.value() == value)
         expressions.add(expression);

      // ------- making the expression (a ((b c) d)) -------
      complex1 = new ComplexOperand(listOperands.get(1), listOperands.get(2), listOperators.get(1));
      complex2 = new ComplexOperand(complex1, listOperands.get(3), listOperators.get(2));
      expression = new ComplexOperand(listOperands.get(0), complex2, listOperators.get(0));
      // Checks if the expression value is correct
      if (expression.value() == value)
         expressions.add(expression);

      return expressions;
   }

   // Converts the list of ComplexOperand to a list of Strings
   private ArrayList<String> expressionsToStrings(ArrayList<ComplexOperand> expressions) {
      ArrayList<String> list = new ArrayList<String>();
      for (ComplexOperand expression : expressions)
         list.add(expression.toString());

      return list;
   }

   // Removes the duplicate Strings
   private void removeDuplicates(ArrayList<String> expressions) {
      Set<String> hs = new HashSet<>();
      hs.addAll(expressions);
      expressions.clear();
      expressions.addAll(hs);
   }
}