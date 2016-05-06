import java.util.ArrayList;

public class Permutations<T> {

   T[] values;

   // Constructor
   public Permutations(T[] values) {
      this.values = values;
   }

   // Returns a list with all permutations without repetition
   public ArrayList<T> withoutRepetition(int k) {
      ArrayList<T> list = new ArrayList<T>();

      if (k == values.length - 1) {
         for (int i = 0; i < values.length; i++)
            list.add(values[i]);
      } else {
         T[] valuesClone = values.clone();
         for (int i = k; i < valuesClone.length; i++) {
            T temp = valuesClone[k];
            valuesClone[k] = valuesClone[i];
            valuesClone[i] = temp;
            list.addAll(new Permutations<T>(valuesClone).withoutRepetition(k + 1));
         }
      }

      return list;
   }

   // Returns a list with all permutations of 3 with repetition
   public ArrayList<T> threeWithRepetition() {
      ArrayList<T> list = new ArrayList<T>();

      for (int i = 0; i < values.length; i++)
         for (int j = 0; j < values.length; j++)
            for (int l = 0; l < values.length; l++) {
               list.add(values[i]);
               list.add(values[j]);
               list.add(values[l]);
            }
      return list;
   }
}
