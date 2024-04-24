import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class B3075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int[][] table = new int[p+1][p+1];
            for(int i = 0; i <= p; i++){
                for(int j = 0; j <= p; j++){
                    if(i==j) table[i][j] = 0;
                    else table[i][j] = Integer.MAX_VALUE;
                }
            }

            int[] visitor = new int[n];
            for(int i = 0; i < n; i++){
                visitor[i] = Integer.parseInt(br.readLine());
            }
            for(int k  = 0; k < q; k++){
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                if(table[i][j] > d){
                    table[i][j] = table[j][i] = d;
                }
            }

            for(int k = 1; k <= p; k++){
                for(int i = 1; i <= p; i++){
                    for(int j = 1; j <= p; j++){
                        if(table[i][k] == Integer.MAX_VALUE || table[k][j] == Integer.MAX_VALUE) continue;
                        if(table[i][j] > table[i][k] + table[k][j]) {
                            table[i][j] = table[j][i] = table[i][k] + table[k][j];
                        }
                    }
                }
            }

            int meeting = -1;
            double min = Double.MAX_VALUE;

label:      for(int i = 1; i <= p; i++){
                double sum = 0;
                for(int v : visitor){
                    if(table[v][i] == Integer.MAX_VALUE) continue label;
                    sum += Math.pow(table[v][i],2);
                }
                if(sum < min) {
                    meeting = i;
                    min = sum;
                }
            }
            BigDecimal bd = new BigDecimal(min);

            sb.append(meeting).append(' ').append(bd).append('\n');
        }
        System.out.print(sb);
    }
}
