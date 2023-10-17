
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> ledders = new HashMap<>();
        HashMap<Integer, Integer> snakes = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ledders.put(a, b);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            snakes.put(a, b);
        }

        PriorityQueue<Cube> cubes = new PriorityQueue<>();

        boolean[] visited = new boolean[150];
        visited[1] = true;
        cubes.offer(new Cube(1, 0));
        while (!cubes.isEmpty()) {
            Cube cube = cubes.poll();
            if (cube.position >= 100) {
                System.out.println(cube.cnt);
                break;
            }
            for (int i = 1; i <= 6; i++) {
                int newPosition = cube.position + i;
                if (ledders.containsKey(newPosition)) {
                    newPosition = ledders.get(newPosition);
                } else if (snakes.containsKey(newPosition)) {
                    newPosition = snakes.get(newPosition);
                }
                if (visited[newPosition]) {
                    continue;
                }
                cubes.offer(new Cube(newPosition, cube.cnt + 1));
                visited[newPosition] = true;
            }
        }
    }

    public static class Cube implements Comparable<Cube> {
        int position;
        int cnt;

        public Cube(int position, int cnt) {
            this.position = position;
            this.cnt = cnt;
        }

        public int compareTo(Cube o) {
            if (this.cnt == o.cnt) {
                return o.position - this.position;
            }
            return this.cnt - o.cnt;
        }

    }

}

// 11808kb, 84ms
// PriorityQueue, bfs