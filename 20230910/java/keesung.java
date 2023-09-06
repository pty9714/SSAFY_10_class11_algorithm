import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] dx = { -1, 0, 1, 0 }; // 세로 가로 세로 가로
        int[] dy = { 0, -1, 0, 1 };

        for (int test_case = 1; test_case <= T; test_case++) {
            HashSet<String> visited = new HashSet<String>();
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int distanceX = Math.abs(x1 - x2);
            int distanceY = Math.abs(y1 - y2);

            int small = Math.min(distanceX, distanceY);
            int cnt = small * 2;

            distanceX -= small;
            distanceY -= small;

            if (distanceX % 2 == 1) {
                cnt += distanceX * 2 - 1;
            } else {
                cnt += distanceX * 2;
            }

            if (distanceY % 2 == 1) {
                cnt += distanceY * 2 - 1;
            } else {
                cnt += distanceY * 2;
            }

            System.out.printf("#%d %d\n", test_case, cnt);

        }

    }
}