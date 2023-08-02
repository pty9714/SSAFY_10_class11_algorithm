import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringTokenizer st;
       
       int T = Integer.parseInt(br.readLine());
       
       for(int i = 0; i < T; i++) {
    	   st = new StringTokenizer(br.readLine());
    	   int N = Integer.parseInt(st.nextToken());
    	   int M = Integer.parseInt(st.nextToken());
    	   LinkedList<int[]> q = new LinkedList<>();
    	   int ans = 0;
    	   
    	   st = new StringTokenizer(br.readLine());
    	   for(int j = 0; j < N; j++) {
    		   q.offer(new int[] {j, Integer.parseInt(st.nextToken())});
    	   }
    	   
    	   while(!q.isEmpty()) {
    		   int[] document = q.poll();
    		   boolean print = false;
    		   for(int j = 0; j < q.size(); j++) {
    			   if(document[1] < q.get(j)[1]) {
    				   q.offer(document);
    				   print = true;
    				   break;
    			   }
    		   }
    		   if(!print) {
    			   ans++;
	    		   if(document[0] == M) {
	    			   break;
	    		   }	
    		   }
    	   }
    	  
    	   bw.write(ans + "\n");
       }
       bw.close();
	}
}
