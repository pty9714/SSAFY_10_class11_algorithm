import java.io.*;
import java.util.StringTokenizer;

// 131160KB, 748ms
public class B16139 {
    static class Question {
        char a;
        int l;
        int r;
        Question(char a, int l, int r) {
            this.a = a;
            this.l = l;
            this.r = r;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String str = br.readLine();
        int[][] sum = new int[str.length()][26];
        sum[0][str.charAt(0) - 'a'] = 1;
        for (int i = 1; i < str.length(); i++) {
            for (int j = 0; j < 26; j++) {
                sum[i][j] = sum[i-1][j];
                if(j == str.charAt(i) - 'a') {
                    sum[i][j]++;
                }
            }
        }
        int qCnt = Integer.parseInt(br.readLine());
        Question[] questions = new Question[qCnt];
        for (int i = 0; i < qCnt; i++) {
            st = new StringTokenizer(br.readLine());
            questions[i] = new Question(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < qCnt; i++) {
            if(questions[i].l == 0) {
                bw.write(sum[questions[i].r][questions[i].a - 'a'] + "\n");
            }
            else {
                bw.write((sum[questions[i].r][questions[i].a - 'a'] - sum[questions[i].l-1][questions[i].a - 'a']) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
/*
누적합
-> 2차원 배열 생성한 후 알파벳 26개 모두 누적합으로 체크
 */