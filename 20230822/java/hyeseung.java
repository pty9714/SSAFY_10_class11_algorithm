import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S2819 {
	
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1}; 
	public static int ans;
	public static HashSet<String> numList = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int[][] map = new int[4][4];
		
		for (int test_case = 1; test_case <= T; test_case++) {
			numList.clear();
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {					
					dfs(map, i, j, "");
				}
			}
			bw.write("#" + test_case + " " + numList.size() + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int[][] map, int x, int y, String number) {
		if(number.length() == 7) {
			numList.add(number);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int tempx = x + dx[i];
			int tempy = y + dy[i];
			if(tempx < 0 || tempx >= 4 || tempy < 0 || tempy >= 4) continue;
			dfs(map, tempx, tempy, number + map[tempx][tempy]);
		}
	}

}
// 88,984 kb, 251 ms