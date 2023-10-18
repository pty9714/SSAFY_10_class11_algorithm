
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {



    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] downs = new int[H];
        int[] ups = new int[H];
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                downs[height - 1] += 1;
            } else {
                ups[H - height] += 1;
            }
        }

        for (int i = 0; i < H-1; i++) {
            downs[H - 2 - i] = downs[H - 2 - i] + downs[H - 1 - i];
            ups[i+1] = ups[i] + ups[i+1];
        }

        int[] sum = new int[H];
        int minVal = N+1;
        for (int i = 0; i < H; i++) {
            sum[i] = downs[i] + ups[i];
            minVal = Math.min(sum[i], minVal);
        }
        int answer = 0;
        for (int i = 0; i < H; i++) {
            if (sum[i] == minVal) {
                answer += 1;
            }
        }
        System.out.print(minVal + " ");
        System.out.println(answer);


    }


}

// 메모리 31824, 시간 272
// 누적합