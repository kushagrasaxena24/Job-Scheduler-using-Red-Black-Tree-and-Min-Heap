import java.io.*;
import java.lang.*;
class jobscheduler
{
    static HeapNode n=null;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        //finding total time for execution for the counter to run
	BufferedReader tr = new BufferedReader(new FileReader(args[0]));
        String l;
        long max_time=0;
        int counter=0,isBusy=0;
        while((l = tr.readLine()) != null)
        {
            if(l.split(" ")[1].split("\\(")[0].equalsIgnoreCase("Insert"))
            max_time+=Long.parseLong(l.split(",")[1].split("\\)")[0])+Long.parseLong(l.split(":")[0]);
        }

	//parsing the input file to recognize commands given by user
        String line= br.readLine();;
        int jobID,jobID2;
        Job job=new Job();
        long time_counter =0;
        int total_time=0,p,executionTime=0;
            long arrival_time=Integer.parseInt(line.split(":")[0]);
            String split=line.split(" ")[1];
            String test_str=(split.split("\\("))[0];
            String arg=(split.split("\\("))[1];
           
        for(time_counter=0;time_counter<=max_time;time_counter++)
            {
            if(arrival_time==time_counter){
            if(test_str.equalsIgnoreCase("Insert")){
                
                jobID=Integer.parseInt(arg.split("\\)")[0].split(",")[0]);
                total_time=Integer.parseInt(arg.split("\\)")[0].split(",")[1]);
                job.Insert(jobID,total_time,executionTime);
            }
            if(test_str.equalsIgnoreCase("PrintJob") ){
                if(arg.split("\\)")[0].split(",").length==1)
                {
                    jobID=Integer.parseInt(arg.split("\\)")[0].split(",")[0]);
                    job.PrintJob(jobID);
                }
                if(arg.split("\\)")[0].split(",").length==2)
                {
                    jobID=Integer.parseInt(arg.split("\\)")[0].split(",")[0]);
                    jobID2=Integer.parseInt(arg.split("\\)")[0].split(",")[1]);
                    job.PrintJob(jobID,jobID2);
                }
            }
            if(test_str.equalsIgnoreCase("NextJob") ){
                jobID=Integer.parseInt(arg.split("\\)")[0].split(",")[0]);
                job.NextJob(jobID);
            }
           if(test_str.equalsIgnoreCase("PreviousJob") ){
                jobID=Integer.parseInt(arg.split("\\)")[0].split(",")[0]);
                job.PreviousJob(jobID);
            }
          
        if((line = br.readLine()) != null)
        {
            arrival_time=Integer.parseInt(line.split(":")[0]);
             split=line.split(" ")[1];
             test_str=(split.split("\\("))[0];
             arg=(split.split("\\("))[1];
        }
	//writing all outputs to file
        job.WritetoFile();
        
    }
	//scheduling if there is a node present in the scheduler
        if(isBusy==0)
        {
            if(job.heap.isEmpty()) 
            {
                continue;
            }
            else
            {
                n=job.heap.extractMin();
                if((n.total_time-n.key)<=0)
            {
                job.rbTree.delete(n.rb_Node);
                if(!job.heap.isEmpty())
                {
                    n=job.heap.extractMin();
                    isBusy=1;
                }
                
                else 
                {
                    continue;
                }
                

            }
                isBusy=1;
            }
        }
	//scheduling if there is no node present in the scheduler 
        if(isBusy==1)
        {
            if((n.total_time-n.key)<=0)
            {
                job.rbTree.delete(n.rb_Node);
                if(!job.heap.isEmpty())
                {
		    //new node is dispatched to scheduler for processing
                    n=job.heap.extractMin();
                    isBusy=1;
                }
                
                else 
                {
                    continue;
                }
            }
            counter++;
            n.key+=1;
            n.rb_Node.execution_time+=1;
	    //inserting data back if file not executed completely
            if(counter==5)
            {
                counter=0;
                job.heap.insert(n.total_time, n.key, n.rb_Node);
                isBusy=0;
            }
        }
    }


        br.close();
     }
}
