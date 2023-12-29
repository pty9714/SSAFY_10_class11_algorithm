import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static int[][] map;
    public static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        Road start = new Road(0, 0, 0, false);
        PriorityQueue<Road> queue = new PriorityQueue<>(Comparator.comparingInt(Road::getCost));
        queue.add(start);
        while (!queue.isEmpty()) {
            Road road = queue.poll();
            if (road.x == N - 1 && road.y == M - 1) {
                System.out.println(road.getCost() + 1);
                return;
            }
            List<Road> newRoads = road.go();
            for (Road newRoad : newRoads) {
                visited[newRoad.x][newRoad.y][newRoad.isBroken ? 1 : 0] = newRoad.getCost();
                queue.add(newRoad);
            }
        }

        System.out.println(-1);
    }

    public static class Road {
        private int x;
        private int y;
        private int cost;
        private boolean isBroken;

        public Road(int x, int y, int cost, boolean isBroken) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.isBroken = isBroken;
        }

        public List<Road> go() {
            List<Road> roads = new ArrayList<>();
            goUp().ifPresent(roads::add);
            goDown().ifPresent(roads::add);
            goLeft().ifPresent(roads::add);
            goRight().ifPresent(roads::add);
            return roads;
        }

        public int getCost() {
            return cost;
        }

        public Optional<Road> goUp() {
            if (x == 0) {
                return Optional.empty();
            }
            if (map[x - 1][y] == 1 && isBroken) {
                return Optional.empty();
            }
            if (map[x - 1][y] == 1 && !isBroken) {
                return Optional.of(new Road(x - 1, y, cost + 1, true));
            }
            if (visited[x - 1][y][isBroken ? 1 : 0] != 0) {
                return Optional.empty();
            }
            return Optional.of(new Road(x - 1, y, cost + 1, isBroken));
        }

        public Optional<Road> goDown() {
            if (x == map.length - 1) {
                return Optional.empty();
            }
            if (map[x + 1][y] == 1 && isBroken) {
                return Optional.empty();
            }
            if (map[x + 1][y] == 1 && !isBroken) {
                return Optional.of(new Road(x + 1, y, cost + 1, true));
            }
            if (visited[x + 1][y][isBroken ? 1 : 0] != 0) {
                return Optional.empty();
            }
            return Optional.of(new Road(x + 1, y, cost + 1, isBroken));
        }

        public Optional<Road> goLeft() {
            if (y == 0) {
                return Optional.empty();
            }
            if (map[x][y - 1] == 1 && isBroken) {
                return Optional.empty();
            }
            if (map[x][y - 1] == 1 && !isBroken) {
                return Optional.of(new Road(x, y - 1, cost + 1, true));
            }
            if (visited[x][y - 1][isBroken ? 1 : 0] != 0) {
                return Optional.empty();
            }
            return Optional.of(new Road(x, y - 1, cost + 1, isBroken));
        }

        public Optional<Road> goRight() {
            if (y == map[0].length - 1) {
                return Optional.empty();
            }
            if (map[x][y + 1] == 1 && isBroken) {
                return Optional.empty();
            }
            if (map[x][y + 1] == 1 && !isBroken) {
                return Optional.of(new Road(x, y + 1, cost + 1, true));
            }
            if (visited[x][y + 1][isBroken ? 1 : 0] != 0) {
                return Optional.empty();
            }
            return Optional.of(new Road(x, y + 1, cost + 1, isBroken));
        }

    }

}