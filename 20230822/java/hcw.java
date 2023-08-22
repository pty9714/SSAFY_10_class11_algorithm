import java.io.*;
import java.util.*;

public class Solution {
	
	
	static int[] dx = {1, 0, 0, -1};
	static int[] dy = {0, 1, -1, 0};
	static int[][] arr;
	private static void dfs(int count, int y, int x, HashSet<Integer> hm, int current) {
		if(count == 7) {
			hm.add(current);
			return;
		}else {
			for(int k =0; k < 4; k++) {
				if(x + dx[k] >= 0 && x + dx[k] < 4 && y+dy[k] >= 0 && y+dy[k] < 4) {
					dfs(count+1, y+dy[k], x + dx[k], hm, current*10 + arr[y+dy[k]][x + dx[k]]);
				}
			}
		}
    }
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test = 1; test <= T; test++) {
			arr = new int[4][4];
			HashSet<Integer> hm = new HashSet<>();
			
			for(int i =0;i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0; j < 4; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i =0;i < 4; i++) {
				for(int j =0; j < 4; j++) {
					dfs(0, i, j, hm, 0);
				}
			}
			System.out.println("#" + test + " " + hm.size());
		}
	}

}

43,304 kb
202 ms
