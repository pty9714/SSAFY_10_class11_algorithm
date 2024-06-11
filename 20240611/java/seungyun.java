import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] visited;
    static int last;
    static int max = 0;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i ++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        answer = new ArrayList<>();
        for(int i=1; i<=N; i++){
            visited[i] = true;
            last = i;
            dfs(i);
            visited[i] = false;
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(int i : answer){
            System.out.println(i);
        }
    }

    static void dfs(int idx){
        if(!visited[arr[idx]]){
            visited[arr[idx]] = true;
            dfs(arr[idx]);
            visited[arr[idx]] = false;
        }
        // 같으면 추가
        if(arr[idx] == last){
            answer.add(last);
        }
    }

}
