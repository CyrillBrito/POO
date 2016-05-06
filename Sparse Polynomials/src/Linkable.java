
class Linkable<T> implements SLL.ILink<T> {
   private T item;
   private SLL.ILink<T> next;

   public Linkable(T o) {
      item = o;
      next = null;
   }

   public SLL.ILink<T> next() {
      return next;
   }

   public void setNext(SLL.ILink<T> l) {
      next = l;
   }

   public T getItem() {
      return item;
   }

   public T item() {
      return item;
   }
}