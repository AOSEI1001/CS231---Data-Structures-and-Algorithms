
/**
 * name: Abisa Osei-Amankwah
 * purpose: job.java
 * last updated: 10/23/23
 */

 public interface Queue<T> {
    //first in first out, last in last out 
    //the shortest queue (shopping cart reference), fewest carts in the lineor fewest items in the carts , or random or round robin(alternate between the first two)
    //carts  = jobs, grocery items = times, lines = servers

    /**
     * Adds the given {@code item} to the end of this queue.
     * 
     * @param item the item to add to the queue.
     */
    public void offer(T item);

    /**
     * Returns the number of items in the queue.
     * @return the number of items in the queue.
     */
    public int size();

    /**
     * Returns the item at the front of the queue.
     * @return the item at the front of the queue.
     */
    public T peek();

    /**
     * Returns and removes the item at the front of the queue.
     * @return the item at the front of the queue.
     */
    public T poll();
}
