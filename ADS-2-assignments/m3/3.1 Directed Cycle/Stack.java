/*************************************************************************
 *  Compilation:  javac Stack.java
 *  Execution:    java Stack < input.txt
 *
 *  A generic stack, implemented using a linked list. Each stack
 *  element is of type Item.
 *  
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is
 *
 *  % java Stack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 *  The <tt>Stack</tt> class represents a last-in-first-out (LIFO) stack of generic items.
 *  It supports the usual <em>push</em> and <em>pop</em> operations, along with methods
 *  for peeking at the top item, testing if the stack is empty, and iterating through
 *  the items in LIFO order.
 *  <p>
 *  All stack operations except iteration are constant time.
 *  <p>
 *  For additional documentation, see <a href="/algs4/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class Stack<Item> implements Iterable<Item> {
    /**
     * N.
     */
    private int N;  
    /**
     * first.
     */// size of the stack
    private Node first;     // top of stack

    //
    // helper linked list class /* private class Node { /**
    //          * item. */
    //
        private Item item;
        /**
         * next.
         */
        private Node next;
    }

   /**
     * Create an empty stack.
     */
    public Stack() {
        first = null;
        N = 0;
    }

   /**
     * Is the stack empty?
     */
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }
   /**
     * Return the number of items in the stack.
     */
    /**
     * size.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return N;
    }

    /**
     * Add the item to the stack.
     */
    /**
     * push.
     *
     * @param      item  The item
     */
    public void push(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

   /**
     * Delete and return the item most recently added to the stack.
     * Throw an exception if no such item exists because the stack is empty.
     */
    /**
     * pop.
     *
     * @return     { description_of_the_return_value }
     */
    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        N--;
        return item;                   // return the saved item
    }
   /**
     * Return the item most recently added to the stack.
     * Throw an exception if no such item exists because the stack is empty.
     */
    /**
     * peek.
     *
     * @return     { description_of_the_return_value }
     */
    public Item peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return first.item;
    }

   /**
     * Return string representation.
     */
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString();
    }
    /**
     * Return an iterator to the stack that
     * iterates through the items in LIFO order.
     */
    /**
     * Iterator.
     *
     * @return     { description_of_the_return_value }
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    // an iterator, doesn't implement remove() since it's optional
    /**
     * class.
     */
    private class ListIterator implements Iterator<Item> {
        /**
         * current.
         */
        private Node current = first;
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
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
   /**
     * A test client.
     */
/*    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }*/
}







