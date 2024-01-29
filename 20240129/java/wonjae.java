import java.io.*;
import java.util.StringTokenizer;

public class B16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String s = br.readLine();

        int length = s.length();

        int[][] sum = new int[length+1][26];

        for(int i = 0; i < length; i++){
            char c = s.charAt(i);
            for(int j = 0; j < 26; j++){
                sum[i+1][j] = sum[i][j];
            }
            sum[i+1][c-'a']++;
        }

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());

        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken()) + 1;
            int cnt = 0;
            cnt = sum[r][a] - sum[l][a];
            bw.write(""+cnt+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
