import java.io.*;
import java.util.*;

public class n01208 {

	static int N, S;
	static long[] arr;
	static List<Long> left = new ArrayList<>();
	static List<Long> right = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");

		N = Integer.parseInt(sarr[0]);
		S = Integer.parseInt(sarr[1]);

		arr = new long[N];

		sarr = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(sarr[i]);
		}

		getSubsequence(0, N / 2, 0, left);
		getSubsequence(N / 2, N, 0, right);

		Collections.sort(left);
		Collections.sort(right);

		long cnt = getCnt();

		if (S == 0)
			cnt--;

		bw.write(cnt + "\n");
		bw.flush();

	}

	public static void getSubsequence(int idx, int end, long sum, List<Long> list) {

		if (idx == end) {
			list.add(sum);
			return;
		}

		getSubsequence(idx + 1, end, sum + arr[idx], list);
		getSubsequence(idx + 1, end, sum, list);
	}

	public static long getCnt() {

		int pl = 0;
		int pr = right.size() - 1;
		long cnt = 0;

		while (pl < left.size() && pr >= 0) {

			long sum = left.get(pl) + right.get(pr);

			if (sum == S) {
				long a = left.get(pl);
				long cnt1 = 0;
				while (pl < left.size() && left.get(pl) == a) {
					pl++;
					cnt1++;
				}

				long b = right.get(pr);
				long cnt2 = 0;
				while (pr >= 0 && right.get(pr) == b) {
					pr--;
					cnt2++;
				}

				cnt += cnt1 * cnt2;
			}

			else if (sum < S)
				pl++;
			else
				pr--;
		}

		return cnt;
	}
}

// 부분수열을 나눠서 재귀적으로 푸는 방법,
// 2개의 부분수열로 나누고 나뉜 수열을 다시 분할하여 0개까지 가서 올라온다.
// 이때 0개일 경우만 주의하면 된다.
// merge sort 개념을 도입한 것.