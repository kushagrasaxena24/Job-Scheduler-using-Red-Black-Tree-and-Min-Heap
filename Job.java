import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Job {
	
	
	public RB_tree rbTree;
	public MinHeap heap;
	public int jobID;
	ArrayList<String> result;
	public Job()
	{
		this.heap=new MinHeap();
		this.rbTree=new RB_tree();
		this.result=new ArrayList<String>();
		
	}
	public void WritetoFile() 
	{
		try{
		BufferedWriter writer=new BufferedWriter(new FileWriter("output_file.txt"));
		
		for(int i=0;i<result.size();i++){
		writer.append(result.get(i));
		writer.append('\n');
		}
		writer.close();
		}
		catch(IOException e)
		{
		e.printStackTrace();
		}
	}
	public  void NextJob(int ID){
		RB_Node newNode=rbTree.Search(rbTree.NextJob(ID), rbTree.root);
		result.add("("+rbTree.NextJob(ID)+","+newNode.execution_time+","+newNode.total_time+")");

	}
	public void PreviousJob(int ID){
		RB_Node newNode=rbTree.Search(rbTree.PreviousJob(ID), rbTree.root);
		result.add("("+rbTree.PreviousJob(ID)+","+newNode.execution_time+","+newNode.total_time+")");
	}
	public void Insert(int ID,int total_time,int executionTime){
		rbTree.Insert(ID,total_time,executionTime);
		RB_Node newNode=rbTree.Search(ID, rbTree.root);
		heap.insert(total_time,executionTime,newNode);

	}
	public  void PrintJob(int ID){
		RB_Node newNode=rbTree.Search(ID, rbTree.root);
		if(newNode.isEmpty())
		{
			result.add("(0,0,0)");
		
		}
		result.add("("+rbTree.PrintJob(ID)+","+newNode.execution_time+","+newNode.total_time+")");
	}
	public  void PrintJob(int ID1, int ID2){
		ArrayList<Integer>res=rbTree.PrintJob(ID1,ID2);
		String s="";
		if(res.size()==0)
		result.add("(0,0,0)");
		else
		{
		for(int i = 0; i < res.size(); i++){
			RB_Node newNode=rbTree.Search(res.get(i), rbTree.root);
			s+="("+res.get(i)+","+newNode.execution_time+","+newNode.total_time+")";
			if(i!=res.size()-1)
			{
				s+=",";
			}
		}
		result.add(s);
	 }
	}

}
