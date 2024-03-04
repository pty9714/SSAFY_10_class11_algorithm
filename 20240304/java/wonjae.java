import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[3];
        for(int i = 0; i < n; i++){
            int w = Integer.parseInt(br.readLine());
            int temp = Math.max(Math.max(wines[2], wines[1]), wines[0]);
            wines[2] = wines[1] + w;
            wines[1] = wines[0] + w;
            wines[0] = temp;
        }
        System.out.println(Math.max(Math.max(wines[0], wines[1]), wines[2]));
    }
}
