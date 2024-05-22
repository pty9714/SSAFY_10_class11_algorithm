import java.util.*;
import java.io.*;

public class B1446 {
    static class spot{
        int start;
        int distance ;
        spot(int start, int distance){
            this.start = start;
            this.distance = distance;
        }
    }
    static ArrayList<spot>[] path;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        //고속도로 도착지점
        int L = Integer.parseInt(st.nextToken());
        //고속도로 
        int start_visited[] = new int[L+1];

        for(int i=0;i<=L;i++){
            start_visited[i] = i; //해당 지점 도달 최악시간
        }
        path = new ArrayList[L + 1]; 
        for(int i=0;i<=L;i++){
            path[i] = new ArrayList<>();
        }
        

        for(int i=0;i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if(end<=L && (end-start)>distance) {
                path[end].add(new spot(start,distance));
            }

        }

        //dp
        for(int i=1;i<=L;i++){
            start_visited[i] =  start_visited[i-1]+1; //지름길로 가지 않았을때
            if(path[i].size()>0){
                for(spot s: path[i]){
                    start_visited[i] = Math.min(start_visited[i],start_visited[s.start]+s.distance); // 지름길로 갔을때 비교
                }
            }
        }
        System.out.print(start_visited[L]);
        
    }
};
