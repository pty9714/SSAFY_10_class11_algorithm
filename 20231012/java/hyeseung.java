import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 	11600KB, 80ms
public class B20444 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String answer = "NO";
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		long left = 0;
		long right = N / 2;
		while(left <= right) {
			long row = (left + right) / 2;
			long col = N - row;
			long temp = (row + 1) * (col + 1);
			if(temp == K) {
				answer = "YES";
				break;
			}
			else if(temp > K) {
				right = row - 1;
			}
			else if(temp < K) {
				left = row + 1;
			}
		}
		
		bw.write(answer + "");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
