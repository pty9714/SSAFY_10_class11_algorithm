import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static class Paper{
		long r;
		long c;
		public Paper(long r, long c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());

		
		Queue<Paper> q = new LinkedList<>();
		q.add(new Paper(1, 1));
		
		
		for(int i =0 ; i < n; i++) {
			int size = q.size();
			
			for(int j = 0; j < size; j++) {
				Paper temp = q.poll();
				q.add(new Paper(temp.r + 1, temp.c));
				q.add(new Paper(temp.r, temp.c + 1));
			}
		}
		HashSet<Long> hs = new HashSet<>();
		while(!q.isEmpty()) {
			Paper temp = q.poll();
			hs.add(temp.c * temp.r);
		}

		
		if(hs.contains(k)) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}

}
