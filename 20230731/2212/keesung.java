import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class keesung {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] sensors = new int[n];
        int[] distances = new int[n-1];
        String[] tmp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            sensors[i] = Integer.parseInt(tmp[i]);
//            System.out.print(distances[i-1]+ " ");
        }
        Arrays.sort(sensors);
        for (int j = 0; j < n-1; j ++) {
            distances[j] = sensors[j+1] - sensors[j];
        }

//        System.out.println("");
        Arrays.sort(distances);
        int sum = 0;
        for (int i = 0; i < n-k; i++) {
            sum += distances[i];
        }
        System.out.println(sum);
    }
}
