public interface MinHeapInterface {

    /**
     * adding a new element to the heap
     * @param task
     */
    void add(Task task);

    /**
     * remove and return the smallest element of the heap
     * @return task
     */
    Task poll();

    /**
     * return the smallest element without removing
     * @return task
     */
    Task peek();

    /**
     * check if heap is empty
     * @return boolean
     */
    boolean isEmpty();

    /**
     * returns the size of the heap
     * @return size
     */
    int size();
}
