import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2623 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Singer[] singers = new Singer[n+1];
        boolean[] visited = new boolean[n+1];
        for(int i = 0; i <= n; i++){
            singers[i] = new Singer(i);
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int curr = Integer.parseInt(st.nextToken());
            for(int j = 1; j < k; j++){
                int next = Integer.parseInt(st.nextToken());
                singers[next].prev_cnt++;
                singers[curr].next.add(next);
                curr = next;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            if(singers[i].prev_cnt == 0) {
                q.offer(i);
                visited[i] = true;
            }
        }

        int curr;
        while(!q.isEmpty()){
            curr = q.poll();
            if(singers[curr].prev_cnt == 0){
                sb.append(curr).append('\n');
                for(int next : singers[curr].next){
                    singers[next].prev_cnt--;
                    if(singers[next].prev_cnt == 0){
                        q.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }

        boolean answer = false;
        
        for(int i = 1; i <= n; i++){
            if (!visited[i]) {
                answer = true;
                break;
            }
        }
        
        if(answer) System.out.println(0);
        else System.out.println(sb.toString());

        br.close();
    }

    static class Singer{
        int num;
        int prev_cnt;
        ArrayList<Integer> next;

        Singer(int num){
            this.num = num;
            this.prev_cnt = 0;
            next = new ArrayList<>();
        }
    }
}
