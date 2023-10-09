
import java.io.*;
import java.util.*;

class Solution {

    public static int M;
    public static int result = -1;

    // public static HashSet<Integer> hashSet = new HashSet<>();
    public static HashSet[] hashSets = new HashSet[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        M = 1;
        while (Math.pow(10, M) <= N) {
            M++;
        }

        if (M == 1 || (M == 2 && N % 10 == 0)) {
            System.out.println(-1);
            return;
        }

        hashSets[0] = new HashSet();
        hashSets[1] = new HashSet();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, N });
        hashSets[0].add(N);
        // hashSet.add(N);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            // System.out.println(cur[0] + " " + cur[1]);
            if (((K - cur[0]) % 2 == 0)) {
                result = Math.max(result, cur[1]);
                if (cur[0] == K) {
                    continue;
                }
            }
            for (int i = 0; i < M; i++) {
                for (int j = i + 1; j < M; j++) {
                    int newNum = swap(cur[1], i, j);
                    if (newNum == -1) {
                        continue;
                    }
                    HashSet tmp = hashSets[(cur[0] + 1) % 2];
                    if (tmp.contains(newNum)) {
                        continue;
                    }
                    tmp.add(newNum);
                    q.offer(new int[] { cur[0] + 1, newNum });
                }
            }
        }
        System.out.println(result);
    }

    private static int swap(int N, int i, int j) {
        int newNum = 0;
        int[] arr = new int[M];
        for (int k = M - 1; k >= 0; k--) {
            arr[k] = N % 10;
            N /= 10;
        }
        if (arr[j] == 0 && i == 0) {
            return -1;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        for (int k = 0; k < arr.length; k++) {
            newNum += arr[k] * Math.pow(10, arr.length - k - 1);
        }
        return newNum;

    }

}

// 메모리 13120 시간 112
// 예외 케이스 체크 필요
// 방문 처리 나눠서 하기, 홀수일 때 짝수일 때
// 최대 방문 - index가 짝수일 경우 같은 숫자만 계속 바꾸면 도달할 수 있으므로 그 상황에서 바로 업데이트 해줌