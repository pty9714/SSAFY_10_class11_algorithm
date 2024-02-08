import java.io.*;
import java.util.StringTokenizer;

// 87532KB, 260ms
public class B22251 {
    public static int N, K, P, X;
    public static boolean[][] number = {{true, true, true, true, true, true, false}, // 0
                                        {false, true, true, false, false, false, false}, // 1
                                        {true, true, false, true, true, false, true}, // 2
                                        {true, true, true, true, false, false, true}, // 3
                                        {false, true, true, false, false, true, true}, // 4
                                        {true, false, true, true, false, true, true}, // 5
                                        {true, false, true, true, true, true, true}, // 6
                                        {true, true, true, false, false, false, false}, // 7
                                        {true, true, true, true, true, true, true}, // 8
                                        {true, true, true, true, false, true, true}}; // 9
    public static long ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            if(i != X && canChange(i)) ans++;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean canChange(int changeNumber) {
        int[] tempX = toArr(X);
        int[] tempChange = toArr(changeNumber);
        int changeCnt = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 7; j++) {
                if(number[tempX[i]][j] != number[tempChange[i]][j]) {
                    changeCnt++;
                    if(changeCnt > P) return false;
                }
            }
        }
        return true;
    }

    public static int[] toArr(int number) {
        int[] arr = new int[K];
        for (int i = K - 1; i >= 0; i--) {
            arr[i] = number % 10;
            number /= 10;
        }
        return arr;
    }
}
/*
완전탐색
-> 0~9까지 배열로 만들기
X에서 어떤 N 이내의 숫자로 바꿀 수 있는 경우 경우의 수 증가
단, 바꿀 때 각 숫자의 전환되는 개수가 P개 이하여야 함
 */