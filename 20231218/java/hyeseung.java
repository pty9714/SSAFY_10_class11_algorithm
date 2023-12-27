import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B10159 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] scale = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			scale[x][y] = 1;
			scale[y][x] = -1;
		}
		
		for (int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(scale[i][k] == scale[k][j] && scale[i][k] != 0)
						scale[i][j] = scale[i][k];
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			int ans = 0;
			for(int j = 1; j <= N; j++) {
				if(i == j)
					continue;
				
				if(scale[i][j] == 0 && scale[j][i] == 0)
					ans++;
			}
			bw.write(ans);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
