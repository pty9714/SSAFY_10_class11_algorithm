import java.util.Arrays;
import java.util.Scanner;

public class B2212 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }

        Arrays.sort(s);

        int[] l = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            l[i] = s[i + 1] - s[i];
        }

        Arrays.sort(l);

        int sum = 0;
        for (int i = 0; i < n - k; i++) {
            sum += l[i];
        }

        System.out.println(sum);
    }
}
