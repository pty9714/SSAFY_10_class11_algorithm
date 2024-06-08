import java.io.*;
import java.util.StringTokenizer;

// 	12140KB, 84ms
public class B14888 {
    private static int N, min = (int) Math.pow(10, 9), max = (int) -Math.pow(10, 9);
    private static int[] numbers, op;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        op = new int[4];
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, numbers[0]);
        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int index, int sum) {
        if(index == N - 1) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(op[i] > 0) {
                op[i]--;
                int tempSum = sum;
                switch (i) {
                    case 0:
                        tempSum += numbers[index + 1];
                        break;
                    case 1:
                        tempSum -= numbers[index + 1];
                        break;
                    case 2:
                        tempSum *= numbers[index + 1];
                        break;
                    case 3:
                        tempSum /= numbers[index + 1];
                        break;
                }
                dfs(index + 1, tempSum);
                op[i]++;
            }
        }
    }
}
