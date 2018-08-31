public class HeapNode {
int key;
int total_time;
RB_Node rb_Node;
public HeapNode(int total_time,int executionTime,RB_Node rb_Node)
{
    key=executionTime;
    this.rb_Node=rb_Node;
    this.total_time=total_time;
}
public HeapNode()
{   
}
}
