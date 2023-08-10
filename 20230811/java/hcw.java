import java.io.*;
import java.util.*;

public class Main {
	static int[] num =  {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
	
	
	static LinkedList<Long> list = new LinkedList<Long>();
	static void dfs(int count, int depth, int index,  long sum) {
		
		if(count == depth) {
			list.add(sum);
			return;
		}else {
			for(int i =index; i< 10; i++) {
				dfs(count, depth+1 , i+1, sum * 10 + (long)num[i]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		if(N < 1024) {
			for(int i = 1; i <= 10; i++) {
				dfs(i, 0, 0, 0);
			}
			Collections.sort(list);
			System.out.println(list.get(N-1));

		}else {
			System.out.println(-1);
		}
	}
}

//12116KB	96ms
