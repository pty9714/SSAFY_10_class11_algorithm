import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12048KB, 420ms
public class B1052 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int ans = 0, cnt, temp;
		
		while(true) { // 하나씩 물병 채우면서 K개 만족하는지 확인
			cnt = 0; // 합쳐지지 않는 물병의 개수
			temp = N;
			while(temp != 0) {
				if(temp % 2 == 1) cnt++;
				temp /= 2;
			}
			if(cnt <= K) break;
			ans++;
			N++;
		}
		
		bw.write(String.valueOf(ans));
		
		bw.flush();
		bw.close();
		br.close();
	}

}
