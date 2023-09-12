import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class B2667 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] temp = in.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = temp[j] - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int[] dirX = { 0, 1, 0, -1 };
        int[] dirY = { 1, 0, -1, 0 };
        int danji = 1;
        ArrayList<Integer> l = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    danji++;
                    int cnt = 0;
                    q.add(new int[] { i, j });

                    while (!q.isEmpty()) {
                        int[] x = q.poll();
                        if (map[x[0]][x[1]] != 1)
                            continue;
                        cnt++;
                        map[x[0]][x[1]] = danji;

                        for (int k = 0; k < 4; k++) {
                            int ni = x[0] + dirX[k];
                            int nj = x[1] + dirY[k];
                            if (ni < 0 || ni >= N || nj < 0 || nj >= N || map[ni][nj] != 1)
                                continue;
                            q.add(new int[] { ni, nj });
                        }
                    }
                    l.add(cnt);
                }
            }
        }

        System.out.println(l.size());
        Collections.sort(l);
        for (int c : l) {
            System.out.println(c);
        }

    }

}

//14252 kb	140 ms
