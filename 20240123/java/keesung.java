package stock.chart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new int[2001]);
        }
        Ball[] balls = new Ball[N];
        for (int i = 0; i < N; i++) {
            Ball ball = new Ball(br.readLine());
            balls[i] = ball;
            int[] arr = map.get(ball.color);
            for (int j = ball.size; j <= 2000; j++) {
                arr[j] += ball.size;
            }
        }

        for (Ball ball : balls) {
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                if (i != ball.color) {
                    int[] arr = map.get(i);
                    sum += arr[ball.size];
                }
            }
            System.out.println(sum);
        }
        ;

    }

    public static class Ball {

        int color;
        int size;

        public Ball(String text) {
            StringTokenizer st = new StringTokenizer(text);
            this.color = Integer.parseInt(st.nextToken());
            this.size = Integer.parseInt(st.nextToken());
        }

    }

}

// 메모리 초과