
public class Polynomial extends SLL<Term> {

   public Polynomial() {
   }

   public Polynomial(String s) {
      String[] aos = s.split(" ");
      int size = aos.length / 2;

      Term term;
      Linkable<Term> link;
      for (int i = 0; i < size; i++) {
         term = new Term(Double.parseDouble(aos[i * 2]), Double.parseDouble(aos[i * 2 + 1]));
         link = new Linkable<Term>(term);
         insert(link);
      }
   }

   public Polynomial sum(Polynomial p) {
      for (Term term : this)
         p = p.addTermToList(term);

      return p;
   }

   public Polynomial mult(Polynomial p) {
      Polynomial result = new Polynomial();

      for (Term termA : this) {
         for (Term termB : p) {
            Term term = new Term(termA.getCoefficient() * termB.getCoefficient(),
                  termA.getExponent() + termB.getExponent());
            result = result.addTermToList(term);
         }
      }

      return result;
   }

   public int compute(double x) {
      double result = 0;

      for (Term term : this)
         result += term.getCoefficient() * Math.pow(x, term.getExponent());

      return (int) result;
   }

   public String toString() {
      String s = "";
      boolean firstLine = true;

      for (Term term : this) {
         if (firstLine) {
            s += term;
            firstLine = false;
         } else
            s += " " + term;
      }

      return s;
   }

   private Polynomial addTermToList(Term term) {

      Polynomial result = new Polynomial();
      boolean inserted = false;

      for (Term listTerm : this) {
         if (term.getExponent() > listTerm.getExponent() && !inserted) {
            inserted = true;
            result.insert(new Linkable<Term>(term));
            result.insert(new Linkable<Term>(listTerm));
         } else if (term.getExponent() == listTerm.getExponent() && !inserted) {
            inserted = true;
            Term sum = new Term(term.getCoefficient() + listTerm.getCoefficient(), term.getExponent());
            if (sum.getCoefficient() != 0)
               result.insert(new Linkable<Term>(sum));
         } else
            result.insert(new Linkable<Term>(listTerm));
      }

      if (!inserted)
         result.insert(new Linkable<Term>(term));

      return result;
   }
}