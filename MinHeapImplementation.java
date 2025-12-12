public class MinHeapImplementation implements MinHeapInterface {

    static final int DEFAULT_CAPACITY = 500;
    Task[] heap;
    boolean SJF;
    int size = 0;

    public MinHeapImplementation(boolean SJF)
    {
        heap = new Task[DEFAULT_CAPACITY];
        this.SJF = SJF;
    }

    /**  if SJF os true (using the shortest job first as priority) compares the time needed
     * if SJF is false it compares the deadline
     */
    private boolean compareTasks(Task a, Task b)
    {
        if(SJF) {
            if(!(a.getTimeNeeded()== b.getTimeNeeded())) return a.getTimeNeeded() < b.getTimeNeeded();
            return a.getDeadline().isBefore(b.getDeadline());
        } else
        {
            if(!(a.getDeadline().isEqual(b.getDeadline())))  return a.getDeadline().isBefore(b.getDeadline());
            return a.getTimeNeeded()< b.getTimeNeeded();
        }
    }

    @Override
    public void add(Task task) {

        heap[size] = task;
        int index = size;
        size++;

        heapifyUp(index);
    }

    @Override
    public Task poll() {

        if(size == 0)
        {
            return null;
        }

        Task smallestTask = heap[0];
        heap[0] = heap[size-1];
        size--;

        heapifyDown(0);

        return smallestTask;
    }

    public void heapifyUp(int index)
    {
        while(index > 0)
        {
            int parent = (index - 1) / 2;

            if(compareTasks(heap[parent], heap[index]))
            {
                break;
            }

            Task temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;
            index = parent;
        }
    }

    public void heapifyDown(int index)
    {
        while(true)
        {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;

            if(leftChild < size && compareTasks(heap[leftChild], heap[smallest]))
            {
                smallest = leftChild;
            }
            if(rightChild < size && compareTasks(heap[rightChild], heap[smallest]))
            {
                smallest = rightChild;
            }
            if(smallest == index)
            {
                break;
            }

            Task temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;
            index = smallest;
        }

    }

    @Override
    public Task peek() {
        if(size == 0)
        {
            return null;
        }
        return heap[0];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
