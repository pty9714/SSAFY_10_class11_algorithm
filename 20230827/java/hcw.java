import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

	public static int[] house;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		house = new int[N];

		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(house); // 이분 탐색을 위한 정렬

		int lo = 1; // 최소 거리가 가질 수 있는 최솟값
		int hi = house[N - 1] - house[0] + 1; // 최소 거리가 가질 수 있는 최댓값

		while (lo < hi) { //Upperbound
			int mid = (hi + lo) / 2;

			if (canInstall(mid) < M) {
				hi = mid;
			} else {
				lo = mid + 1;
			}

		}
		
		System.out.println(lo - 1);
	}
	//distance에 대해 설치 가능한 공유기 개수를 찾는 메소드 
	public static int canInstall(int distance) {
		//첫 번째 집은 무조건 설치해야
		int count = 1;
		int lastLocate = house[0];

		for (int i = 1; i < house.length; i++) { //돌아야함 
			int locate = house[i];

			if (locate - lastLocate >= distance) {
				count++;
				lastLocate = locate;
			}
		}
		
		return count;
	}

}


27988KB	256ms
