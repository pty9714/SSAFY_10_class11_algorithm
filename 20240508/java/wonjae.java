import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, d, k, c;
	static int[] sushi, sushiList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushiList = new int[n + k];
		sushi = new int[d + 1];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			sushiList[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < k;i++) {
			sushiList[n+i] = sushiList[i];
		}
		
		sushi[c]++;
		int cnt = 1, maxN = 1;
		for(int i = 0; i < k; i++) {
			if(sushi[sushiList[i]] == 0) cnt++;
			sushi[sushiList[i]]++;
		}
		
		for(int i = 0, j = k; i < n; i++, j++) {
			sushi[sushiList[i]]--;
			if(sushi[sushiList[i]] == 0) cnt--;
			if(sushi[sushiList[j]] == 0) cnt++;
			sushi[sushiList[j]]++;
			maxN = getMax(cnt, maxN);
		}
		
		System.out.println(maxN);
	}
	
	static int getMax(int a, int b) {
		if(a < b) return b;
		else return a;
	}
}
