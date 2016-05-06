
public class Term {

   private double coe;
   private double exp;

   // Constructor
   public Term(double coe, double exp) {
      this.coe = coe;
      this.exp = exp;
   }

   // Coefficient Access
   public double getCoefficient() {
      return coe;
   }

   // Exponent Access
   public double getExponent() {
      return exp;
   }

   public String toString() {
      return (int) coe + " " + (int) exp;
   }
}
