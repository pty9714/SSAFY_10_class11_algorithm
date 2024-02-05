import java.io.*;
import java.util.StringTokenizer;

// 12132KB, 252ms
public class B1790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long sumDigit = 0, curDigit = 10, digit = 1, ans = -1;
        for (long i = 1; i <= N; i++) {
            if(curDigit == i) {
                digit++;
                curDigit *= 10;
            }
            sumDigit += digit;
            if(sumDigit >= k) {
                ans = i;
                break;
            }
        }
        if(ans != -1) {
            String temp = String.valueOf(ans);
            ans = Long.parseLong(String.valueOf(temp.charAt((int)(temp.length() - sumDigit + k - 1))));
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
