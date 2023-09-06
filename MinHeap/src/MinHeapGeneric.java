public class MinHeapGeneric <T extends Comparable<T>> 
{

	public T[] heap;
	private int size;
	private static final int DEFAULT_CAPACITY = 8;
	/**
	 * contructor setting the heap with a size of the default
	 */
	public MinHeapGeneric() 
	{
		heap = (T[]) new Comparable[DEFAULT_CAPACITY + 1];
	}
	/**
	 * second constructor which inputs all values from the param into the heap array
	 * @param vals
	 */
	public MinHeapGeneric(T... vals) 
	{
		heap = (T[]) new Comparable[vals.length + 1];
		for (int i = 0; i < vals.length; i++) {
			heap[i + 1] = vals[i];
		}
		buildHeap();
	}
	/**
	 * builds the heap by creating a for loop the size of half of the array
	 */
	private void buildHeap() 
	{
		for (int i = this.heap.length / 2; i >= 1; i--) 
		{
			heapify(i);
		}
	}
	/**
	 * heapify will recurse (is that a word?) if all previous if statements fail
	 * but checks the left and right childs and will input it if true
	 * @param index
	 */
	private void heapify(int index) 
	{
		int temp = index;
		if (inBounds(getLeftChildIndex(index)) && heap[(index * 2)] != null && heap[getLeftChildIndex(index)].compareTo(heap[temp]) < 0) 
		{
			temp = getLeftChildIndex(index);
		}
		if (inBounds(getRightChildIndex(index)) && heap[(index * 2) + 1] != null && heap[getRightChildIndex(index)].compareTo(heap[temp]) < 0) 
		{
			temp = getRightChildIndex(index);
		}
		if (temp != index) 
		{
			swap(index, temp);
			heapify(temp);
		}
	}
	/**
	 * checks if the index is within the boundary
	 * @param index
	 * @return
	 */
	private boolean inBounds(int index) 
	{
		return index < size;
	}
	/**
	 * inserts the number into the heap
	 * @param num
	 */
	public void insert(T num) 
	{
		if (size == heap.length - 1) 
		{
			doubleCapacity();
		}
		int temp = size + 1;
		heap[temp] = num;
		bubbleUp(temp);
		size++;
	}
	/**
	 * returns the lowest value in heap
	 * @return
	 */
	public T popMinimum() 
	{
		T pop = peekMinimum();
		T lastVal = heap[size];
		heap[size] = null;
		size--;
		heap[1] = lastVal;
		siftDown(1);
		return pop;
	}
	/**
	 * returns largest value in heap
	 * @return
	 */
	public T peekMinimum() 
	{
		return heap[1];
	}
	/**
	 * returns size of heap
	 * @return
	 */
	public int getSize() 
	{
		return size;
	}
	/**
	 * checks if heap is empty
	 * @return
	 */
	public boolean isEmpty() 
	{
		return size == 0;
	}
	/**
	 * returns the left child in the priority queue
	 * @param index
	 * @return
	 */
	private int getLeftChildIndex(int index) 
	{
		return index * 2;
	}
	/**
	 * returns the left child in the priority queue
	 * @param index
	 * @return
	 */
	private int getRightChildIndex(int index)
	{
		return index * 2 + 1;
	}
	/**
	 * returns the root of the priority queue
	 * @param index
	 * @return
	 */
	private int getParentIndex(int index) 
	{
		return index / 2;
	}
	/**
	 * doubles to size of heap capacity when called
	 */
	private void doubleCapacity()
	{
		T[] dubArr = (T[]) new Comparable[heap.length * 2];
		for (int i = 1; i < heap.length; i++)
		{
			dubArr[i] = heap[i];
		}
		heap = dubArr;
	}
	/**
	 * restructures the tree so the param is in proper position
	 * @param index
	 */
	private void bubbleUp(int index)
	{
		if (heap[getParentIndex(index)] == null) 
		{
			return;
		}
		if (heap[index].compareTo(heap[getParentIndex(index)]) < 0)
		{
			swap(index, getParentIndex(index));
			bubbleUp(getParentIndex(index));
		}
	}
	/**
	 * moves the head down to its correct position based on param
	 * @param index
	 */
	private void siftDown(int index) 
	{
		if (heap[getLeftChildIndex(index)] == null && heap[getRightChildIndex(index)] == null) 
		{
			return;
		}
		if (heap[getLeftChildIndex(index)] != null && heap[getRightChildIndex(index)] == null) 
		{
			if (heap[index].compareTo(heap[getLeftChildIndex(index)]) > 0)
			{
				swap(index, getLeftChildIndex(index));
			}
			return;
		} 
		else if (heap[getLeftChildIndex(index)] == null && heap[getRightChildIndex(index)] != null) 
		{
			if (heap[index].compareTo(heap[getRightChildIndex(index)]) > 0)
			{
				swap(index, getRightChildIndex(index));
			}
			return;
		}
		 if (heap[index].compareTo((heap[getLeftChildIndex(index)].compareTo(heap[getRightChildIndex(index)]) < 0 ? heap[getLeftChildIndex(index)] : heap[getRightChildIndex(index)])) > 0) {
             int swapIndex = heap[getLeftChildIndex(index)].compareTo(heap[getRightChildIndex(index)]) < 0 ? getLeftChildIndex(index) : getRightChildIndex(index);
			swap(index, swapIndex);
			siftDown(swapIndex);
		}
	}
	/**
	 * switches the indexes of the param in the heap
	 * @param index1
	 * @param index2
	 */
	private void swap(int index1, int index2)
	{
		T temp = heap[index2];
		heap[index2] = heap[index1];
		heap[index1] = temp;
	}
	/**
	 * normal toString
	 */
	@Override
	public String toString() 
	{
		String output = "";
		for (int i = 1; i <= getSize(); i++)
			output += heap[i] + ", ";
		return output.substring(0, output.lastIndexOf(","));
	}
	/** method borrowed with minor modifications from the internet somewhere, for printing */
	public void display() 
	{
		int nBlanks = 32, itemsPerRow = 1, column = 0, j = 1;
		String dots = "...............................";
		System.out.println(dots + dots);
		while (j <= this.getSize()) 
		{
			if (column == 0)
				for (int k = 0; k < nBlanks; k++)
					System.out.print(' ');
			System.out.print((heap[j] == null) ? "" : heap[j]);
			if (++column == itemsPerRow)
			{
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			} else
				for (int k = 0; k < nBlanks * 2 - 2; k++)
					System.out.print(' ');
			j++;
		}
		System.out.println("\n" + dots + dots);
	}
}