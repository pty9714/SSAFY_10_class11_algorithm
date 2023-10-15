import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class keesung {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N];
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(br.readLine());
        }
        Stack<int[]> stack = new Stack<>();

        long result = 0;
        for (int i = 0; i < N; i++) {
            int[] building = {i, buildings[i]};
            if (stack.isEmpty()) {
                stack.push(building);
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek()[1] > building[1]) {
                        break;
                    }
                    if (stack.peek()[1] == building[1]) {
                        int[] pop = stack.pop();
                        result += i - pop[0] - 1;
                        break;

                    }
                    if (stack.peek()[1] < building[1]) {
                        int[] pop = stack.pop();
                        result += i - pop[0] - 1;
                    }

                }
                stack.push(building);
            }
        }
        for (int i = 0; i < stack.size(); i++) {
            result += N - stack.get(i)[0] - 1;
        }
        System.out.println(result);

    }
}