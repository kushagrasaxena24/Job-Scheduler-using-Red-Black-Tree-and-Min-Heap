public class RB_Node {
	int ID;
	int count;
	int total_time;
	int execution_time;
	RB_Node left, right, parent;
    Color color;
	public RB_Node(int ID, int count, RB_Node left, RB_Node right,
			RB_Node parent, Color color,int total_time,int execution_time) {
		
		this.ID = ID;
		this.count = count;
		this.left = left;
		this.right = right;
		this.parent = parent;
		this.color = color;
		this.total_time=total_time;
		this.execution_time=execution_time;
	}
	public RB_Node(){}
	public boolean isEmpty(){
		return false;
	}
}
