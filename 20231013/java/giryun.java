import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class giryun {
    static int res, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] down = new int[N/2];
        int[] up = new int[N/2];
        for (int i = 0; i < N; i++) {
            //홀수-석순
            if (i % 2 != 0) {
                down[i/2] = Integer.parseInt(br.readLine());
            }
            //짝수-종유석
            else {
                up[i/2] = Integer.parseInt(br.readLine());
            }
        }
        Arrays.sort(up);
        Arrays.sort(down);

        res = N;
        cnt = 0;
        for (int h = 1; h <= H; h++) {
            int min = binarySearch(0, N/2, h, down) + binarySearch(0, N/2, H-h+1, up);
            if (min == res) {
                cnt++;
            }
            else if (min < res) {
                res = min;
                cnt = 1;
            }
        }
        bw.write(res + " " + cnt);
        bw.flush();
        bw.close();
        br.close();
    }
    public static int binarySearch(int l, int r, int h, int[] arr) {
        int mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (arr[mid] >= h) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return arr.length - r;
    }
}
//	28448KB,	412ms
