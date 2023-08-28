import java.io.*;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            int answer;
            if (V == 1) {
                answer = (int) (Math.log(N) / Math.log(2));
                if (N == 1) {
                    answer = 0;
                }
            } else {
                answer = (int) (Math.log(V) / Math.log(2));
                int count = 0;
                while (V > 3) { // 루트 기준 왼쪽 서브트리인지 오른쪽 서브트리인지 판단
                    V /= 2;
                }
                if (V == 2) { // 왼쪽에서 올라왔다
                    if (N >= 3) {
                        answer++;
                        answer += (int) (Math.log(N / 3) / Math.log(2));
                    }
                } else { // 오른쪽에서 올라왔다
                    answer += (int) (Math.log(N) / Math.log(2));
                }
            }
            bw.write("#" + test_case + " " + answer + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

// 66,368 kb
// 267 ms
