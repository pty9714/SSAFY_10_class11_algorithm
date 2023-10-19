import java.util.*;
import java.io.*;

public class Main {
    
    static int cnt;
    static int[] arr;
    static boolean[] visited, done;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            done = new boolean[n+1];
            cnt = 0;
            
            st = new StringTokenizer(br.readLine());
            
            for(int i = 1; i <= n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            for(int i = 1; i <= n; i++){
                if(!done[i]){
                    dfs(i);
                }
            }
            bw.write((n-cnt) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void dfs(int n){
        if (visited[n]) {
            done[n] = true;
            cnt++;
        }
        else {
            visited[n] = true;
        }
        if (!done[arr[n]]) {
            dfs(arr[n]);
        }
        visited[n] = false;
        done[n] = true;
    }
}
//303868	1068
