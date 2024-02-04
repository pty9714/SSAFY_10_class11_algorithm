import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon16139 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int q = Integer.parseInt(br.readLine());

        int[][] sum = new int[s.length()+1][26];
        int[] temp = new int[26];
        for(int i=1; i<=s.length(); i++) {
            temp[s.charAt(i-1) - 97]++;
            sum[i] = Arrays.copyOf(temp,26);
        }


        for(int i=0; i<q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 97;
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

           bw.append(sum[end+1][a] - sum[start][a] + "\n");

        }

        bw.close();
        br.close();

    }

}
