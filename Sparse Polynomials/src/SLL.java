import java.util.Iterator;

class SLL<T> implements Iterable<T> {
   private int sz;
   private ILink<T> head;
   private ILink<T> last;

   interface ILink<T> {
      ILink<T> next();

      void setNext(ILink<T> l);

      T item();
   }

   // insert at the head
   public void insert(ILink<T> l) {
      if (head == null)
         head = last = l;
      else {
         last.setNext(l);
         last = l;
      }

      sz++;
   }

   public Iterator<T> iterator() {
      @SuppressWarnings("hiding")
      class SLLiterator<T> implements Iterator<T> {
         @SuppressWarnings("unchecked")
         private ILink<T> current = (ILink<T>) head;

         public boolean hasNext() {
            return current != null;
         }

         public T next() {
            T tmp = current.item();
            current = current.next();
            return tmp;
         }

         public void remove() {
         }
      }

      return new SLLiterator<T>();
   }
}