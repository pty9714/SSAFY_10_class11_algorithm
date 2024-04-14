import java.io.*;
import java.util.*;

public class B2224 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        boolean[][] propositions = new boolean[52][52];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String P = st.nextToken();
            st.nextToken();
            String Q = st.nextToken();
            int p = P.charAt(0) <= 'Z' ? P.charAt(0) - 'A' : P.charAt(0) - 'a' + 26;
            int q = Q.charAt(0) <= 'Z' ? Q.charAt(0) - 'A' : Q.charAt(0) - 'a' + 26;
            if(p == q || propositions[p][q]) continue;
            cnt++;
            propositions[p][q] = true;
        }
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 52; j++) {
                for (int k = 0; k < 52; k++) {
                    if(j != k && propositions[j][i] && propositions[i][k] && !propositions[j][k]) {
                        cnt++;
                        propositions[j][k] = true;
                    }
                }
            }
        }
        bw.write(cnt + "\n");
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 52; j++) {
                if(propositions[i][j]) {
                    char P = i < 26 ? (char) (i + 'A') : (char) (i - 26 + 'a');
                    char Q = j < 26 ? (char) (j + 'A') : (char) (j - 26 + 'a');
                    bw.write(P + " => " + Q + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}