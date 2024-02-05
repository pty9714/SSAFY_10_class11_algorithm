import java.io.*;
import java.util.StringTokenizer;

// 13340KB, 252ms
public class B1062 {
    public static boolean[] visited;
    public static int N, K, ans = 0;
    public static String[] strArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        strArr = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            strArr[i] = str.substring(4, str.length() - 4);
        }

        visited = new boolean[26];
        visited[0] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        dfs(0, 0);
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int alpha, int cnt) {
        if(cnt == K - 5) {
            int wordCnt = 0;
            for (int i = 0; i < N; i++) {
                boolean flag = true;
                for (int j = 0; j < strArr[i].length(); j++) {
                    if(!visited[strArr[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if(flag) wordCnt++;
            }
            ans = Math.max(ans, wordCnt);
            return;
        }
        for (int i = alpha; i < 26; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
