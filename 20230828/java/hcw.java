import java.awt.Point;
import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());

			int count = 0;
			int current = V;
			
			boolean middle_right = false;
			int temp = N;
			// 차수 계산
			while (temp > 1) {
				if (temp == 3) {// 오른쪽 가지가 있다
					middle_right = true; 
					break;
				}
				temp /= 2;
			}

			boolean start_right = false;
			while (current > 1) { // 트리에서 올라옴
				if (current == 3) start_right = true;  // 오른쪽에서 출발했다
				current /= 2;
				if (current >= 1) count++;
			}

			while (current < N) { // 트리에서 다시 내려감
				current *= 2;
				if (current <= N) count++;
			}
			
			if (!start_right && !middle_right && V != 1) { // 왼쪽 출발에 오른쪽 잘려있다면
				count--;
			}

			if (N == 1) {
				sb.append("#" + test + " " + 0 + "\n");
			} else if (N == 2) {
				sb.append("#" + test + " " + 1 + "\n");
			} else {
				sb.append("#" + test + " " + count + "\n");
			}
		}

		System.out.println(sb);

	}
}


75,264 kb
329 ms
