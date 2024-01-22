import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

// 65480KB, 352ms
public class B2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        long[] A = new long[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            A[i] = Long.parseLong(st.nextToken()) + A[i-1];
        }
        int m = Integer.parseInt(br.readLine());
        long[] B = new long[m+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            B[i] = Long.parseLong(st.nextToken()) + B[i-1];
        }

        long ans = 0;
        HashMap<Long, Long> subArr = new HashMap<>();
        // A로 이루어진 부배열 모두 구해서 같은 경우 개수 1 증가시킴
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                subArr.put(A[i]-A[j], subArr.getOrDefault(A[i]-A[j], 0L)+1);
            }
        }
        // B로 이루어진 부배열 모두 구한 후 T에서 뺀 값이 해시맵에 있다면 T가 되는 것이므로 정답 개수 1 증가시킴
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < i; j++) {
                ans += subArr.getOrDefault(T - (B[i]-B[j]), 0L);
            }
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
누적합
-> 부 배열은 연속적인 부분 배열이므로 누적합을 구해서 A의 부배열을 모두 구한 후 A와 합해서 T가 되는 B의 부배열을 구한다.
 */