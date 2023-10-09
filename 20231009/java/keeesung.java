
import java.io.*;
import java.util.*;

class Solution {

    public static int[] arr;
    public static int K;
    public static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int M = 1;
        while (Math.pow(10, M) < N) {
            M++;
        }
        arr = new int[M];
        for (int i = M - 1; i >= 0; i--) {
            arr[i] = N % 10;
            N /= 10;
        }
        dfs(0);

        System.out.println(result);
    }

    public static void dfs(int index) {
        if (index == K) {
            int num = 0;
            for (int i = 0; i < arr.length; i++) {
                num += arr[i] * Math.pow(10, arr.length - i - 1);
            }
            result = Math.max(result, num);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == 0 && i == 0) {
                    continue;
                }
                swap(i, j);
                dfs(index + 1);
                swap(i, j);
            }
        }
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}