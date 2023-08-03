import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B9663 {
	
	public static int N, ans = 0;
	public static int[] queen;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());

		queen = new int[N];
		nQueen(0);
		
		bw.write(ans + "\n");
		
		bw.close();

	}
	
	public static void nQueen(int C) {
		if(C == N) {
			ans++;
			return;
		}
		for(int R = 0; R < N; R++) {
			queen[C] = R;
			if(check(C)) {
				nQueen(C + 1);
			}
		}		
	}
	
	public static boolean check(int C) {
		for(int i = 0; i < C; i++) {
			// 같은 행일 경우
			if(queen[i] == queen[C]) return false;
			// 대각선일 경우
			else if(Math.abs(C - i) == Math.abs(queen[C] - queen[i])) return false;
		}
		return true;
	}

}
// 5512ms