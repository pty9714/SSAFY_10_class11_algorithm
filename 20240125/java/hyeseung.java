import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1285 {
	
	public static int N, ans;
	public static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			minTail(i);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int minTail(int row) {
		int temp = 0;
		for (int i = 0; i < N; i++) {
			if((row & (1 << i)) != 0) {
				
			}
		}
	}

}
