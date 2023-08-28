import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S15231_바이너리트리_신혜승 {

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    
    int T = Integer.parseInt(br.readLine());
    
    for (int test_case = 1; test_case <= T; test_case++) {
        int ans = 0;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        while(V > 1) {
            ans++;
            V /= 2;
        }
        ans += (Math.log(N) / Math.log(2));
        bw.write("#" + test_case + " " + ans + "\n");
    }
    
    bw.flush();
    bw.close();
    br.close();
}
}