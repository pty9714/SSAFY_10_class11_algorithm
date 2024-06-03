import java.io.*;
import java.util.*;

// 11572KB, 84ms
public class B1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] alphabets = new int[26];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            int digit = 1;
            for (int j = temp.length() - 1; j >= 0; j--) {
                 alphabets[temp.charAt(j) - 'A'] += digit;
                digit *= 10;
            }
        }

        Arrays.sort(alphabets);

        int ans = 0;
        int score = 9;
        for (int i = 25; i >= 0; i--) {
            ans += alphabets[i] * score--;
        }

        bw.write(ans + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
