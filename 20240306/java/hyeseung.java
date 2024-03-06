import java.io.*;
import java.util.StringTokenizer;

// 	162728KB, 512ms
public class B20040 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        parent = new int[N];
        make(N);
        int M = Integer.parseInt(st.nextToken());
        int ans = 0;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(!union(A, B)) { // 사이클 생성 시 중단
                ans = i;
                break;
            }
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
    private static void make(int N) {
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }
    private static int find(int x) {
        if(x == parent[x]) {
            return x;
        }
        else {
            return parent[x] = find(parent[x]);
        }
    }
    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return false; // 사이클 생성시
        parent[x] = y;
        return true;
    }
}

/*
오랜만에 union-find 구현해서 find, union 함수 기억이 안났음
첨에 m개의 입력 다 받고 다시 m번 돌리니 1008ms가 나왔음
m개 입력 받으면서 체크로 바꾸니 512ms
 */