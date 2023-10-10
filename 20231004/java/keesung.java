
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class Solution {

    public static int[] arr;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        arr = new int[500];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < 500; i++) {
            arr[i] = arr[i - 1] + i;
        }
        /*
         * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= T; test_case++) {
            // StringTokenizer st = new StringTokenizer(br.readLine());
            // int N = Integer.parseInt(st.nextToken());
            // int M = Integer.parseInt(st.nextToken());
            // String[] inputString = br.readLine().split(" ");
            // for (String s : inputString) {
            // System.out.println(s);
            // }
            // int N = Integer.parseInt(inputString[0]);
            // int M = Integer.parseInt(inputString[1]);
            int N = sc.nextInt();
            int M = sc.nextInt();
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[] { 0, N });
            boolean visited[] = new boolean[arr[499] + 1];
            visited[N] = true;
            while (!q.isEmpty()) {
                int[] tmp = q.poll();
                int cnt = tmp[0];
                int num = tmp[1];
                if (num == M) {
                    System.out.println("#" + test_case + " " + cnt);
                    break;
                }
                int[] visit = adjNodes(num);
                for (int i = 0; i < 6; i++) {
                    if (visit[i] == 0) {
                        break;
                    }
                    if (visited[visit[i]]) {
                        continue;
                    }
                    visited[visit[i]] = true;
                    q.offer(new int[] { cnt + 1, visit[i] });
                }
            }

        }
    }

    private static int[] adjNodes(int num) {
        int[] result = new int[6];
        int row = 0;
        for (int i = 0; i <= 500; i++) {
            if (num <= arr[i]) {
                row = i;
                break;
            }
        }

        if (row == 1) {
            return new int[] { 2, 3, 0, 0, 0, 0 };
        }

        result[0] = num + row;
        result[1] = num + row + 1;

        int nowMax = arr[row];
        int nowMin = arr[row - 1] + 1;
        int prevMin = arr[row - 2] + 1;
        int idx = 2;

        if (num - row >= prevMin) {
            result[idx++] = num - row;
        }
        if (num - row + 1 < nowMin) {
            result[idx++] = num - row + 1;
        }
        if (num - 1 >= nowMin) {
            result[idx++] = num - 1;
        }
        if (num + 1 <= nowMax) {
            result[idx++] = num + 1;
        }
        return result;

    }
}

// 110,012 kb
// 메모리
// 1,089 ms
// 실행시간

// 현재의 피라미드 row를 기준으로 가능한 인접 노드들을 탐색한다.