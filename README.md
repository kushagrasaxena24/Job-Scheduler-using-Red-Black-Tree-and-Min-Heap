# Job-Scheduler-using-Red-Black-Tree-and-Min-Heap

Job Scheduler schedules jobs using Min-heap and RB tree.
The key for the min heap is executed_time and that for the RBT is jobID. 
Pointers are maintained between correspondent nodes in the min heap and the RBT.

Implementation of JobScheduler
The project contains a job scheduler which schedules jobs which are created in the jobs file. The scheduler uses MinHeap and RedBlack Tree for scheduling and has various functions including
NextJob(int ID)
PreviousJob(int ID)
Insert(int ID, int total_time, int executionTime) PrintJob(int ID)
PrintJob(int ID1 ,int ID2)
  
Node Structures
The node structure of MinHeap and RedBlack Tree are as follows
A pointer has been kept between the nodes linking the corresponding nodes in MinHeap and RedBlack Trees.
The java file Job.java contains the reference of the MinHeap and Redblack Trees.

Control Flow
The programs starts with jobscheduler where it parses the input files and executes the command if the time counter is same as the arrival time.
It simultaneously dispatches the job with minimum execution time to be processed. If the job is not completed the execution time is increased 
otherwise it is removed from both the redblack tree and the minheap. Once all the commands in the sample file have been executed the output
is written to file via WritetoFile function.

Implementation of MinHeap
It contains the basic functions requires in a min heap including: 
Insert : Inserts a new element into Min Heap
Heapify:Rearranges the heap after changes
Array Doubling : Doubles the size of array when capacity is reached
Extract Minimum : extracts and removes min element from heap
Replace : replaces ith node with the parent node
leftNode : returns position of left node rightNode : returns position of right node
parentNode : returns position of Parent node isEmpty : checks if the minHeap is empty
         
Implementation of Red-Black Tree
Insert : to insert new node into red black tree
PrintJob : to print jobs with a particular ID
PrintJob(id1,id2) :to print all jobs with id between ID1 and ID2
PreviousJob :to print job with ID just less than the provided ID NextJob : to print job with ID just greater than provided ID
Search : searches for the job with given unique ID
Left Rotation :To do LL rotation on given node
Right Rotation : To do RR rotation on given node
Replace: Replace two nodes with each others values
Delete :Delete a particular node
