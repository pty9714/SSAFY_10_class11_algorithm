import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] diff = new int[n-1];

        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            diff[i-1] = arr[i] - arr[i-1];
        }

        Arrays.sort(diff);

        int sum = 0;

        for(int i = 0; i < n-k; i++){
            sum+=diff[i];
        }

        System.out.println(sum);
    }
}
