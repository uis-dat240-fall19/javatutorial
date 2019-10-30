package threads;


import java.util.Arrays;

/* Implement a BoundedQueue that supports a data structure which is of fixed size and circular,
i.e, insert at the end and the items are being pulled from front should be done in a circular fashion.
I.e, if the end position exceeds the size of the array the index of end should be
fixed appropriately to the beginning of the array. If the queue is full return an error
Notice the T, it makes the code to work for any type of items.
*/

public class ThreadSafeBoundedQueue<T> {
	
	  private int enqueueIndex;// Separate index to ensure enqueue happens at the end
	  private int dequeueIndex;// Separate index to ensure dequeue happens at the
	                           // start
	  private T[] items;
	  private int count;

	  @SuppressWarnings("unchecked")
	public ThreadSafeBoundedQueue(int size) {
	    // Todo implement the constructor to create a bounded queue of ssize size
	    enqueueIndex = 0;
	    dequeueIndex = 0;
	    items = (T[]) (new Object[size]);
	  }

	  // Returns 0 if insertion was successful -1 if it fails
	  public Integer insertItem(T item) {
	    // Write code to insert item at the 'end'
	    if (count == items.length)
	      return -1;
	    items[enqueueIndex] = item;
	    enqueueIndex = ++enqueueIndex == items.length ? 0 : enqueueIndex;
	    ++count;
	    return 0;
	  }

	  public T getFront() {
	    // Write code to return the item at the front and remove that item from the
	    // queue
	    if (count == 0)
	      throw new IllegalStateException();
	    T item = items[dequeueIndex];
	    dequeueIndex = ++dequeueIndex == items.length ? 0 : dequeueIndex;
	    --count;
	    return item;
	  }
  
  
  public String toString() {
	  return Arrays.toString(items);
  }
  
  
  public static void main(String[] args) {
	ThreadSafeBoundedQueue<Integer> NewQueue = new ThreadSafeBoundedQueue<Integer>(4);
  	
  	NewQueue.insertItem(9);
  	NewQueue.insertItem(5);
  	NewQueue.insertItem(6);
  	NewQueue.insertItem(7);
  	System.out.println(NewQueue);
  	
  	System.out.println(NewQueue.getFront());
  	System.out.println(NewQueue.getFront());
  	System.out.println(NewQueue);
  	
  	
  	NewQueue.insertItem(11);
  	System.out.println(NewQueue);
  	NewQueue.insertItem(12);
  	System.out.println(NewQueue);
  	
  	System.out.println(NewQueue.getFront());
  	System.out.println(NewQueue.getFront());
  	System.out.println(NewQueue.getFront());
  	System.out.println(NewQueue);
  	
  	NewQueue.insertItem(13);
  	NewQueue.insertItem(14);
  	System.out.println(NewQueue);
  }
}


