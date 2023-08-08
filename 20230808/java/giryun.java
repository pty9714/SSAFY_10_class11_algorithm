import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] B = new int[w];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = w - 1;
        int maxleft = B[left], maxright = B[right];
        int ans = 0;
        
        while (left < right) {
            maxleft = Math.max(maxleft, B[left]);
            maxright = Math.max(maxright, B[right]);
            
            if (maxleft <= maxright) {
                ans += maxleft - B[left];
                left++;
            } else {
                ans += maxright - B[right];
                right--;
            }
        }

        bw.write(ans + "");
		bw.close();
    }
}
