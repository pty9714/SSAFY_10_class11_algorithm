package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> visited = new HashMap<>();

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] { 0, N });
        int time = Integer.MAX_VALUE;
        int way = 0;
        visited.put(N, 0);
        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            int repeat = data[0];
            int point = data[1];
            if (point < 0) {
                continue;
            }
            if (repeat > time) {
                break;
            }
            if (point == K) {
                time = repeat;
                way++;
                continue;
            }
            int next = repeat + 1;
            addToQueue(queue, visited, point + 1, next);
            addToQueue(queue, visited, point - 1, next);
            addToQueue(queue, visited, point * 2, next);
        }

        System.out.println(time);
        System.out.println(way);

    }

    public static void addToQueue(Queue<int[]> queue, HashMap<Integer, Integer> visited, int point, int next) {
        if (point < 0) {
            return;
        }
        if (visited.containsKey(point) && visited.get(point) < next) {
            return;
        }
        queue.add(new int[] { next, point });
        visited.put(point, next);
    }

}

// bfs
// 각 경우의 수에 따라서 queue 활용하기
// 방문처리 했는데도 안됨