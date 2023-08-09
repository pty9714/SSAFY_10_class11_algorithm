import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B14719 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int rain[] = new int[W];
		int ans = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) {
			rain[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < W - 1; i++) {
			int left = 0;
			int right = 0;
			for (int j = 0; j < i; j++) {
				left = Math.max(left, rain[j]);
			}
			for (int j = i + 1; j < W; j++) {
				right = Math.max(right, rain[j]);
			}
			
			if(left > rain[i] && right > rain[i])
				ans += Math.min(left, right) - rain[i];
		}
		
		bw.write(ans + "");
		bw.close();
	}

}
