import java.util.*;
import java.io.*;

public class Main {
	static class Channel {
		int count;
		int num;

		public Channel(int count, int num) {
			this.count = count;
			this.num = num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int broken = Integer.parseInt(br.readLine());
		ArrayList<Integer> brokenArr = new ArrayList<>();
		int answerNum = Integer.MAX_VALUE;
		int answerCount = 0;
		int answerNum1 = Integer.MAX_VALUE;
		int answerCount1 = 0;
		int answerNum2 = Integer.MAX_VALUE;
		int answerCount2 = 0;
		int current = 100;
		StringTokenizer st = null;
		if (broken > 0) {
			st = new StringTokenizer(br.readLine());
		}
		for (int i = 0; i < broken; i++) {
			brokenArr.add(Integer.parseInt(st.nextToken()));
		}

		int temp = N;
		int count = 0;
		if (temp == 0) {
			count = 1;
		} else {
			while (temp != 0) {
				temp /= 10;
				count++;
			}
		}
		PriorityQueue<Channel> pq = new PriorityQueue<>((el1, el2) -> {
			if (el1.count == el2.count) {
				return Math.abs(el1.num - N) - Math.abs(el2.num - N);
			}
			return el1.count - el2.count;
		});
		for (int i = 0; i < 10; i++) {
			if (!brokenArr.contains(i)) {
				pq.add(new Channel(1, i));
			}
		}
		while (!pq.isEmpty()) {
			Channel tmp = pq.poll();
			if (count == tmp.count) { // 자리수가 같다면
				answerCount = tmp.count;
				if (Math.abs(N - tmp.num) < Math.abs(N - answerNum)) { // 차이가 적으면
					answerNum = tmp.num;
				}
			} else if (count - 1 == tmp.count) { // 하나 작다면
				answerCount1 = tmp.count;
				if (Math.abs(N - tmp.num) < Math.abs(N - answerNum1)) { // 차이가 적으면
					answerNum1 = tmp.num;
				}
			} else if (count + 1 == tmp.count) { // 하나 크다면
				answerCount2 = tmp.count;
				answerNum2 = tmp.num;
				break;
			}

			for (int i = 0; i < 10; i++) {
				if (!brokenArr.contains(i) && Math.pow(10, count+1) > tmp.num * 10 + i) {
					pq.add(new Channel(tmp.count + 1, tmp.num * 10 + i));
				}
			}
		}

		int a = Math.abs(N - current);
		int b = Math.abs(N - answerNum) + answerCount;
		int c = Math.abs(N - answerNum1) + answerCount1;
		int d = Math.abs(N - answerNum2) + answerCount2;

		System.out.println(Math.min(d, Math.min(Math.min(a, b), c)));

	}
}


486896	1880
