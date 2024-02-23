import java.io.*;
import java.util.StringTokenizer;

// 69792KB, 608ms
public class B21318 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] piano = new int[N];
        int[] mistake = new int[N];
        piano[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            piano[i] = Integer.parseInt(st.nextToken());
            mistake[i] = mistake[i-1];
            if(piano[i-1] > piano[i]) {
                mistake[i]++;
            }
        }   
        int Q = Integer.parseInt(br.readLine());
        int[][] questions = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            questions[i][0] = Integer.parseInt(st.nextToken());
            questions[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int[] question : questions) {
            int mistakeCnt = mistake[question[1]-1] - mistake[question[0]-1];
            bw.write(mistakeCnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
