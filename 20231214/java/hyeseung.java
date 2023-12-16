import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

// 25488KB, 240ms
public class B1644 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		boolean primeCheck[] = new boolean[N + 1];
        ArrayList<Integer> prime = new ArrayList<>();

        // 소수가 아니면 true로
        primeCheck[0] = primeCheck[1] = true;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            for (int j = i + i; j <= N; j += i){
                primeCheck[j] = true;
            }
        }
        for (int i = 0; i <= N; i++){
            if(!primeCheck[i]) prime.add(i); // 소수 배열 만들기
        }

        int sum = 0, left = 0;
        
        for (int right = 0; right < prime.size(); right++) {
			sum += prime.get(right);
			if(sum == N) ans++;
			while(sum >= N) {
				sum -= prime.get(left++);
				if(sum == N) ans++;
			}
		}
	
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
/*
 에라토스테네스의 체 O(N^1/2)
 임의의 수 n까지의 소수를 구하고자 할 때 2부터 제곱근까지 돌며 모든 배수들을 소수에서 제외시키는 방식
 -> 미리 소수 구해서 투포인터로 해결함
 */