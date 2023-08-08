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
		
		int left = 0;
		int right = 1;
		while(right < W) {
			int min = rain[left];
			int index = left;
			while(index <= right && rain[index] > rain[right]) {
				index++; right++;
				if(right >= W) break;
			}
			min = Math.min(min, rain[right - 1]);
			for(int i = left + 1; i < right - 1; i++) {
				ans += min - rain[i];
			}
			left = right++;
		}
//		while(right < W) {
//			while(rain[left] > rain[right++]) {
//				if(right >= W) break;
//			}
//			int min = Math.min(rain[left], rain[right - 1]);
//			for(int i = left + 1; i < right - 1; i++) {
//				ans += min - rain[i];
//			}
//			left = right++;
//		}
		
		bw.write(ans + "");
		bw.close();
	}

}
