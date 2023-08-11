import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B1174 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String ans = "";
		// 줄어드는 수 특징
		// 1. 같은 수가 없음
		// 2. 항상 내림차순 정렬된 수
		// N번째로 작은 줄어드는 수 없는 것
		// - 줄어드는 수는 10개의 숫자로 서로 다른 숫자를 뽑는데 10개를 다 뽑는 조합 이후에도 cnt가 N에 도달하지 못할 경우
		int[] numbers = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		int[] p = new int[10];
		int cnt = 0;
		boolean flag = false;
		
		// 10개의 숫자 중 i개 뽑기
		for(int i = 0; i < 10; i++) {
			Arrays.fill(p, 0); // 0으로 초기화
			Arrays.fill(p, 9 - i, 10, 1); // 맨 뒤부터  i + 1개 1로 채우기
			do {
				cnt++;
				if(cnt == N) { // N 번째 작은 줄어드는 수
					flag = true;
					break;
				}
			} while(nextPermutation(p));
			if(flag) break;
		}
		
		// 결과 출력
		if(cnt != N) ans = "-1"; //  N번째로 작은 줄어드는 수가 없는 것
		else {
			for(int i = 0; i < 10; i++) {
				if(p[i] == 1) {
					ans += String.valueOf(numbers[i]);
				}
			}	
		}
		
		bw.write(ans);
		
		bw.close();
	}
	
	// NextPermutation 이용해 조합 구하기
	public static boolean nextPermutation(int arr[]) {
		int N = arr.length;
		
		// 1. 뒤에서부터 올라가다가 작아지는 지점(꼭대기) 구하기
		int i = N - 1;
		while(i > 0 && arr[i - 1] >= arr[i]) i--;
		if(i == 0) return false; //  다음 조합 없음 (다 1인 형태)
		
		// 2. 꼭대기 직전(i - 1) 위치의 수와 교환할 한 단계 큰 수(j) 뒤쪽부터 찾기
		int j = N - 1;
		while(arr[i - 1] >= arr[j]) j--;
		
		// 3. 꼭대기 직전(i - 1) 위치의 수와 2에서 찾은 수(j)를 교환
		swap(arr, i - 1, j);
		
		
		// 4. 꼭대기 자리부터 맨뒤까지의 수를 오름차순의 형태로 바꿈
		int K = N - 1;
		while(i < K) {
			swap(arr, i++, K--);
		}
		
		return true;
	}
	
	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}

// 11568KB	80ms
