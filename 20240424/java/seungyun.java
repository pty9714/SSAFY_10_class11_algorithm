import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;

public class B3075 {

    static int n,p,q;
    static int[][] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            int[] meeting = new int[n];
            for(int i=0; i<n; i++){
                meeting[i] = Integer.parseInt(br.readLine());
            }

            dist = new int[p+1][p+1];

            for(int i=0; i<=p; i++){
                for(int j=0; j<=p; j++){
                    if(i==j){
                        dist[i][j] = 0;
                    } else{
                        dist[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            for(int i=0; i<p; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                dist[s][e] = d;
                dist[e][s] = d;
            }

            for(int k=1; k<=p; k++){
                // i j
                for(int i=1; i<=p; i++){
                    for(int j=1; j<=p; j++){
                        // k 거쳐서
                        if(dist[i][j] > dist[i][k] + dist[k][j]){
                            dist[i][j] = dist[i][k] + dist[k][j];
                            dist[j][i] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
            System.out.println();
            for(int i=1; i<=p; i++){
                for(int j=1; j<=p; j++){
                    System.out.print(dist[i][j]+" ");
                }
                System.out.println();
            }

        }

    }

}
