import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int l, r;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            l = 0; r = n-1;
            while (l < r) {
                if(l == i) l++;
                if(r == i) r--;
                if(l >= r) break;
                if(num[i] == num[l] + num[r]) {
                    cnt++;
                    break;
                }
                else if(num[i] < num[l] + num[r]) r--;
                else if(num[i] > num[l] + num[r]) l++;
            }
        }
        System.out.println(cnt);
    }
}
/*
  12836KB	148ms
*/
