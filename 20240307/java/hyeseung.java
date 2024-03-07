import java.io.*;
import java.util.StringTokenizer;

// 31828KB, 280ms
public class B2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] liquid = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = N-1;
        int liquidA = liquid[left];
        int liquidB = liquid[right];
        int sum = Math.abs(liquidA + liquidB);
        while(left < right) {
            int temp = liquid[left] + liquid[right];
            if(sum > Math.abs(temp)) {
                liquidA = liquid[left];
                liquidB = liquid[right];
                sum = Math.abs(temp);
            }
            if(temp > 0) {
                right--;
            }
            else {
                left++;
            }
        }
        bw.write(liquidA + " " + liquidB);
        bw.flush();
        bw.close();
        br.close();
    }
}
