import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int order = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Hashtable<Integer, valueStore> tableA = new Hashtable<>();
        Hashtable<Integer, valueStore> tableB = new Hashtable<>();

        int numA = Integer.parseInt(st.nextToken());
        int numB = Integer.parseInt(st.nextToken());
        int[] pizzaA = new int[numA];
        int[] pizzaB = new int[numB];
        for (int i = 0; i < numA; i++) {
            pizzaA[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < numB; i++) {
            pizzaB[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (true) {
            sum += pizzaA[end % numA];
            if (sum == order) {
                result++;
                start++;
                sum -= pizzaA[start];
                end++;
            } else if (sum > order) {
                start++;
                sum -= pizzaA[start];

            } else {
                end++;
            }

            if (start == numA) {
                break;
            }
            if (end % numA == start) {
                break;
            }
        }

    }

    static class valueStore {
        int value = 1;
    }
}
