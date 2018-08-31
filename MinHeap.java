import java.util.ArrayList;

public class MinHeap {

    private HeapNode arr[];
    int counter_size;

    public MinHeap() {
        this.arr=new HeapNode[100];
        counter_size=0;
    }

//Inserts data into heap node with execution time as key
    public void insert(int total_time,int executionTime,RB_Node node) {
        HeapNode n=new HeapNode(total_time,executionTime,node);
        if(counter_size==arr.length)
        arrayDoubling();
        arr[counter_size]=n;
        counter_size++;
        int i = counter_size - 1;
        int parent = parent(i);

        while (parent != i && arr[i].key < arr[parent].key) {

            replace(i, parent);
            i = parent;
            parent = parent(i);
        }
    }
	//Returns the current size of min heap
    public int getSize()
    {
     	return counter_size;
    }
    //doubles size of existing array 
    public void arrayDoubling()
    {
        HeapNode z[]=new HeapNode[2*counter_size];
        if(counter_size==arr.length)
        {
            for(int i=0;i<counter_size;i++)
                z[i]=arr[i];
        }
        arr=z;
    }

    public void buildHeap() {

        for (int i = counter_size / 2; i >= 0; i--) {
            Heapify(i);
        }
    }
    //returns minimum elemnt from Heap
    public HeapNode extractMin() {

        if (counter_size == 0) {

            throw new IllegalStateException("MinHeap is currently empty");
            
        } else if (counter_size == 1) {

            HeapNode min = remove(0);
            --counter_size;
            
            return min;
        }
        HeapNode min = arr[0];
        HeapNode lastItem = remove(counter_size - 1);
        arr[0]=lastItem;

        Heapify(0);
        --counter_size;
        return min;
    }
    public HeapNode remove(int pos)
    {
        HeapNode z=arr[pos];
        for(int i=pos;i<counter_size-1;i++)
        {
            arr[i]=arr[i+1];
        }
        return  z;
    }

//Heapify operation for rebalancing of Heap
    private void Heapify(int i) {

        int left = left(i);
        int rightNode = rightNode(i);
        int smallest = -1;

        if (left <= counter_size - 1 && arr[left].key < arr[i].key) {
            smallest = left;
        } else {
            smallest = i;
        }

        if (rightNode <= counter_size - 1 && arr[rightNode].key < arr[smallest].key) {
            smallest = rightNode;
        }

        if (smallest != i) {

            replace(i, smallest);
            Heapify(smallest);
        }
    }

    public HeapNode getMin() {

        return arr[0];
    }

    public boolean isEmpty() {
        if(counter_size == 0)
        return true;
        else
        return false;
    }

    private int rightNode(int i) {

        return 2 * i + 2;
    }

    private int left(int i) {

        return 2 * i + 1;
    }

    private int parent(int i) {

        if (i % 2 == 1) {
            return i / 2;
        }

        return (i - 1) / 2;
    }

    private void replace(int i, int parent) {

        HeapNode temp = arr[parent];
        arr[parent]=arr[i];
        arr[i]=temp;
    }

}

