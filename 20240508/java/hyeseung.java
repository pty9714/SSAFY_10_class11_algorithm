import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 168844KB, 508ms
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int temp[] = new int[d + 1];
		int[] sushi = new int[N];
		int ans = 0;

		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
			if(i < k && temp[sushi[i]]++ == 0) {
				ans++;
			}
		}

		if(temp[c]++ == 0) ans++;
		int cnt = ans;
		for (int i = 1; i < N; i++) {
			int j = i + k - 1;
			if(j >= N) j %= N;
			if(--temp[sushi[i - 1]] == 0) cnt--;
			if(temp[sushi[j]]++ == 0) {
				cnt++;
			}
			ans = Math.max(ans, cnt);
		}
		bw.write(ans + "");

		bw.flush();
		bw.close();
		br.close();
	}

}