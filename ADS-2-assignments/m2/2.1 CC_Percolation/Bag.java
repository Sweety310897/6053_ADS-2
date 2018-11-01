import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for bag.
 *
 * @param      <Item>  The item
 */
public class Bag<Item> implements Iterable<Item> {
    /**
     * N.
     */
    private int N;         // number of elements in bag
    /**
     * first.
     */
    private Node first;    // beginning of bag
    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

   /**
     * Create an empty stack.
     */
    public Bag() {
        first = null;
        N = 0;
    }

   /**
     * Is the BAG empty?
     */
    public boolean isEmpty() {
        return first == null;
    }

   /**
     * Return the number of items in the bag.
     */
    public int size() {
        return N;
    }
    /**
     * add.
     *
     * @param      item  The item
     */
    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    /**
     * Iterator.
     *
     * @return     { description_of_the_return_value }
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    //
    // an iterator, doesn't implement remove() since it's optional /* private
    // class ListIterator implements Iterator<Item> { private Node current =
    // first; /**
    //          * Determines if it has next.
    //          * { list_item_description }
    //          * { list_item_description }
    //
    // @return     True if has next, False otherwise. */
    //
        public boolean hasNext() {
            return current != null;
        }
        /**
         * remove.
         */
        public void remove() { 
            throw new UnsupportedOperationException();
        }
        /**
         * next.
         *
         * @return     { description_of_the_return_value }
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
