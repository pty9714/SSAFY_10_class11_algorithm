import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] paths = { { 1, 3, 10 }, { 1, 4, 20 }, { 2, 3, 4 }, { 2, 4, 6 }, { 3, 5, 20 }, { 4, 5, 6 } };
        int[] answer = solution.solution(5, paths, new int[] { 1, 2 }, new int[] { 5 });
        System.out.println(answer[0] + " " + answer[1]);
    }

    public static ArrayList<Peek> peekList = new ArrayList<>();
    public static ArrayList<Peek> visited = new ArrayList<>();

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        for (int i = 0; i <= n; i++) {
            peekList.add(new Peek(i));
        }

        for (int[] path : paths) {
            Peek peek1 = peekList.get(path[0]);
            Peek peek2 = peekList.get(path[1]);
            peek1.addNeighbor(peek2, path[2]);
            peek2.addNeighbor(peek1, path[2]);
        }

        for (int gate : gates) {
            peekList.get(gate).setGate();
        }

        for (int summit : summits) {
            peekList.get(summit).setSummit();
        }

        PriorityQueue<Road> roads = new PriorityQueue<>();
        for (int gate : gates) {
            Road road = new Road(peekList.get(gate), peekList.get(gate));
            roads.add(road);
        }

        int[] answer = { 0, Integer.MAX_VALUE };
        while (!roads.isEmpty()) {
            Road road = roads.poll();
            // System.out.println(road.start.index + " " + road.now.index + " " +
            // road.intensity);
            if (visited.contains(road.now)) {
                continue;
            }
            visited.add(road.now);
            if (road.isVisitedSummit) {
                if (answer[1] < road.intensity) {
                    continue;
                }
                if (answer[1] == road.intensity) {
                    if (answer[0] < road.summit.index) {
                        continue;
                    }
                }
                answer[0] = road.summit.index;
                answer[1] = road.intensity;
            }
            roads.addAll(road.getNextRoads());
        }
        return answer;
    }

    public static class Peek {
        int index;
        int value = 0; // 0은 쉼터, 1은 출발지, 2는 정상
        Map<Peek, Integer> neighbors = new HashMap<>();

        public Peek(int index) {
            this.index = index;
        }

        public void addNeighbor(Peek peek, int weight) {
            neighbors.put(peek, weight);
        }

        public void setSummit() {
            this.value = 2;
        }

        public void setGate() {
            this.value = 1;
        }

        public boolean isSummit() {
            return this.value == 2;
        }

        public boolean isGate() {
            return this.value == 1;
        }

    }

    public static class Road implements Comparable<Road> {
        Peek start;
        Peek now;
        boolean isVisitedSummit;
        Peek summit;
        int intensity;

        public Road(Peek start, Peek now) {
            this.start = start;
            this.now = now;
        }

        public void setIntensity(int intensity) {
            if (this.intensity < intensity) {
                this.intensity = intensity;
            }
        }

        public ArrayList<Road> getNextRoads() {
            ArrayList<Road> roads = new ArrayList<>();
            for (Peek peek : now.neighbors.keySet()) {
                if (visited.contains(peek)) {
                    continue;
                }
                Road road = new Road(start, peek);
                road.intensity = this.intensity;
                if (peek.isSummit()) {
                    if (isVisitedSummit) {
                        continue;
                    }
                    road.isVisitedSummit = true;
                    road.summit = peek;
                }
                road.setIntensity(now.neighbors.get(peek));
                roads.add(road);
            }
            return roads;
        }

        @Override
        public int compareTo(Road o) {
            return this.intensity - o.intensity;
        }
    }
}

// peek까지 한번만 방문하면 된다.
// 틀린 케이스가 있어서, 어디가 틀렸는지 확인이 안된다.