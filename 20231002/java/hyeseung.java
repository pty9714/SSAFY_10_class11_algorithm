import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 169064KB, 232ms
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int size = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int A[] = new int[M], sumA[] = new int[20000001];
		int B[] = new int[N], sumB[] = new int[20000001];
		int ans = 0;

		for (int i = 0; i < M; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(br.readLine());
		}

		cntCase(A, sumA);
		cntCase(B, sumB);

		for (int i = 0; i <= size; i++) {
			ans += (sumA[i] * sumB[size - i]);
		}

		bw.write(ans + "");

		bw.flush();
		bw.close();
		br.close();
	}

	public static void cntCase(int pizza[], int sumPizza[]) {
		int length = pizza.length;
		int sum = 0;
		for (int i = 0; i < length; i++) {
			sum = 0;
			for (int j = 0; j < length; j++) {
				sum += pizza[(i + j) % length];
				sumPizza[sum]++;
			}
		}
		sumPizza[0] = 1;
		sumPizza[sum] = 1;
	}
}