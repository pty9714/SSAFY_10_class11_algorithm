import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class B1644 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		boolean check[] = new boolean[N+1];
        ArrayList<Integer> primes = new ArrayList<>();

        // 소수가 아니면 true로
        check[0] = check[1] = true;

        for (int i = 2; i <= Math.sqrt(check.length); i++) {
            for (int j = i*i; j <= N; j += i){
                if(!check[j]) check[j] = true;
            }
        }
        for (int i = 0; i <= N; i++){
            if(!check[i]) primes.add(i); // 소수 넣기
        }

        int sum = 0, left = 0;

        for (int right = 0; right < N; right++){
            if(right >= primes.size()) continue;

            sum += primes.get(right);

            if(sum == N) ans++;

            while(sum >= N && left >= 0){ // sum 보다 같거나 작으면 left 증가해 해당 값 빼줌
                sum -= primes.get(left++);
                if(sum == N) ans++;
            }
        }		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
