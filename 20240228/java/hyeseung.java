import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class City {
        int cityNumber;
        int planIndex;
        City(int cityNumber, int planIndex) {
            this.cityNumber = cityNumber;
            this.planIndex = planIndex;
        }
    }
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] cities = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cities[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] plans = new int[M];
        for (int i = 0; i < M; i++) {
            plans[i] = Integer.parseInt(st.nextToken());
        }

        String ans = bfs(plans, cities);
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }
    private static String bfs(int[] plans, int[][] cities) {
        int maxIndex = cities.length;
        Queue<City> q = new LinkedList<>();
        q.offer(new City(plans[0], 1));
        while(!q.isEmpty()) {
            City cur = q.poll();
            if(cur.planIndex >= maxIndex) return "NO";
            for (int i = 0; i < N; i++) {
                if(cities[cur.cityNumber-1][i] == 1) {
                    if(cur.planIndex == maxIndex - 1 && plans[cur.planIndex] == i + 1) return "YES";
                    if(plans[cur.planIndex] == i + 1) {
                        q.offer(new City(i + 1, cur.planIndex + 1));
                    }
                    else {
                        q.offer(new City(i + 1, cur.planIndex));
                    }
                }
            }
        }
        return "NO";
    }
}