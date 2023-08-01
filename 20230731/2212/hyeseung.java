import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReade

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] matrix = new int[N];
		int[] diff = new int[N - 1];
		int ans = 0;
		
		String[] s = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			matrix[i] = Integer.parseInt(s[i]);
		}
		
		Arrays.sort(matrix);
		
		for(int i = 0; i < N - 1; i++) {
			diff[i] = matrix[i + 1] - matrix[i];
		}
		
		Arrays.sort(diff);
		
		for(int i = 0; i < N - K; i++) {
			ans += diff[i];
		}
		System.out.println(ans);
	}

}
