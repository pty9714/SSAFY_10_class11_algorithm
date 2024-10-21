import java.io.*;
import java.util.*;
public class Main{
	public static int N,M,max = Integer.MIN_VALUE;
	public static int[][] paper;	
	public static boolean[][] check;	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	paper = new int[N][M];
    	check = new boolean[N][M];
    	for(int i=0;i<N;i++) {
    		String str = br.readLine();
    		for(int j=0;j<M;j++) {
    			paper[i][j] = Character.getNumericValue(str.charAt(j));
    		}
    	}
    	dfs(0,0);		
    	bw.write(max + "\n");		
    	bw.flush();			
    	bw.close();
    	br.close();
    }
    
    public static void dfs(int x, int y) {
    	if(x==N) {	
    		sum();
    		return;
    	}
    	if(y==M) {
    		dfs(x+1,0);
    		return;
    	}
    	check[x][y] = true;	
    	dfs(x,y+1);
    	
    	check[x][y] = false;	
    	dfs(x,y+1);
    }
    public static void sum() {
    	int result = 0;
    	int temp;
    	for(int i=0;i<N;i++) {
    		temp = 0;
    		for(int j=0;j<M;j++) {
    			if(check[i][j]) {	
    				temp *= 10;
    				temp += paper[i][j];
    			}else {		
    				result += temp;
    				temp = 0;
    			}
    		}
    		result += temp;
    	}
    	for(int i=0;i<M;i++) {	
    		temp = 0;
    		for(int j=0;j<N;j++) {
    			if(!check[j][i]) {	
    				temp *= 10;
    				temp += paper[j][i];
    			}else {		
    				result += temp;
    				temp = 0;
    			}
    		}
			result += temp;
    	}
    	max = Math.max(max, result);	
    	return;
    }
}
