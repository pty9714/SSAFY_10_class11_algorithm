import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663 {
    static int[] rows = new int[15];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        simulate(0, N);
        System.out.println(answer);
    }

    private static void simulate(int idx, int size) {
        if (idx == size) {
            answer++;
            return;
        }

        for (int i = 0; i < size; i++) {
            rows[idx] = i;
            if (isAvailable(idx)) {
                simulate(idx + 1, size);
            }

        }
    }

    private static boolean isAvailable(int idx) {
        for (int i = 0; i < idx; i++) {
            if (Math.abs(rows[idx] - rows[i]) == Math.abs(idx - i) || rows[idx] == rows[i]) {
                return false;
            }
        }
        return true;
    }
}

---
// Java: 14556 KB |	5428 ms
// C++: 2020 KB | 5116 ms
// Python: 시간초과...
