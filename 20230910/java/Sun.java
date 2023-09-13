import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sun {
    static int x1, y1, x2, y2, answer, k, m1, m2;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());

        for (int i = 1; i < TC + 1; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            m1 = Math.abs(x1 - x2);
            m2 = Math.abs(y1 - y2);
            answer = Math.min(m1, m2) * 2;
            k = Math.max(m1, m2) - Math.min(m1, m2);
            if (k % 2 == 0) {
                answer += 2 * k;
            } else {
                answer += 2 * k - 1;
            }

            System.out.println("#" + i + " " + answer);
        }

    }

}
